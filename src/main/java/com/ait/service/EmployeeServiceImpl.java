package com.ait.service;

import com.ait.dao.EmployeeDaoImpl;
import com.ait.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl{

    @Autowired
    EmployeeDaoImpl dao;

    public Employee saveEmployee(Employee employee){
       return dao.saveEmployee(employee);
    }

    public List<Employee> getAllEmployee(){
        return dao.getAllEmployee();
    }

    public Employee updateEmployee(Employee employee){
        return dao.updateEmployee(employee);
    }

    public String deleteEmployee(int empId){
        dao.deleteEmployee(empId);
        return "deleted";
    }
}
