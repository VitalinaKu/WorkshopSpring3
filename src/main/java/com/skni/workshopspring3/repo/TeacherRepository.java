package com.skni.workshopspring3.repo;


import com.skni.workshopspring3.repo.uni.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository <Teacher, Long> {

    @Query(
            value = "SELECT t. * FROM teacher t INNER JOIN course c ON t.course_id = c.id WHERE c.id = ?1",
            nativeQuery = true)
    List<Teacher> findByCourse(int course_id);          //niestandardowe polecenie SQL :) Czy to o to chodziło?
}

