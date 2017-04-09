package org.ralphmorales.fx.fxHarvester;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FxHarvesterApplication {
	
	public static void main(String[]args) {
		SpringApplication.run(FxHarvesterApplication.class, args);
	}

}
