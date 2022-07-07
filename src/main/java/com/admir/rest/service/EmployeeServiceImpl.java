package com.admir.rest.service;

import com.admir.rest.model.Employee;
import com.admir.rest.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl  implements EmployeeService{
    @Autowired
    private EmployeRepository eRepository;


    @Override
    public List<Employee> getEmployees() {
       return eRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee){
        return eRepository.save(employee);
    }

    @Override
    public Employee getSingleEmployee(Long id) {
        Optional<Employee> employee = eRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        throw new RuntimeException("Aucun n'utilisateur ne correspond à cet id "+id);
    }

    @Override
    public void deleteEmployee(Long id) {
        eRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return eRepository.save(employee);
    }
}
