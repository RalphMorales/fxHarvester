package org.ralphmorales.fx.fxHarvester;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class FxHarvesterApplication {
	
	public static void main(String[]args) {
		SpringApplication.run(FxHarvesterApplication.class, args);
	}

}
