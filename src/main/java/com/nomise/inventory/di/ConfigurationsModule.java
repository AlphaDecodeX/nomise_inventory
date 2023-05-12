package com.nomise.inventory.di;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nomise.inventory.configuration.DatabaseConfiguration;
import com.nomise.inventory.configuration.InventoryConfiguration;
import com.zaxxer.hikari.HikariDataSource;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.jackson2.Jackson2Config;
import org.jdbi.v3.jackson2.Jackson2Plugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

@Configuration
@EnableConfigurationProperties(InventoryConfiguration.class)
public class ConfigurationsModule {

    @Bean
    public Jdbi jdbi(InventoryConfiguration inventoryConfiguration, ObjectMapper objectMapper) {
        TransactionAwareDataSourceProxy proxy = new TransactionAwareDataSourceProxy(
                createDataSource(inventoryConfiguration.getDatabaseConfiguration()));
        Jdbi jdbi = Jdbi.create(proxy);
        jdbi.installPlugin(new SqlObjectPlugin());
        jdbi.installPlugin(new Jackson2Plugin());
        jdbi.getConfig(Jackson2Config.class).setMapper(objectMapper);

        return jdbi;
    }

    private HikariDataSource createDataSource(DatabaseConfiguration databaseConfig) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(databaseConfig.getUrl());
        dataSource.setUsername(databaseConfig.getUser());
        dataSource.setPassword(databaseConfig.getPassword());
        dataSource.setMinimumIdle(databaseConfig.getMinPoolSize());
        dataSource.setMaximumPoolSize(databaseConfig.getMaxPoolSize());
        dataSource.setIdleTimeout(databaseConfig.getMaxIdleTime());
        dataSource.setMaxLifetime(databaseConfig.getMaxLifeTime());
        dataSource.setAutoCommit(databaseConfig.isAutoCommit());
        dataSource.setReadOnly(databaseConfig.isReadOnly());
        dataSource.setConnectionInitSql(databaseConfig.getTestStatement());
        dataSource.setConnectionTimeout(databaseConfig.getConnectionTimeout());
        if (!databaseConfig.getPoolName().isBlank()) {
            dataSource.setPoolName(databaseConfig.getPoolName());
        }
        return dataSource;
    }


}
