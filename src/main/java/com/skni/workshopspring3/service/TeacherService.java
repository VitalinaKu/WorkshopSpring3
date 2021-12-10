package com.skni.workshopspring3.service;

import com.skni.workshopspring3.repository.TeacherRepository;
import com.skni.workshopspring3.repository.model.Teacher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getTeachersByCourse(int course_id) {
        return teacherRepository.findByCourse(course_id);
    }
}
