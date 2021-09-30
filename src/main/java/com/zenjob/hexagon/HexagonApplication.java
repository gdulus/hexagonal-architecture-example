package com.zenjob.hexagon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class HexagonApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexagonApplication.class, args);
	}
}
