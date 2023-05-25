package com.nomise.inventory.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "inventory")
public class InventoryConfiguration {

    private DatabaseConfiguration databaseConfiguration;

}
