package com.kristian.catalogoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAutoConfiguration
public class CatalogoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogoApiApplication.class, args);
	}

}
