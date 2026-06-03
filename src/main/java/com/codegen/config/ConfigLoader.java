package com.codegen.config;

import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public final class ConfigLoader {

    public static ProjectConfig load(Path configPath) {
        LoaderOptions loaderOptions = new LoaderOptions();
        Constructor constructor = new Constructor(ProjectConfig.class, loaderOptions);
        Yaml yaml = new Yaml(constructor);
        try (InputStream inputStream = Files.newInputStream(configPath)) {
            ProjectConfig config = yaml.load(inputStream);
            if (config == null) {
                throw new IllegalArgumentException("Config file is empty: " + configPath);
            }
            validate(config, configPath);
            return config;
        } catch (IOException ex) {
            throw new IllegalStateException("Failed to read config file: " + configPath, ex);
        }
    }

    private static void validate(ProjectConfig config, Path configPath) {
        if (isBlank(config.getProject().getBasePackage())) {
            throw new IllegalArgumentException("project.basePackage is required in " + configPath);
        }
        boolean hasDdl = !isBlank(config.getDdl());
        boolean hasDatasource = config.getDatasource() != null
                && !isBlank(config.getDatasource().getUrl());
        if (!hasDdl && !hasDatasource) {
            throw new IllegalArgumentException(
                    "必须配置 'ddl' 或 'datasource.url' 中的至少一个: " + configPath);
        }
    }

    private static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    private ConfigLoader() {
    }
}
