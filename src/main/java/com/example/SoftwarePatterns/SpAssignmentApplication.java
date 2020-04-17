package com.example.SoftwarePatterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpAssignmentApplication extends SpringBootServletInitializer {


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpAssignmentApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpAssignmentApplication.class, args);
	}
}
