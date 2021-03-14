package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PeakUpdateRequest {


    private int id;


    private String name;


    @Min(500)
    @Max(2544)
    private Integer height;


    private String mountain_range;


    private String county;

}
