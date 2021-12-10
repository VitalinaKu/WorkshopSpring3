package com.skni.workshopspring3.repository.dto;

import com.skni.workshopspring3.repository.model.CourseTypeEnum;
import lombok.Data;

@Data
public class CourseResponse {
    private String name;
    private Integer numberOfYears;
    private String university;
    private CourseTypeEnum courseType;
}
