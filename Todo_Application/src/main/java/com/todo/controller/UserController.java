package com.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo.exception.UserException;
import com.todo.model.UserModel;
import com.todo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService uSer;
	
	@PostMapping("/user")
	public ResponseEntity<UserModel> createUser(@RequestBody UserModel user) throws UserException{
		UserModel saved=uSer.createUser(user);
		return new ResponseEntity<UserModel>(saved,HttpStatus.CREATED);
	}
	
	@GetMapping("/user/{email}")
	public ResponseEntity<UserModel> getUserByEmail(@PathVariable("email") String email) throws UserException{
		UserModel user=uSer.findUserByEmail(email);
		return new ResponseEntity<UserModel>(user,HttpStatus.OK);
	}
	
	@GetMapping("/signIn")
	public ResponseEntity<String> userLogIn(Authentication auth) throws UserException{
		UserModel user=uSer.findUserByEmail(auth.getName());
		return new ResponseEntity<String>("LogIn successfull "+auth.getName(),HttpStatus.OK);
	}
	
}
