package com.karur.mcp_site_management_server.config.auto.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Slf4j
@Component
public class DatabaseAutoConfig {

    @Autowired
    private DatabaseProperties databaseProperties;

    @Autowired
    private ConfigurableListableBeanFactory configurableListableBeanFactory;

    @PostConstruct
    public void setup() {
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) this.configurableListableBeanFactory;

        databaseProperties.getPostgres().forEach((key, config) -> {
            var packageNames = config.getPackageNames();

            // Extract the DISTINCT bean registration token names
            String dataSourceBeanName = packageNames.getDatasource();
            String jdbcTokenName = packageNames.getNamedParameterJdbcTemplate();
            String emFactoryBeanName = packageNames.getContainerEntityManagerFactory();
            String txManagerBeanName = packageNames.getPlatformTransactionManager();

            // 1. Build and Register Dynamic HikariDataSource safely inside a functional provider
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(HikariDataSource.class, () -> {
                HikariConfig hikariConfig = new HikariConfig();
                hikariConfig.setJdbcUrl(config.getJdbcUrl());
                hikariConfig.setUsername(config.getUsername());
                hikariConfig.setPassword(config.getPassword());
                hikariConfig.setDriverClassName(config.getDriverClassName());
                hikariConfig.setSchema(config.getSchema());

                // Fix: Name the pool explicitly based on your postgres configuration key maps
                hikariConfig.setPoolName(key + "-HikariPool");

                // Safe property checks for Hikari metrics limits
                var hikariProps = config.getHikari();
                int maxPoolSize = (hikariProps.getMaximumPoolSize() != null) ? hikariProps.getMaximumPoolSize() : 10;
                int minIdle = (hikariProps.getMinimumIdle() != null) ? hikariProps.getMinimumIdle() : maxPoolSize;

                hikariConfig.setMaximumPoolSize(maxPoolSize);
                hikariConfig.setMinimumIdle(minIdle);

                if (hikariProps.getConnectionTimeout() != null) hikariConfig.setConnectionTimeout(hikariProps.getConnectionTimeout());
                if (hikariProps.getIdleTimeout() != null) hikariConfig.setIdleTimeout(hikariProps.getIdleTimeout());
                if (hikariProps.getMaxLifetime() != null) hikariConfig.setMaxLifetime(hikariProps.getMaxLifetime());
                if (hikariProps.getConnectionTestQuery() != null) hikariConfig.setConnectionTestQuery(hikariProps.getConnectionTestQuery());

                return new HikariDataSource(hikariConfig);
            });
            // FIX: Saved into dataSourceBeanName key string
            defaultListableBeanFactory.registerBeanDefinition(dataSourceBeanName, beanDefinitionBuilder.getBeanDefinition());

            // 2. Build and Register NamedParameterJdbcTemplate using constructor injection reference
            BeanDefinitionBuilder beanDefinitionBuilder2 = BeanDefinitionBuilder.rootBeanDefinition(NamedParameterJdbcTemplate.class);
            beanDefinitionBuilder2.addConstructorArgReference(dataSourceBeanName); // Safe cross-reference link by name string
            // FIX: Saved into jdbcTokenName key string
            defaultListableBeanFactory.registerBeanDefinition(jdbcTokenName, beanDefinitionBuilder2.getBeanDefinition());

            // 3. LocalContainerEntityManagerFactoryBean with explicit connection properties for logs
            BeanDefinitionBuilder beanDefinitionBuilder3 = BeanDefinitionBuilder.rootBeanDefinition(LocalContainerEntityManagerFactoryBean.class);
            Properties jpaProperties = new Properties();
            jpaProperties.put("hibernate.default_schema",config.getSchema());
            jpaProperties.put("hibernate.dialect", config.getJpa().getProperties().getHibernate().getDialect());
            jpaProperties.put("hibernate.format_sql", config.getJpa().getProperties().getHibernate().getFormat_sql());
            jpaProperties.put("hibernate.show_sql", config.getJpa().getShowSql());
            jpaProperties.put("hibernate.hbm2ddl.auto", config.getJpa().getProperties().getHibernate().getDdlAuto());
            jpaProperties.put("hibernate.physical_naming_strategy", "org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy");
// ADD THESE: Explicitly pass configuration values to satisfy Hibernate's telemetry logger
            jpaProperties.put("hibernate.connection.url", config.getJdbcUrl());
            jpaProperties.put("hibernate.connection.username", config.getUsername());
            jpaProperties.put("hibernate.connection.password", config.getPassword());

// Pass your pool sizes to stop Hibernate from printing 'undefined'
            var hikariProps = config.getHikari();
            int maxPoolSize = (hikariProps.getMaximumPoolSize() != null) ? hikariProps.getMaximumPoolSize() : 10; // 10 is standard fallback
            int minIdle = (hikariProps.getMinimumIdle() != null) ? hikariProps.getMinimumIdle() : maxPoolSize;

            jpaProperties.put("hibernate.connection.pool_size", String.valueOf(maxPoolSize)); // Maps to Maximum pool size

            beanDefinitionBuilder3.addPropertyReference("dataSource", dataSourceBeanName);
            beanDefinitionBuilder3.addPropertyValue("jpaVendorAdapter", new HibernateJpaVendorAdapter());
            beanDefinitionBuilder3.addPropertyValue("jpaProperties", jpaProperties);
            beanDefinitionBuilder3.addPropertyValue("packagesToScan", packageNames.getEntity());
            beanDefinitionBuilder3.addPropertyValue("persistenceUnitName", key);
            defaultListableBeanFactory.registerBeanDefinition(emFactoryBeanName, beanDefinitionBuilder3.getBeanDefinition());


            // 4. Build and Register PlatformTransactionManager referencing the active factory bean definition
            BeanDefinitionBuilder beanDefinitionBuilder4 = BeanDefinitionBuilder.rootBeanDefinition(JpaTransactionManager.class);
            beanDefinitionBuilder4.addPropertyReference("entityManagerFactory", emFactoryBeanName); // Bridges directly to EM factory
            // FIX: Saved into txManagerBeanName key string
            defaultListableBeanFactory.registerBeanDefinition(txManagerBeanName, beanDefinitionBuilder4.getBeanDefinition());

            log.info("Pipeline dynamic configuration registered successfully for context key tenant: [{}]", key);
        });
    }

}