package com.jewellery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class MinankJewelleryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinankJewelleryApplication.class, args);
	}

	/*
	 * @Bean public CorsFilter corsFilter() { UrlBasedCorsConfigurationSource source
	 * = new UrlBasedCorsConfigurationSource(); CorsConfiguration config = new
	 * CorsConfiguration(); config.setAllowCredentials(true);
	 * config.addAllowedOrigin("*"); config.addAllowedHeader("*");
	 * config.addAllowedMethod("OPTION"); config.addAllowedMethod("GET");
	 * config.addAllowedMethod("PUT"); config.addAllowedMethod("POST");
	 * config.addAllowedMethod("DELETE"); source.registerCorsConfiguration("/*",
	 * config); return new CorsFilter(source); }
	 */
}
