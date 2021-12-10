package com.skni.workshopspring3.controller;
import com.skni.workshopspring3.repository.dto.CourseResponse;
import com.skni.workshopspring3.repository.model.Course;
import com.skni.workshopspring3.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@AllArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/course")
    public List<CourseResponse> getCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/course/{university}")
    public ResponseEntity<List<Course>> getCourseByUniversity(@PathVariable String university) {
        List<Course> result = courseService.getCourseByUniversity(university);

        if (result != null)
            return new ResponseEntity<>(result, HttpStatus.OK);
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/course")
    public void addCourse(@RequestBody CourseResponse course) {
        courseService.addCourse(course);
    }

    @PutMapping("/course/{id}")
    public void updateCourse(@RequestBody CourseResponse newCourse, @PathVariable Long id) {
        courseService.updateCourse(id, newCourse);
    }

    @DeleteMapping("/course/{name}")
        public ResponseEntity<?> deleteCourseByName(@PathVariable String name) {
        return courseService.deleteCourseByName(name) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}