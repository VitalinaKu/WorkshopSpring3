package com.skni.workshopspring3;

import java.time.LocalDate;

import com.skni.workshopspring3.repository.dto.CourseResponse;
import com.skni.workshopspring3.repository.model.Course;
import com.skni.workshopspring3.repository.model.CourseTypeEnum;
import com.skni.workshopspring3.repository.model.GenderEnum;
import com.skni.workshopspring3.repository.model.Student;
import com.skni.workshopspring3.service.CourseService;
import com.skni.workshopspring3.service.StudentService;
import com.skni.workshopspring3.service.TeacherService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WorkshopSpring3Application {

	public static void main(String[] args) {
		SpringApplication.run(WorkshopSpring3Application.class, args);
		System.out.println("The database was created.");
	}

	@Bean
	CommandLineRunner init(CourseService courseService, StudentService studentService, TeacherService teacherService) {
		return (args) -> {
			CourseResponse cr = new CourseResponse();
			cr.setName("Informatyka");
			cr.setUniversity("Hogwarts");
			cr.setNumberOfYears(3);
			cr.setCourseType(CourseTypeEnum.INZYNIER);
			Course course = courseService.addCourse(cr);

			Student studentMale = studentService.addStudent(
					"Adam",
					"Nowak",
					LocalDate.of(1996, 05,10),
					GenderEnum.MALE,
					course
			);

			Student studentFemale = studentService.addStudent(
					"Anna",
					"Kowalska",
					LocalDate.of(1993, 10,22),
					GenderEnum.FEMALE,
					course
			);

			System.out.println(studentMale);
			System.out.println(studentFemale);

			System.out.println(studentService.findAllByLastName("Nowak"));

			System.out.println(studentService.getStudentByGenderAndByCourseType(GenderEnum.MALE, CourseTypeEnum.INZYNIER));
			System.out.println(studentService.getStudentByGenderAndByCourseType(GenderEnum.FEMALE, CourseTypeEnum.LICENCJAT));

			System.out.println(studentService.getAllStudents());
			System.out.println(studentService.deleteStudentById(studentMale.getId()));
			System.out.println(studentService.getAllStudents());

			System.out.println(teacherService.getTeachersByCourse(9)); //getting teachers by course
		};
	}
}
