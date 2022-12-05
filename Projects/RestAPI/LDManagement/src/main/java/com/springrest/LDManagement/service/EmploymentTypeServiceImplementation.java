package com.springrest.LDManagement.service;

import com.springrest.LDManagement.entities.EmploymentType;
import com.springrest.LDManagement.repository.EmploymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmploymentTypeServiceImplementation {

    @Autowired
    EmploymentTypeRepository employmentTypeRepository;


    public List<EmploymentType> getEmploymentType() {
        List<EmploymentType> employmentTypes = employmentTypeRepository.findAll();
        if (employmentTypes.size() > 0) {
            return employmentTypes;
        }
        else {
            return null;
        }
    }
}