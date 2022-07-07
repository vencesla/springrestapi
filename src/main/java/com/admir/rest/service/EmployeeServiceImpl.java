package com.admir.rest.service;

import com.admir.rest.model.Employee;
import com.admir.rest.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl  implements EmployeeService{
    @Autowired
    private EmployeRepository eRepository;


    @Override
    public List<Employee> getEmployees() {
       return eRepository.findAll();
    }
}
