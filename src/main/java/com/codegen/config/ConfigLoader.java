package com.codegen.config;

import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ConfigLoader {

    public static ProjectConfig load(Path configPath) {
        Map<String, Object> raw = loadRaw(configPath);
        ProjectConfig config = mapToProjectConfig(raw);
        resolveDatasource(raw, config, configPath);
        validate(config, configPath);
        return config;
    }

    @SuppressWarnings("unchecked")
    private static void resolveDatasource(Map<String, Object> raw, ProjectConfig config, Path configPath) {
        Object datasourceRaw = raw.get("datasource");
        if (datasourceRaw == null) {
            return;
        }

        if (datasourceRaw instanceof String) {
            String ref = ((String) datasourceRaw).trim();
            List<String> tables = mergeTables(config.getTables(), null);
            ProjectConfig.DatasourceSection resolved = DatasourceResolver.resolve(
                    ref,
                    config.getProject().getDatabase(),
                    tables,
                    config.getDatasourcesFile(),
                    configPath
            );
            config.setDatasource(resolved);
            return;
        }

        if (datasourceRaw instanceof Map) {
            ProjectConfig.DatasourceSection inline = mapToDatasourceSection((Map<String, Object>) datasourceRaw);
            inline.setTables(mergeTables(config.getTables(), inline.getTables()));
            config.setDatasource(inline);
            return;
        }

        throw new IllegalArgumentException("datasource 必须是标识符字符串或内联配置对象: " + configPath);
    }

    private static List<String> mergeTables(List<String> topLevel, List<String> inline) {
        if (topLevel != null && !topLevel.isEmpty()) {
            return topLevel;
        }
        return inline == null ? new ArrayList<String>() : inline;
    }

    @SuppressWarnings("unchecked")
    private static Map<String, Object> loadRaw(Path configPath) {
        LoaderOptions loaderOptions = new LoaderOptions();
        Yaml yaml = new Yaml(new Constructor(Map.class, loaderOptions));
        try (InputStream inputStream = Files.newInputStream(configPath)) {
            Object loaded = yaml.load(inputStream);
            if (!(loaded instanceof Map)) {
                throw new IllegalArgumentException("Config file is empty or invalid: " + configPath);
            }
            return (Map<String, Object>) loaded;
        } catch (IOException ex) {
            throw new IllegalStateException("Failed to read config file: " + configPath, ex);
        }
    }

    @SuppressWarnings("unchecked")
    private static ProjectConfig mapToProjectConfig(Map<String, Object> raw) {
        LoaderOptions loaderOptions = new LoaderOptions();
        Yaml yaml = new Yaml(new Constructor(ProjectConfig.class, loaderOptions));
        // 重新 dump/load 映射标准字段，跳过 datasource（可能是字符串）
        Map<String, Object> copy = new java.util.LinkedHashMap<String, Object>(raw);
        copy.remove("datasource");
        ProjectConfig config = yaml.load(yaml.dump(copy));
        if (config == null) {
            config = new ProjectConfig();
        }
        if (raw.containsKey("tables")) {
            config.setTables(asStringList(raw.get("tables")));
        }
        if (raw.containsKey("datasourcesFile")) {
            config.setDatasourcesFile(asString(raw.get("datasourcesFile")));
        }
        return config;
    }

    @SuppressWarnings("unchecked")
    private static ProjectConfig.DatasourceSection mapToDatasourceSection(Map<String, Object> map) {
        LoaderOptions loaderOptions = new LoaderOptions();
        Yaml yaml = new Yaml(new Constructor(ProjectConfig.DatasourceSection.class, loaderOptions));
        return yaml.load(yaml.dump(map));
    }

    @SuppressWarnings("unchecked")
    private static List<String> asStringList(Object value) {
        if (!(value instanceof List)) {
            return new ArrayList<String>();
        }
        List<String> result = new ArrayList<String>();
        for (Object item : (List<?>) value) {
            if (item != null) {
                result.add(item.toString());
            }
        }
        return result;
    }

    private static String asString(Object value) {
        return value == null ? null : value.toString();
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
                    "必须配置 'ddl' 或 'datasource'（标识符或内联 url）中的至少一个: " + configPath);
        }
    }

    private static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    private ConfigLoader() {
    }
}
