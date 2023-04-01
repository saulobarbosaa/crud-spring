package com.user.userapi.config;

import com.user.userapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import java.util.List;

import com.user.userapi.models.UserModel;

@Configuration
@Profile("local")
public class LocalConfig {

	@Autowired
	private UserRepository repository;

	@Bean
	public void startDB() {
		UserModel u1 = new UserModel(null, "saulo", "saulo@mail.com", "123");
		repository.save(u1);
	}

}
