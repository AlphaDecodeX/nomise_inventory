package com.nomise.inventory.configuration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class DatabaseConfiguration {
    private String driverClass;

    private String user;

    private String password;

    private String url;

    private int acquireIncrement;

    private int initialPoolSize;

    private int minPoolSize;

    private int maxPoolSize;

    private int maxIdleTime;

    private int maxStatements;

    private int idleConnectionTestPeriod;

    private String testStatement;

    private String poolName;

    private int connectionTimeout = 3000; //3 seconds, default is 30 seconds in HikariCP.

    private int maxLifeTime = 1800000; //30 minutes

    private boolean autoCommit = true;

    private boolean readOnly = false;

    private Map<String, String> dataSourceProperties = new HashMap<>();
}
