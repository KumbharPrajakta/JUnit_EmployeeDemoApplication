package com.ait.service;

import com.ait.dao.EmployeeDaoImpl;
import com.ait.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class EmployeeServiceImplTest {

    @Autowired
    EmployeeServiceImpl service;

    @MockBean
    EmployeeDaoImpl dao;

    @Test
    public void getAllDataTest(){
        when(dao.getAllEmployee()).thenReturn(Stream.of(new Employee(101,"Prajakta",9975891741L,50000.0),new Employee(102,"Spruha",4546845212L,80000.0)).collect(Collectors.toList()));
        assertEquals(2,service.getAllEmployee().size());
    }

    @Test
    public void saveData(){
        Employee employee = new Employee(101,"Prajakta",9975891741L,50000);
        service.saveEmployee(employee);
        verify(dao,times(1)).saveEmployee(employee);
    }

    @Test
    public void update(){
        Employee employee = new Employee(101,"Prajakta",9975891741L,50000);
        service.updateEmployee(employee);
        verify(dao,times(1)).updateEmployee(employee);
    }

    @Test
    public void delete(){
        Employee employee = new Employee(101,"Prajakta",9975891741L,50000);
        service.deleteEmployee(employee.getEmpId());
        verify(dao,times(1)).deleteEmployee(employee.getEmpId());
    }
}
