package com.you.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCloudProducerApplication_7002 {

	/**
	 * 配套修改下application.yml配置文件中
	 * server:
	 *   port: 7002
	 *
	 * config:
	 *   producer:
	 *     instance: 2
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudProducerApplication_7002.class, args);
	}

}
