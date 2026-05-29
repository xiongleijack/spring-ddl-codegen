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
            description = "Path to DDL file (supports multiple CREATE TABLE statements)",
            required = true
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

        List<TableDefinition> tables = DdlParser.parseFile(ddl);
        if (tables.isEmpty()) {
            throw new IllegalArgumentException("No CREATE TABLE statement found in DDL: " + ddl);
        }

        CodeGenerator generator = new CodeGenerator(projectConfig, projectRoot, dryRun, write);
        generator.generateAll(tables);
    }
}
