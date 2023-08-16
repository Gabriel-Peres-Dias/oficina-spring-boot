package com.oficina.br;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OficinaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OficinaApplication.class, args);
	}

}
