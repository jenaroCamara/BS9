package com.example.jpadto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // Inform to Spring that we are going to use Feign
public class JpadtoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpadtoApplication.class, args);
	}

}
