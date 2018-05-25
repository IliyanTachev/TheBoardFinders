package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;


@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) { SpringApplication.run(AppApplication.class, args); }

	@Bean
	public ModelMapper getModelMapper()
	{
		return new ModelMapper();
	}
}
