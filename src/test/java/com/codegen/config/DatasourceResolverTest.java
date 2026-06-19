package com.codegen.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DatasourceResolverTest {

    @TempDir
    Path tempDir;

    @Test
    void resolveBuildsUrlFromHostAndDatabase() throws Exception {
        Path dsFile = tempDir.resolve("datasources.yaml");
        Files.write(dsFile, Arrays.asList(
                "mysql_local:",
                "  host: localhost",
                "  port: 3306",
                "  username: root",
                "  password: secret"
        ));

        ProjectConfig.DatasourceSection section = DatasourceResolver.resolve(
                "mysql_local",
                "bond_basic",
                Collections.singletonList("t_order"),
                dsFile.toString(),
                tempDir.resolve("codegen.yaml")
        );

        assertEquals("root", section.getUsername());
        assertEquals("secret", section.getPassword());
        assertEquals(Collections.singletonList("t_order"), section.getTables());
        assertTrue(section.getUrl().startsWith("jdbc:mysql://localhost:3306/bond_basic"));
    }

    @Test
    void resolveUsesFullUrlWhenConfigured() throws Exception {
        Path dsFile = tempDir.resolve("datasources.yaml");
        Files.write(dsFile, Arrays.asList(
                "legacy_dev:",
                "  url: jdbc:mysql://db-host:3306/legacy_db?useSSL=false",
                "  username: ops",
                "  password: pwd"
        ));

        ProjectConfig.DatasourceSection section = DatasourceResolver.resolve(
                "legacy_dev",
                "ignored",
                Collections.<String>emptyList(),
                dsFile.toString(),
                tempDir.resolve("codegen.yaml")
        );

        assertEquals("jdbc:mysql://db-host:3306/legacy_db?useSSL=false", section.getUrl());
    }

    @Test
    void configLoaderResolvesDatasourceRef() throws Exception {
        Path dsFile = tempDir.resolve("datasources.yaml");
        Files.write(dsFile, Arrays.asList(
                "mysql_local:",
                "  host: 127.0.0.1",
                "  username: root",
                "  password: pwd"
        ));

        Path codegen = tempDir.resolve("codegen.yaml");
        Files.write(codegen, Arrays.asList(
                "datasource: mysql_local",
                "datasourcesFile: " + dsFile.toString().replace("\\", "/"),
                "",
                "project:",
                "  basePackage: com.example.demo",
                "  author: test",
                "  database: bond_basic",
                "",
                "tables:",
                "  - t_user",
                "",
                "ddl: sql/schema.sql"
        ));

        ProjectConfig config = ConfigLoader.load(codegen);

        assertEquals("com.example.demo", config.getProject().getBasePackage());
        assertEquals("root", config.getDatasource().getUsername());
        assertTrue(config.getDatasource().getUrl().contains("/bond_basic"));
        assertEquals(Collections.singletonList("t_user"), config.getDatasource().getTables());
    }
}
