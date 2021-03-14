package com.example.demo.dto;


import com.example.demo.exception.UniquePeakName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PeakCreationRequest {


    private int id;

    @NotBlank
    @UniquePeakName
    private String name;

    @NotNull
    @Min(500)
    @Max(2544)
    private Integer height;

    @NotNull
    private String mountain_range;

    @NotNull
    private String county;




}
