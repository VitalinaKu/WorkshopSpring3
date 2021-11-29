package com.skni.workshopspring3.repo.uni;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "course")
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long course_id;

    @Column(name = "name")
    private String name;

    @Column(name = "number_of_hours")
    private Integer numberOfHours;

    @Column(name = "university")
    private String university;

    @Column(name = "course_type")
    @Enumerated(EnumType.STRING)
    private CourseTypeEnum courseType;
}
