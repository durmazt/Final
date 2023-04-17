package me.durmaz.finalproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class FinalProjectApplication {

	@Configuration
	public class CorsConfiguration {
		@Bean
		WebMvcConfigurer corsConfigurer() {
			return new WebMvcConfigurer() {
				@Override
				public void addCorsMappings(CorsRegistry registry) {
					registry.addMapping( "/**" );
				}
			};
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(FinalProjectApplication.class, args);
	}

}
