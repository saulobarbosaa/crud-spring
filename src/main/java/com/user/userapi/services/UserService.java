package com.user.userapi.services;

import com.user.userapi.models.UserModel;
import com.user.userapi.dto.UserDTO;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {

	UserModel findById(Integer id);

	List<UserModel> findAll();

	UserModel create(UserDTO obj);

	UserModel update(UserDTO obj);

	void delete(Integer id);
}
