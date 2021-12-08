package com.skni.workshopspring3.repo.dto;

import com.skni.workshopspring3.repo.uni.CourseTypeEnum;
import lombok.Data;

@Data
public class CourseResponse {
    private String name;
    private Integer numberOfYears;
    private String university;
    private CourseTypeEnum courseType;
}
