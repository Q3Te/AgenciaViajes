package com.masterjava.inicio;
	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;
	import org.springframework.boot.autoconfigure.domain.EntityScan;
	import org.springframework.context.annotation.Bean;
	import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
	import org.springframework.web.client.RestTemplate;

@EntityScan(basePackages="com.masterjava.modelos")
@EnableJpaRepositories(basePackages={ "com.masterjava.repository"})
@SpringBootApplication  (scanBasePackages={ "com.masterjava.controller", "com.masterjava.service"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	RestTemplate getTemplate() {
		return new RestTemplate();
	}
}