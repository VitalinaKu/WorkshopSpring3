package com.skni.workshopspring3.service;

import com.skni.workshopspring3.repository.CourseRepository;
import com.skni.workshopspring3.repository.StudentRepository;
import com.skni.workshopspring3.repository.TeacherRepository;
import com.skni.workshopspring3.repository.dto.CourseResponse;
import com.skni.workshopspring3.repository.model.Course;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.skni.workshopspring3.service.mapper.CourseMapper.course2CourseResponseMapper;
import static com.skni.workshopspring3.service.mapper.CourseMapper.courseResponse2CourseMapper;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public List<CourseResponse> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream().map(course2CourseResponseMapper).collect(Collectors.toList());
    }

    public List<Course> getCourseByUniversity(String university){
        return courseRepository.findByUniversity(university);
    }

    public Course addCourse(CourseResponse request) {
        return courseRepository.save(courseResponse2CourseMapper.apply(request));
    }

    public boolean updateCourse(long id, CourseResponse updatedCourse) {
        Optional<Course> currentCourse = courseRepository.findById(id);
        if(currentCourse.isPresent()) {
            Course newCourse = currentCourse.get();
            if(updatedCourse.getName() != null) {
                newCourse.setName(updatedCourse.getName());
            }
            if(updatedCourse.getNumberOfYears() != null) {
                newCourse.setNumberOfYears(updatedCourse.getNumberOfYears());
            }
            if(updatedCourse.getUniversity() != null) {
                newCourse.setUniversity(updatedCourse.getUniversity());
            }
            if(updatedCourse.getCourseType() != null) {
                newCourse.setCourseType(updatedCourse.getCourseType());
            }
            newCourse.setCourse_id(id);
            courseRepository.save(newCourse);
            return true;
        }
        return false;
    }

    public boolean deleteCourseByName(String name) {
        Course course = courseRepository.findByName(name);
        if (course != null){
            studentRepository.delete(studentRepository.findAllByCourse(course));
            teacherRepository.delete(teacherRepository.findAllByCourse(course));
            courseRepository.delete(course);
            return true;
        }
        return false;
    }
}
