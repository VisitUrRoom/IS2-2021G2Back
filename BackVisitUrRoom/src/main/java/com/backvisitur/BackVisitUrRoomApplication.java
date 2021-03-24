package com.backvisitur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//
@SpringBootApplication
public class BackVisitUrRoomApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackVisitUrRoomApplication.class, args);
	}

}
