package com.skni.workshopspring3.repo;

import com.skni.workshopspring3.repo.uni.CourseTypeEnum;
import com.skni.workshopspring3.repo.uni.GenderEnum;
import com.skni.workshopspring3.repo.uni.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAll();

    List<Student> findAllByGenderAndCourse_CourseType(GenderEnum gender, CourseTypeEnum courseType);

    List<Student> findAllByLastname(String lastname);
}
  /*
	@Query(
			value = "SELECT distinct p.* FROM person p JOIN address a ON p.address_id = a.id WHERE p.gender = ?1 " +
					"AND a.country = ?2",
			nativeQuery = true)
	List<Person> findAllByGenderAndCountry(String gender, String country);*/