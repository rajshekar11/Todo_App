package com.todo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class GlobalExceptionHandler {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetails> userExceptionHandler(UserException ue,WebRequest wr){
		MyErrorDetails me=new MyErrorDetails();
		me.setTimestamp(LocalDateTime.now());
		me.setMessage(ue.getMessage());
		me.setDescription(wr.getDescription(false));
		return new ResponseEntity<>(me,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> globalExceptionHandler(Exception e,WebRequest wr){
		MyErrorDetails me=new MyErrorDetails();
		me.setTimestamp(LocalDateTime.now());
		me.setMessage(e.getMessage());
		me.setDescription(wr.getDescription(false));
		return new ResponseEntity<>(me,HttpStatus.BAD_REQUEST);
	}
}
