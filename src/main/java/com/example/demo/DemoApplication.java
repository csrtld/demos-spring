package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.vault.annotation.VaultPropertySource;

@SpringBootApplication
@VaultPropertySource(value = "#{'secret/my/${spring.profiles.active}'}")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
