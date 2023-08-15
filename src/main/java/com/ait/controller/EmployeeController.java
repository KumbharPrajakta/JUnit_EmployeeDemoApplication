package com.ait.controller;

import com.ait.model.Employee;
import com.ait.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl service;

    @PostMapping("/create")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok(service.saveEmployee(employee));
    }

    @GetMapping("/read")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return ResponseEntity.ok(service.getAllEmployee());
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int empId ,@RequestBody Employee employee){
        return ResponseEntity.ok(service.updateEmployee(employee));
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteById(@PathVariable int empId){
        service.deleteEmployee(empId);
       return ResponseEntity.ok("deleted");
    }
}
