package com.skni.workshopspring3.service;

import com.skni.workshopspring3.repo.CourseRepository;
import com.skni.workshopspring3.repo.uni.Course;
import com.skni.workshopspring3.repo.uni.CourseTypeEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public Course addCourse(String name, Integer number_of_years, String university, CourseTypeEnum courseType) {

        Course course = Course.builder()
                .name(name)
                .numberOfYears(number_of_years)
                .university(university)
                .courseType(courseType)
                .build();

        return courseRepository.save(course);
    }
}