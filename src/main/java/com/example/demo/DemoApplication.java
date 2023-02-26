package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.SecureRandom;
import java.util.Base64;

@SpringBootApplication
@Slf4j
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		SecureRandom random = new SecureRandom();
		byte[] clientIdBytes = new byte[20];
		random.nextBytes(clientIdBytes);
		String clientId = Base64.getUrlEncoder().encodeToString(clientIdBytes);
		log.info("random client id",clientId);

		byte[] clientSecretBytes = new byte[20];
		random.nextBytes(clientSecretBytes);
		String clientSecret = Base64.getUrlEncoder().encodeToString(clientSecretBytes);
		log.info("random client secret",clientSecret);
	}

}
