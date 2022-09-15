package br.com.dino.dinogames;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching //10.4 liberar o uso de cache inicializador no pedido repository
@SpringBootApplication
public class DinogamesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DinogamesApplication.class, args);
	}

}
