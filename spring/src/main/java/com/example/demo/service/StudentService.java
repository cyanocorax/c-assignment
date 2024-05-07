package com.example.demo.service;

import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;

@Service
@Transactional
public class StudentService {
	@Autowired
	StudentRepository studentRepository;

	public List<StudentEntity> findAll() {
		return studentRepository.findAll();
	}

	public List<StudentEntity> search(
		Integer facilitatorId,
		Integer page,
		Integer limit,
		String sort,
		String order
	) {
		List<StudentEntity> studentList = studentRepository.search(
			facilitatorId,
			sort,
			order
		);
		return fetch(studentList, page, limit);
	}

	public List<StudentEntity> searchWithLike(
		Integer facilitatorId,
		String likeKey,
		String likeVal,
		Integer page,
		Integer limit,
		String sort,
		String order
	) {
		List<StudentEntity> studentList = studentRepository.searchWithLike(
			facilitatorId,
			likeKey,
			likeVal,
			sort,
			order
		);
		return fetch(studentList, page, limit);
	}

	private List<StudentEntity> fetch(List<StudentEntity> studentList, int page, int limit) {
		List<List<StudentEntity>> lstLst = new ArrayList<>();
		int lstInx = 0;
		lstLst.add(new ArrayList<>());
		for(int i = 0; i < studentList.size(); i++) {
			lstLst.get(lstInx).add(studentList.get(i));
			if((i + 1) % limit == 0) {
				lstLst.add(new ArrayList<>());
				lstInx++;
			}
		}
		if(page > lstLst.size() - 1) return null;
		return lstLst.get(page);
	}
}
