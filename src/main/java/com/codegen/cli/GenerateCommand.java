package com.codegen.cli;

import com.codegen.config.ConfigLoader;
import com.codegen.config.ProjectConfig;
import com.codegen.ddl.DdlParser;
import com.codegen.generator.CodeGenerator;
import com.codegen.model.TableDefinition;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Command(
        name = "spring-ddl-codegen",
        mixinStandardHelpOptions = true,
        version = "0.1.0",
        description = "Generate Spring Boot code from DDL using FreeMarker templates"
)
public class GenerateCommand implements Runnable {

    @Option(
            names = {"-c", "--config"},
            description = "Path to codegen.yaml (defaults to codegen.yaml in the same directory as the jar)"
    )
    private Path config;

    @Option(
            names = {"-f", "--ddl"},
            description = "Path to DDL file (supports multiple CREATE TABLE statements). Falls back to 'ddl' in config if not specified."
    )
    private Path ddl;

    @Option(
            names = {"-o", "--output"},
            description = "Project root to write generated files (defaults to config 'output' field, or parent of config file's parent directory)"
    )
    private Path output;

    @Option(
            names = {"--dry-run"},
            description = "Print files that would be generated without writing"
    )
    private boolean dryRun;

    @Option(
            names = {"--write"},
            description = "Write generated files to disk"
    )
    private boolean write;

    @Parameters(
            arity = "0..*",
            hidden = true,
            description = "Subcommand placeholder for future extensions"
    )
    private List<String> remainder;

    @Override
    public void run() {
        if (config == null) {
            config = resolveDefaultConfig();
        }

        ProjectConfig projectConfig = ConfigLoader.load(config);
        Path projectRoot = resolveProjectRoot(projectConfig);

        Path ddlPath = resolveDdlPath(projectConfig);
        List<TableDefinition> tables = DdlParser.parseFile(ddlPath);
        if (tables.isEmpty()) {
            throw new IllegalArgumentException("No CREATE TABLE statement found in DDL: " + ddlPath);
        }

        boolean shouldWrite = !dryRun;
        CodeGenerator generator = new CodeGenerator(projectConfig, projectRoot, dryRun, shouldWrite);
        generator.generateAll(tables);
    }

    /**
     * 解析项目根目录（代码输出基准目录）。
     * 优先级：--output 命令行参数 > 配置文件 output 字段（相对于配置文件目录解析）。
     *
     * @param projectConfig 项目配置
     * @return 项目根目录绝对路径
     */
    private Path resolveProjectRoot(ProjectConfig projectConfig) {
        if (output != null) {
            return output.toAbsolutePath();
        }
        Path configDir = config.toAbsolutePath().getParent();
        if (projectConfig.getOutput() != null && !projectConfig.getOutput().isEmpty()) {
            return configDir.resolve(projectConfig.getOutput()).normalize();
        }
        throw new CommandLine.ParameterException(
                new CommandLine(this),
                "Output directory not specified. Use --output option or set 'output' in codegen.yaml."
        );
    }

    /**
     * 解析DDL文件路径。
     * 优先使用命令行 --ddl 参数；若未指定，回退到配置文件中的 ddl 字段（相对于配置文件所在目录解析）。
     *
     * @param projectConfig 项目配置
     * @return 解析后的DDL文件绝对路径
     */
    private Path resolveDdlPath(ProjectConfig projectConfig) {
        if (ddl != null) {
            return ddl;
        }
        if (projectConfig.getDdl() != null && !projectConfig.getDdl().isEmpty()) {
            Path configDir = config.toAbsolutePath().getParent();
            return configDir.resolve(projectConfig.getDdl());
        }
        throw new CommandLine.ParameterException(
                new CommandLine(this),
                "DDL file not specified. Use --ddl option or set 'ddl' in codegen.yaml."
        );
    }
}
