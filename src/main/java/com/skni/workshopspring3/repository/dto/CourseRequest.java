package com.skni.workshopspring3.repository.dto;

import com.skni.workshopspring3.repository.model.CourseTypeEnum;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class CourseRequest {

    @NotBlank(message = "Please enter name of course.")
    @Size(min = 4, max = 20)
    private String name;

    @NotNull(message = "Please enter number of years.")
    @Min(1)
    @Max(9)
    private Integer numberOfYears;

    @NotBlank(message = "Please enter university.")
    @Size(min = 4, max = 20)
    private String university;

    @NotNull(message = "Please enter course type.")
    private CourseTypeEnum courseType;
}
