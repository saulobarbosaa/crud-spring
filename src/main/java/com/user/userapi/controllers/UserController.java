package com.user.userapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.userapi.models.UserModel;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserModel> findById(@PathVariable Integer id) {
		
		return ResponseEntity.ok().body(new UserModel(1, "Joao", "joao@mail.com", "123"));
	}
	
}
