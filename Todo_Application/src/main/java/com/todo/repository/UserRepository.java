package com.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, String> {

}
