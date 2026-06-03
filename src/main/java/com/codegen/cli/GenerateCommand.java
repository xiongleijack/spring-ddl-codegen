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
            description = "Path to codegen.yaml in the target project",
            required = true
    )
    private Path config;

    @Option(
            names = {"-f", "--ddl"},
            description = "Path to DDL file (supports multiple CREATE TABLE statements). Falls back to 'ddl' in config if not specified."
    )
    private Path ddl;

    @Option(
            names = {"-o", "--output"},
            description = "Project root to write generated files (defaults to config file directory)"
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
        if (!write && !dryRun) {
            throw new CommandLine.ParameterException(
                    new CommandLine(this),
                    "Specify --dry-run to preview or --write to generate files."
            );
        }

        ProjectConfig projectConfig = ConfigLoader.load(config);
        Path projectRoot = output != null ? output : config.toAbsolutePath().getParent();
        if (projectRoot == null) {
            throw new IllegalStateException("Unable to resolve project root from config path: " + config);
        }

        Path ddlPath = resolveDdlPath(projectConfig);
        List<TableDefinition> tables = DdlParser.parseFile(ddlPath);
        if (tables.isEmpty()) {
            throw new IllegalArgumentException("No CREATE TABLE statement found in DDL: " + ddlPath);
        }

        CodeGenerator generator = new CodeGenerator(projectConfig, projectRoot, dryRun, write);
        generator.generateAll(tables);
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
