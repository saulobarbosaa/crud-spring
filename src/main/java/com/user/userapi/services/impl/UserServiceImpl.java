package com.user.userapi.services.impl;

import java.util.Optional;

import com.user.userapi.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.userapi.models.UserModel;
import com.user.userapi.repositories.UserRepository;
import com.user.userapi.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserModel findById(Integer id) {
		Optional<UserModel> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado na base de dados"));
	}
}
