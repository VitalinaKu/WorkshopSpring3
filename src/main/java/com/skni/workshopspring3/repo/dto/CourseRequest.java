package com.skni.workshopspring3.repo.dto;

import com.skni.workshopspring3.repo.uni.CourseTypeEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CourseRequest {

    @NotBlank(message = "Please enter name of course.")
    @Size(min = 4, max = 20)
    private String name;

    @NotBlank(message = "Please enter number of years.")
    @Size(max = 1)
    private Integer numberOfYears;

    @NotBlank(message = "Please enter university.")
    @Size(min = 4, max = 20)
    private String university;

    @NotBlank(message = "Please enter course type.")
    @Size(min = 4, max = 20)
    private CourseTypeEnum courseType;
}
