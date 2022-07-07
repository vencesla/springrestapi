package com.admir.rest.controller;


import com.admir.rest.model.Employee;
import com.admir.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    //localhost:9090/api/v1/employees
    @Autowired
    private EmployeeService eService;


    //@RequestMapping(value = "/employees", method = RequestMethod.GET)
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return eService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable("id") Long id) {
        return eService.getSingleEmployee(id);
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
       return eService.saveEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
        employee.setId(id);
        return eService.updateEmployee(employee);
    }
    @DeleteMapping("/employees")
    public void deleteEmployee(@RequestParam("id") Long id){
        eService.deleteEmployee(id);
    }
}
