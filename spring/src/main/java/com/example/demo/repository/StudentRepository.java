package com.example.demo.repository;

import com.example.demo.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
	@Query(value = "SELECT * FROM students WHERE " +
	    "teacher_id = :facilitatorId " +
		"ORDER BY :sort :order", nativeQuery = true)
	public List<StudentEntity> search(
		@Param("facilitatorId") Integer facilitatorId,
		@Param("sort") String sort,
		@Param("order") String order
	);

	@Query(value = "SELECT * FROM students WHERE " +
	    "teacher_id = :facilitatorId AND " +
		":likeKey LIKE %:likeVal% " +
		"ORDER BY :sort :order", nativeQuery = true)
	public List<StudentEntity> searchWithLike(
		@Param("facilitatorId") Integer facilitatorId,
		@Param("likeKey") String likeKey,
		@Param("likeVal") String likeVal,
		@Param("sort") String sort,
		@Param("order") String order
	);
}
