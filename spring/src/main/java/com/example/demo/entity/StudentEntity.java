package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "students")
public class StudentEntity {
	@Id
	@GeneratedValue
	private int id;

	@Column(nullable = false)
	private int teacher_id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String login_id;

	@Column(nullable = false)
	private int class_id;

	@Column(nullable = false)
	private String class_name;
}
