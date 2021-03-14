package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "peaks")
public class PeakEntity {

    @Id
    private Integer id;

  //  @NotEmpty(message = "Please enter name ")
    private String name;

    //@NotNull(message = "Please enter height ")
    private Integer height;

   // @NotEmpty(message = "Please enter mountain range ")
    private String mountain_range;

   // @NotEmpty(message = "Please enter county ")
    private String county;
}
