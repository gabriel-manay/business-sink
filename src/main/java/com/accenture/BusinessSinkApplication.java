package com.accenture;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;

import com.accenture.entity.Transaction;

@SpringBootApplication
public class BusinessSinkApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(BusinessSinkApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BusinessSinkApplication.class, args);
	}
	
	@Bean
	public Consumer<Message<Transaction>> processTransactions() {	
		return message -> {
			logger.info("Mensaje recibido {}",message.getPayload().toString());

		};
	}

}
