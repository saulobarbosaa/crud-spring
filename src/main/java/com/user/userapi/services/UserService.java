package com.user.userapi.services;

import com.user.userapi.models.UserModel;
import com.user.userapi.dto.UserDTO;

import java.util.List;

public interface UserService {

	UserModel findById(Integer id);

	List<UserModel> findAll();

	UserModel create(UserDTO obj);
}
