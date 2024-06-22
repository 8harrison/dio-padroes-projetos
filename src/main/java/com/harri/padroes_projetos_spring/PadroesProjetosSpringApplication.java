package com.harri.padroes_projetos_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PadroesProjetosSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadroesProjetosSpringApplication.class, args);
	}

}
