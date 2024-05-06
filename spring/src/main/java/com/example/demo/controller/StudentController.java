package com.example.demo.controller;

import com.example.demo.entity.StudentEntity;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("students")
public class StudentController {
	@Autowired
	StudentService studentService;

	@RequestMapping(method = RequestMethod.GET)
	public List<StudentEntity> show(@RequestParam Map<String, String> params) {
		return studentService.findAll();
	}
}
