package hu.kosztaauto.partshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Entry point for the Kosta Auto Part Shop application.
 * This class serves as the main entry point of the Spring Boot application.
 * It triggers the application startup by calling the {@link SpringApplication#run(Class, String...)} method.
 */
@SpringBootApplication
public class KostaAutoPartShopApplication {
	/**
	 * Main method which serves as the entry point for the Spring Boot application.
	 *
	 * @param args Command-line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(KostaAutoPartShopApplication.class, args);

	}
}
