package com.example.demo.controller;

import com.example.demo.entity.StudentEntity;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatusCode;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("students")
public class StudentController {
	@Autowired
	StudentService studentService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity show(
		@RequestParam(name = "facilitator_id", required = true) Integer facilitatorId,
		@RequestParam(name = "page", defaultValue = "1") Integer page,
		@RequestParam(name = "limit", defaultValue = "5") Integer limit,
		@RequestParam(name = "sort", defaultValue = "id") String sort,
		@RequestParam(name = "order", defaultValue = "asc") String order,
		@RequestParam(name = "name_like", defaultValue = "") String nameLike,
		@RequestParam(name = "loginId_like", defaultValue = "") String loginIdLike
	) {
		if(!nameLike.equals("") && !loginIdLike.equals(""))
			return new ResponseEntity(HttpStatusCode.valueOf(400));
		if(!Arrays.asList("id", "name", "loginId").contains(sort))
			return new ResponseEntity(HttpStatusCode.valueOf(400));
		if(!Arrays.asList("asc", "desc").contains(order))
			return new ResponseEntity(HttpStatusCode.valueOf(400));

		if(sort.equals("loginId")) sort = "login_id";

		String likeKey = null;
		String likeVal = null;
		if(!nameLike.equals("")) {
		    likeKey = "name";
			likeVal = nameLike;
		} else if(!loginIdLike.equals("")) {
			likeKey = "login_id";
			likeVal = loginIdLike;
		}

		List<StudentEntity> studentList = null;
		if(likeKey != null)
			studentList = studentService.searchWithLike(
				facilitatorId,
				likeKey,
				likeVal,
				page,
				limit,
				sort,
				order
			);
		studentList = studentService.search(
			facilitatorId,
			page,
			limit,
			sort,
			order
		);

		if(studentList == null) return new ResponseEntity(HttpStatusCode.valueOf(400));
		if(studentList.size() == 0) return new ResponseEntity(HttpStatusCode.valueOf(404));
		Map<String, Object> result = new HashMap<>();
		result.put("students", new ArrayList<>());
		result.put("totalCount", studentList.size());
		for(StudentEntity student : studentList) {
			Map<String, Object> studentMap = new HashMap<>();
			Map<String, Object> classroomMap = new HashMap<>();
			studentMap.put("id", student.getId());
			studentMap.put("name", student.getName());
			studentMap.put("loginId", student.getLoginId());
			classroomMap.put("id", student.getClassId());
			classroomMap.put("name", student.getClassName());
			studentMap.put("classroom", classroomMap);
			((List)result.get("students")).add(studentMap);
		}
		return new ResponseEntity(result, HttpStatusCode.valueOf(200));
	}
}
