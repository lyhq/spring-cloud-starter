package com.you;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @EnableTurbine: 开启 Turbine
 */
@EnableTurbine
@SpringBootApplication
public class SpringCloudHystrixTurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudHystrixTurbineApplication.class, args);
	}

}
