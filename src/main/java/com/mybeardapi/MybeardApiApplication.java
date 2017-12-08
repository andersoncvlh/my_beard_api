package com.mybeardapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.mybeardapi.config.properties.MybeardApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(MybeardApiProperty.class)
public class MybeardApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybeardApiApplication.class, args);
	}
}
