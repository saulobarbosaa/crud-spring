package com.user.userapi.services;

import com.user.userapi.models.UserModel;

public interface UserService {

	UserModel findById(Integer id);
	
}
