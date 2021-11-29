package com.skni.workshopspring3.repo;

import com.skni.workshopspring3.repo.uni.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findByUniversity(String university);
}
