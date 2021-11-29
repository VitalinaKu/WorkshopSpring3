package com.skni.workshopspring3.uni;

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

    @Column(name = "numberOfHours")
    private Integer numberOfHours;

    @Column(name = "university")
    private String university;

    @Column(name = "courseType")
    @Enumerated(EnumType.STRING)
    private CourseTypeEnum courseType;
}
