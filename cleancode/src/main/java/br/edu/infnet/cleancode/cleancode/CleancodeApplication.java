package br.edu.infnet.cleancode.cleancode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CleancodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CleancodeApplication.class, args);
	}

}
