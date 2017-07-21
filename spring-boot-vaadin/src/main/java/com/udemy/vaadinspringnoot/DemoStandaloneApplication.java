package com.udemy.vaadinspringnoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class DemoStandaloneApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(DemoStandaloneApplication.class, args);
	}

	private static Class<DemoStandaloneApplication> applicationClass = DemoStandaloneApplication.class;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}
}
