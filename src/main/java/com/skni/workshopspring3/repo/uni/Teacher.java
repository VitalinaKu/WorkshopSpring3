package com.skni.workshopspring3.repo.uni;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teacher")
@Data
@Builder
public class Teacher {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "fullname")
    private String fullname;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

}
