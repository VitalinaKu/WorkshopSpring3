package com.skni.workshopspring3.service.mapper;

import com.skni.workshopspring3.repository.dto.CourseResponse;
import com.skni.workshopspring3.repository.model.Course;

import java.util.function.Function;

public class CourseMapper {
    public static Function<Course, CourseResponse> course2CourseResponseMapper = item -> {
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setName(item.getName());
        courseResponse.setNumberOfYears(item.getNumberOfYears());
        courseResponse.setUniversity(item.getUniversity());
        courseResponse.setCourseType(item.getCourseType());
        return courseResponse;
    };

    public static Function<CourseResponse, Course> courseResponse2CourseMapper = item -> {
        Course course = new Course();
        course.setName(item.getName());
        course.setNumberOfYears(item.getNumberOfYears());
        course.setUniversity(item.getUniversity());
        course.setCourseType(item.getCourseType());
        return course;
    };
}
