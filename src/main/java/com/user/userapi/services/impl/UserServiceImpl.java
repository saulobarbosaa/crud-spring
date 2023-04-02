package com.user.userapi.services.impl;

import com.user.userapi.models.UserModel;
import com.user.userapi.repositories.UserRepository;
import com.user.userapi.services.UserService;
import com.user.userapi.dto.UserDTO;

import com.user.userapi.services.exceptions.DataIntegratyViolationException;
import com.user.userapi.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;

	@Autowired
	private ModelMapper mapper;
	
	@Override
	public UserModel findById(Integer id) {
		Optional<UserModel> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado na base de dados"));
	}

	@Override
	public List<UserModel> findAll() {
		return repository.findAll();
	}

	@Override
	public UserModel create(UserDTO obj) {
		findByEmail(obj);
		return repository.save(mapper.map(obj, UserModel.class));
	}

	private void findByEmail(UserDTO obj) {
		Optional<UserModel> user = repository.findByEmail(obj.getEmail());
		if(user.isPresent()) {
			throw new DataIntegratyViolationException("Email já cadastrado no sistema");
		}
	}

}
