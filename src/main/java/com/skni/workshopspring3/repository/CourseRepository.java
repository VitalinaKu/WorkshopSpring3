package com.skni.workshopspring3.repository;

import com.skni.workshopspring3.repository.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findById(Long id);
    Course findByName(String name);
    List<Course> findByUniversity(String university);
    void deleteById(Long id);
}
