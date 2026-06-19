package com.codegen.config;

/**
 * datasources.yaml 中的数据库实例配置（不含库名）。
 */
public class DatasourceInstance {

    private String host;
    private Integer port = 3306;
    private String username;
    private String password;
    /** 兼容旧格式：完整 JDBC URL（已含库名） */
    private String url;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean hasHost() {
        return host != null && !host.trim().isEmpty();
    }

    public boolean hasUrl() {
        return url != null && !url.trim().isEmpty();
    }
}
