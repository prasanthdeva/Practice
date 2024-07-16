package com.AgilysyProduct.Practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}

	@Bean
	public ApplicationListener<ContextClosedEvent> contextClosedListener() {
		return event -> {
			System.out.println("Context closed event received.");
		};
	}

	@Component
	public static class ContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {
		@Override
		public void onApplicationEvent(ContextRefreshedEvent event) {
			System.out.println("Context refreshed event received.");
		}
	}

}
