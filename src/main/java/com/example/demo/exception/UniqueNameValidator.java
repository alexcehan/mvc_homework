package com.example.demo.exception;

import com.example.demo.repository.PeakRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameValidator implements ConstraintValidator<UniquePeakName, String> {

    @Autowired
    private PeakRepository peakRepository;

    @Override
    public boolean isValid(String name,
                           ConstraintValidatorContext context) {

        if(peakRepository.existsByName(name)) {
            return false;
        }
        return true;
    }
}
