package com.skni.workshopspring3.repository;

import com.skni.workshopspring3.repository.model.Course;
import com.skni.workshopspring3.repository.model.CourseTypeEnum;
import com.skni.workshopspring3.repository.model.GenderEnum;
import com.skni.workshopspring3.repository.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAll();
    List<Student> findAllByGenderAndCourse_CourseType(GenderEnum gender, CourseTypeEnum courseType);
    List<Student> findAllByLastname(String lastname);
    Student findAllByCourse(Course id);
}
