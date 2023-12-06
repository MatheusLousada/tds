package com.turmas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TurmasApplication {

	public static void main(String[] args) {
		System.out.println("Inicializando...");
		SpringApplication.run(TurmasApplication.class, args);
	}

}
