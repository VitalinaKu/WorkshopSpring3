package com.skni.workshopspring3.repo.uni;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "course")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long course_id;

    @Column(name = "name")
    private String name;

    @Column(name = "number_of_years")
    private Integer numberOfYears;

    @Column(name = "university")
    private String university;

    @Column(name = "course_type")
    @Enumerated(EnumType.STRING)
    private CourseTypeEnum courseType;
}
