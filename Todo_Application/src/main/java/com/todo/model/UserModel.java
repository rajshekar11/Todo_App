package com.todo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="User")
@Data
public class UserModel {

	@Id
	private String email;
	private String name;
	private String password;
	private String bio;
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<TaskModel> taskModels;
	
}
