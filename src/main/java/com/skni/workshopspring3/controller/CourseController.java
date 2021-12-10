package com.skni.workshopspring3.controller;
import com.skni.workshopspring3.repository.dto.CourseResponse;
import com.skni.workshopspring3.repository.model.Course;
import com.skni.workshopspring3.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}