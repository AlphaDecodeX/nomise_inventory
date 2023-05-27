package com.nomise.inventory.di;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nomise.inventory.configuration.DatabaseConfiguration;
import com.nomise.inventory.configuration.InventoryConfiguration;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.micrometer.common.util.StringUtils;
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
        HikariConfig configuration = new HikariConfig();
        configuration.setJdbcUrl(databaseConfig.getUrl());
        configuration.setUsername(databaseConfig.getUser());
        configuration.setPassword(databaseConfig.getPassword());
        configuration.setMinimumIdle(databaseConfig.getMinPoolSize());
        configuration.setMaximumPoolSize(databaseConfig.getMaxPoolSize());
        configuration.setIdleTimeout(databaseConfig.getMaxIdleTime());
        configuration.setMaxLifetime(databaseConfig.getMaxLifeTime());
        configuration.setAutoCommit(databaseConfig.isAutoCommit());
        configuration.setReadOnly(databaseConfig.isReadOnly());
        configuration.setConnectionTimeout(databaseConfig.getConnectionTimeout());
        if (StringUtils.isNotBlank(databaseConfig.getPoolName())) {
            configuration.setPoolName(databaseConfig.getPoolName());
        }
        return new HikariDataSource(configuration);
    }


}
