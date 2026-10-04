package com.karur.mcp_site_management_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class McpSiteManagementServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(McpSiteManagementServerApplication.class, args);
	}

}
