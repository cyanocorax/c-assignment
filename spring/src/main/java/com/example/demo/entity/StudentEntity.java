package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
public class StudentEntity {
	@Id
	@GeneratedValue
	private int id;

	@Column(name = "teacher_id", nullable = false)
	private int teacherId;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "login_id", nullable = false)
	private String loginId;

	@Column(name = "class_id", nullable = false)
	private int classId;

	@Column(name = "class_name", nullable = false)
	private String className;
}
