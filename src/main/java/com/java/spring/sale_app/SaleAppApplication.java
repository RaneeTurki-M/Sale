package com.java.spring.sale_app;

import com.java.spring.sale_app.service.SaleDocumentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ComponentScan("com.java.spring.sale_app")
@EnableMongoRepositories("com.java.spring.sale_app")
@SpringBootApplication
public class SaleAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaleAppApplication.class, args);
	}




}
