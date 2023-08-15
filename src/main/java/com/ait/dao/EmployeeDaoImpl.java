package com.ait.dao;

import com.ait.model.Employee;
import com.ait.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDaoImpl{

    @Autowired
    EmployeeRepository repo;

    public Employee saveEmployee(Employee employee){
      return  repo.save(employee);
    }

    public List<Employee> getAllEmployee(){
        return repo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return repo.save(employee);
    }

    public void deleteEmployee(int empId){
        repo.deleteById(empId);
    }
}
