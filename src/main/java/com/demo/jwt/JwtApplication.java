package com.demo.jwt;

import com.demo.jwt.model.User;
import com.demo.jwt.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class JwtApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
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
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		User client = new User("client","client@example.com","password",false);
		client.setPassword(passwordEncoder.encode(admin.getPassword()));
		userRepository.saveAll(Arrays.asList(admin,client));
	}
}
