package com.karur.mcp_site_management_server.config.database;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConfig {

    @Configuration
    @EnableJpaRepositories(
            basePackages = "com.karur.mcp_site_management_server.repository",
            entityManagerFactoryRef = "siteContainerEntityManagerFactory",
            transactionManagerRef = "sitePlatformTransactionManager"
    )
    public static class SiteDatabaseConfig {}
}