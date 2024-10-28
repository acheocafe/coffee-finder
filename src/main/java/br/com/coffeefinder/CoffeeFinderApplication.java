package br.com.coffeefinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories(basePackages = "br.com.coffeefinder.repository")
public class CoffeeFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeFinderApplication.class, args);
	}
}
