package com.skni.workshopspring3.uni;

import lombok.Data;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Student")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

}
