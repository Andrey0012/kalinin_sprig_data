package com.kalinin.sprig_data.controller;

import com.kalinin.sprig_data.entity.Employee;

import com.kalinin.sprig_data.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployee() {
        List<Employee> allEmployee = employeeService.getAllEmployee();
        return allEmployee;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployees(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        return employee;
    }


    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }


    @PutMapping("/employees")
    public Employee updateNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployees(@PathVariable int id) {
        Employee employee=employeeService.getEmployee(id);
        employeeService.deleteEmployee(id);
        return "Employee where ID = " + id + " delete";
    }
    @GetMapping("/employees/name/{name}")
    public List<Employee> getEmployees(@PathVariable String name) {
        List<Employee> allByName = employeeService.findAllByName(name);
        return allByName;
    }
}
