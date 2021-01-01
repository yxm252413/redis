package com.yxm.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BootRedis02Application {

	public static void main(String[] args) {
		SpringApplication.run(BootRedis02Application.class, args);
	}

}
