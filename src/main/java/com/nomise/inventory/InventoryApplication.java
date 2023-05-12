package com.nomise.inventory;

import com.nomise.inventory.di.ConfigurationsModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class InventoryApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(InventoryApplication.class).run(args);
	}

}
