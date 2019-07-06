package com.br.avaliacao.socioTorcedorApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SocioTorcedorApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocioTorcedorApiApplication.class, args);
	}

}
