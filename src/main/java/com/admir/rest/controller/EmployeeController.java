package com.admir.rest.controller;


import com.admir.rest.model.Employee;
import com.admir.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    public String getEmployee(@PathVariable("id") Long id) {
        return "Fetching the employee details for the id "+id;
    }

    @PostMapping("/employees")
    public String saveEmployee(@RequestBody Employee employee){
       return "Saving the employee details to the database "+employee ;
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
        System.out.println("Updating the employee data for the id "+id);
        return employee;
    }
    @DeleteMapping("/employees")
    public String deleteEmployee(@RequestParam("id") Long id){
        return "Deleting the employees details for the id "+id;
    }
}
