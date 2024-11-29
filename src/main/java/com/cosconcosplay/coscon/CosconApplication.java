package com.cosconcosplay.coscon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class}, scanBasePackages= {"com.cosconcosplay.coscon.repository", "com.cosconcosplay.coscon.service", "com.cosconcosplay.coscon.model", "com.cosconcosplay.coscon", "com.cosconcosplay.coscon.config", "com.cosconcosplay.coscon.controller"} )
public class CosconApplication {

	public static void main(String[] args) {
		SpringApplication.run(CosconApplication.class, args);
	}
	
}
