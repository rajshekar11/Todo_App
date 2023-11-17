package com.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Task")
@Data
public class TaskModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	@Enumerated(EnumType.STRING)
	private TaskCategory taskCategory;
	@Enumerated(EnumType.STRING)
	private TaskStatus taskStatus;
	@ManyToOne()
	private UserModel user;
	
}
