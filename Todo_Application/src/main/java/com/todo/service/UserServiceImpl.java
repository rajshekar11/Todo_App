package com.todo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.exception.UserException;
import com.todo.model.UserModel;
import com.todo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository uRep;

	@Override
	public UserModel createUser(UserModel user) throws UserException {
		// TODO Auto-generated method stub
		return uRep.save(user);
	}

	@Override
	public UserModel findUserByEmail(String email) throws UserException {
		// TODO Auto-generated method stub
		Optional<UserModel> opt= uRep.findById(email);
		if(opt.isEmpty()) {
			throw new UserException("User not registered with email: "+email);
		}
		return opt.get();
	}

}
