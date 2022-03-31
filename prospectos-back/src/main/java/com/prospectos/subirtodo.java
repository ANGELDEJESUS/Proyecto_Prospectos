package com.prospectos;

import com.prospectos.servicio.servicios;
import com.prospectos.servicio.servarchivo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@SpringBootApplication
public class subirtodo implements CommandLineRunner {
    
	@Resource
	servicios servicios;
    servarchivo servarchivo; 
	public static void main(String[] args) {
		SpringApplication.run(subirtodo.class, args);
	}

	@Override
	public void run(String... arg) throws Exception{
		servicios.deleteAll();
		servicios.init();
		
		
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
			}
		};
	}

}
