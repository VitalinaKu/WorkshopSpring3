package com.skni.workshopspring3;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.skni.workshopspring3.repo.CourseRepository;
import com.skni.workshopspring3.repo.StudentRepository;
import com.skni.workshopspring3.repo.uni.Course;
import com.skni.workshopspring3.repo.uni.CourseTypeEnum;
import com.skni.workshopspring3.repo.uni.GenderEnum;
import com.skni.workshopspring3.repo.uni.Student;
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
	CommandLineRunner init(StudentRepository studentRepository, CourseRepository courseRepository) {
		return (args) -> {
			List<Student> studentList = studentRepository.findAll();
			System.out.println(studentList);
			List<Course> courseList = courseRepository.findAll();
			System.out.println(courseList);

			List<Student> maleInzynier = studentRepository.findAllByGenderAndCourse_CourseType(GenderEnum.MALE, CourseTypeEnum.INZYNIER);
			System.out.println(maleInzynier);

			List<Student> studentsLastname = studentRepository.findAllByLastname("Kowalski");
			System.out.println(studentsLastname);

			Optional<Course> courseInUniversity = courseRepository.findByUniversity("Vistula");
			System.out.println(courseInUniversity);
		};
	}
}


//	@Bean
//	CommandLineRunner init(CourseService courseService, StudentService studentService) {
//		return (args) -> {
//			Course course = courseService.addCourse("Informatyka", 3, "SGH", CourseTypeEnum.INZYNIER);
//
//			Student studentMale = studentService.addStudent(
//					"Adam",
//					"Nowak",
//					LocalDate.of(1996, 05,10),
//					GenderEnum.MALE,
//					course
//			);
////
//			Student studentFemale = studentService.addStudent(
//					"Anna",
//					"Kowalska",
//					LocalDate.of(1993, 10,22),
//					GenderEnum.FEMALE,
//					course
//			);
//
//			System.out.println(studentMale);
//			System.out.println(studentFemale);
//
//			System.out.println(studentService.findAllByLastName("Nowak"));
//
//			System.out.println(studentService.getStudentByGenderAndByCourseType(GenderEnum.MALE, CourseTypeEnum.INZYNIER));
//			System.out.println(studentService.getStudentByGenderAndByCourseType(GenderEnum.FEMALE, CourseTypeEnum.LICENCJAT));
//
//			System.out.println(studentService.getAllStudents());
//			System.out.println(studentService.deleteStudentById(student.getId()));
//			System.out.println(studentService.getAllStudents());
//
//		};
//	}
//}
