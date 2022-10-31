package com.registro.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;


@Service
@EntityScan(basePackages = {"com.registro.model"})
@EnableJpaRepositories(basePackages = {"com.registro.repositories"})
@ComponentScan(basePackages = {"com.registro.controller", "com.registro.service"})
@SpringBootApplication
public class UserApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
	

}}
		
