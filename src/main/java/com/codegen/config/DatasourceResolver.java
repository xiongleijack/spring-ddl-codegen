package com.codegen.config;

import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 将 codegen.yaml 中的 datasource 标识符解析为完整 JDBC 配置。
 * <p>
 * datasources.yaml 实例格式（推荐）：
 * <pre>
 * mysql_local:
 *   host: localhost
 *   port: 3306
 *   username: root
 *   password: secret
 * </pre>
 * 库名取自 codegen.yaml 的 project.database，由 JAR 拼入 JDBC URL。
 */
public final class DatasourceResolver {

    private static final String DEFAULT_PARAMS =
            "?useSSL=false&characterEncoding=utf8&serverTimezone=Asia/Shanghai";

    /** Claude / Cursor / JAR 共用的默认连接配置文件 */
    private static final Path DEFAULT_DATASOURCES_FILE = Paths.get("D:/tools/config/datasources.yaml");

    private DatasourceResolver() {
    }

    public static ProjectConfig.DatasourceSection resolve(
            String ref,
            String database,
            List<String> tables,
            String datasourcesFile,
            Path configPath) {

        if (isBlank(ref)) {
            throw new IllegalArgumentException("datasource 标识符不能为空");
        }

        Path dsPath = resolveDatasourcesFile(datasourcesFile, configPath);
        DatasourceInstance instance = loadInstance(dsPath, ref);

        ProjectConfig.DatasourceSection section = new ProjectConfig.DatasourceSection();
        section.setUsername(instance.getUsername());
        section.setPassword(instance.getPassword());
        section.setTables(tables == null ? new ArrayList<String>() : tables);

        if (instance.hasUrl()) {
            section.setUrl(instance.getUrl());
        } else if (instance.hasHost()) {
            if (isBlank(database)) {
                throw new IllegalArgumentException(
                        "实例 '" + ref + "' 使用 host/port 模式，必须在 project.database 中指定库名");
            }
            int port = instance.getPort() != null ? instance.getPort() : 3306;
            section.setUrl("jdbc:mysql://" + instance.getHost() + ":" + port + "/" + database + DEFAULT_PARAMS);
        } else {
            throw new IllegalArgumentException(
                    "数据源实例 '" + ref + "' 必须配置 host 或 url: " + dsPath);
        }

        return section;
    }

    static Path resolveDatasourcesFile(String datasourcesFile, Path configPath) {
        if (!isBlank(datasourcesFile)) {
            return expandUserHome(Paths.get(datasourcesFile));
        }
        if (Files.exists(DEFAULT_DATASOURCES_FILE)) {
            return DEFAULT_DATASOURCES_FILE;
        }
        Path legacyDefault = Paths.get("D:/tools/datasources.yaml");
        if (Files.exists(legacyDefault)) {
            return legacyDefault;
        }
        Path cursorDefault = expandUserHome(Paths.get("~/.cursor/config/datasources.yaml"));
        if (Files.exists(cursorDefault)) {
            return cursorDefault;
        }
        Path claudeDefault = expandUserHome(Paths.get("~/.claude/config/datasources.yaml"));
        if (Files.exists(claudeDefault)) {
            return claudeDefault;
        }
        throw new IllegalArgumentException(
                "未找到 datasources.yaml，请配置 datasourcesFile 或放置于 D:/tools/config/datasources.yaml");
    }

    @SuppressWarnings("unchecked")
    private static DatasourceInstance loadInstance(Path dsPath, String ref) {
        if (!Files.exists(dsPath)) {
            throw new IllegalArgumentException("datasources 文件不存在: " + dsPath);
        }
        LoaderOptions loaderOptions = new LoaderOptions();
        Yaml yaml = new Yaml(new Constructor(Map.class, loaderOptions));
        try (InputStream in = Files.newInputStream(dsPath)) {
            Object loaded = yaml.load(in);
            if (!(loaded instanceof Map)) {
                throw new IllegalArgumentException("datasources 文件格式错误: " + dsPath);
            }
            Map<String, Object> root = (Map<String, Object>) loaded;
            if (!root.containsKey(ref)) {
                throw new IllegalArgumentException(
                        "datasources 中未找到实例 '" + ref + "'，可用: " + root.keySet());
            }
            Object instanceRaw = root.get(ref);
            if (!(instanceRaw instanceof Map)) {
                throw new IllegalArgumentException("实例 '" + ref + "' 配置格式错误");
            }
            return mapToInstance((Map<String, Object>) instanceRaw);
        } catch (IOException e) {
            throw new IllegalStateException("读取 datasources 文件失败: " + dsPath, e);
        }
    }

    private static DatasourceInstance mapToInstance(Map<String, Object> map) {
        DatasourceInstance instance = new DatasourceInstance();
        instance.setHost(asString(map.get("host")));
        instance.setUsername(asString(map.get("username")));
        instance.setPassword(asString(map.get("password")));
        instance.setUrl(asString(map.get("url")));
        Object port = map.get("port");
        if (port instanceof Number) {
            instance.setPort(((Number) port).intValue());
        } else if (port != null) {
            instance.setPort(Integer.parseInt(port.toString()));
        }
        return instance;
    }

    static Path expandUserHome(Path path) {
        String pathStr = path.toString().replace('\\', '/');
        if (pathStr.equals("~")) {
            return Paths.get(System.getProperty("user.home"));
        }
        if (pathStr.startsWith("~/")) {
            String[] parts = pathStr.substring(2).split("/");
            String home = System.getProperty("user.home");
            Path result = Paths.get(home);
            for (String part : parts) {
                if (!part.isEmpty()) {
                    result = result.resolve(part);
                }
            }
            return result.normalize();
        }
        return path.isAbsolute() ? path.normalize() : path.toAbsolutePath().normalize();
    }

    private static String asString(Object value) {
        return value == null ? null : value.toString();
    }

    private static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
