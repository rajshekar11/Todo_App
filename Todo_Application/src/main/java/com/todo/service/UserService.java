package com.todo.service;

import java.util.List;

import com.todo.exception.UserException;
import com.todo.model.TaskModel;
import com.todo.model.UserModel;

public interface UserService {

	public UserModel createUser(UserModel user) throws UserException;
	
	public UserModel findUserByEmail(String email) throws UserException;
	
	
	
}
