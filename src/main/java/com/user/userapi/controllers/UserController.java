package com.user.userapi.controllers;

import com.user.userapi.dto.UserDTO;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.user.userapi.models.UserModel;
import com.user.userapi.services.UserService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private ModelMapper mapper;

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Integer id) {

		return ResponseEntity.ok().body(mapper.map(service.findById(id), UserDTO.class));
	}

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<UserModel> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> mapper.map(x, UserDTO.class)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<UserDTO> create(@RequestBody UserDTO obj) {
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}").buildAndExpand(service.create(obj).getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
