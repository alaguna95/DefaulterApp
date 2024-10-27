package com.galibox.defaulterApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.modulith.Modulith;

@SpringBootApplication
@Modulith (sharedModules = "shared")
public class DefaulterAppApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(DefaulterAppApplication.class, args);
	}

}
