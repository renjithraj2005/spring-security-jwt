package com.demo.jwt;

import com.demo.jwt.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class JwtApplication extends SpringBootServletInitializer implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return super.configure(builder);
	}

	@Override
	public void run(String... args) throws Exception {
		User admin = new User("admin","admin@example.com","password",true);

		//userService.signup(admin);

		User client = new User("client","client@example.com","password",false);


		//userService.signup(client);
	}
}
