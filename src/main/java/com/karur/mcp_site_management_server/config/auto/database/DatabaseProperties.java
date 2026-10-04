package com.karur.mcp_site_management_server.config.auto.database;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Slf4j
@Data
@Configuration
@ConfigurationProperties(prefix = "database")
public class DatabaseProperties {

    private HikariProperties defaultHikariProperties = new HikariProperties();
    private Map<String, PostgresDataSourceProperties> postgres = new HashMap<>();

    @PostConstruct
    public void init() {
        postgres.values().forEach(postgresDataSourceProperties -> applyDefault(postgresDataSourceProperties.getHikari()));
    }

    //private BinaryOperator returnElseIfNullAndElseNonNull = (a, b) -> Objects.isNull(a) &&Objects.nonNull(b)?b:a;

    private void applyDefault(HikariProperties hikari) {
        hikari.setConnectionTimeout(Optional.ofNullable(hikari.getConnectionTimeout()).orElse(defaultHikariProperties.getConnectionTimeout()));
        hikari.setIdleTimeout(Optional.ofNullable(hikari.getIdleTimeout()).orElse(defaultHikariProperties.getIdleTimeout()));
        hikari.setLeakDetectionThreshold(Optional.ofNullable(hikari.getLeakDetectionThreshold()).orElse(defaultHikariProperties.getLeakDetectionThreshold()));
        hikari.setMaxLifetime(Optional.ofNullable(hikari.getMaxLifetime()).orElse(defaultHikariProperties.getMaxLifetime()));
        hikari.setMinimumIdle(Optional.ofNullable(hikari.getMinimumIdle()).orElse(defaultHikariProperties.getMinimumIdle()));
        hikari.setMaximumPoolSize(Optional.ofNullable(hikari.getMaximumPoolSize()).orElse(defaultHikariProperties.getMaximumPoolSize()));
        hikari.setSchema(Optional.ofNullable(hikari.getSchema()).orElse(defaultHikariProperties.getSchema()));
        hikari.setConnectionTestQuery(Optional.ofNullable(hikari.getConnectionTestQuery()).orElse(defaultHikariProperties.getConnectionTestQuery()));
    }

    @Data
    public static class HikariProperties {
        private Integer connectionTimeout;
        private Integer idleTimeout;
        private Integer leakDetectionThreshold;
        private Integer maxLifetime;
        private Integer minimumIdle;
        private Integer maximumPoolSize;
        private String schema;
        private String connectionTestQuery;
    }

    @Data
    public static class PostgresDataSourceProperties {
        private String schema;
        private PackageNameProperties packageNames = new PackageNameProperties();
        private String jdbcUrl;
        private String username;
        private String password;
        private String driverClassName;
        private HikariProperties hikari = new HikariProperties();
        private JpaProperties jpa = new JpaProperties();
    }

    @Data
    public static class JpaProperties {
        private String showSql;
        private Properties properties = new Properties();
    }

    @Data
    public static class Properties {
        private HibernateProperties hibernate = new HibernateProperties();
    }

    @Data
    public static class HibernateProperties {
        private String ddlAuto;
        private String dialect;
        private String format_sql;
    }

    @Data
    public static class PackageNameProperties {
        private String datasource;
        private String namedParameterJdbcTemplate;
        private String containerEntityManagerFactory;
        private String platformTransactionManager;
        private String entity;
        private String repository;
    }
}