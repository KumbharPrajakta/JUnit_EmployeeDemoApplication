package com.ait.dao;

import com.ait.model.Employee;
import com.ait.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class EmployeeDaoImplTest {
    @Autowired
    EmployeeDaoImpl dao;

    @MockBean
    EmployeeRepository repo;

    @Test
    public void getAllDataTest(){
        when(repo.findAll()).thenReturn(Stream.of(new Employee(101,"Prajakta",9975891741L,50000.0),new Employee(102,"Spruha",4546845212L,80000.0)).collect(Collectors.toList()));
        assertEquals(2,dao.getAllEmployee().size());
    }

    @Test
    public void saveData(){
        Employee employee = new Employee(101,"Prajakta",9975891741L,50000);
        dao.saveEmployee(employee);
        verify(repo,times(1)).save(employee);
    }

    @Test
    public void update(){
        Employee employee = new Employee(101,"Prajakta",9975891741L,50000);
        dao.updateEmployee(employee);
        verify(repo,times(1)).save(employee);
    }

    @Test
    public void delete(){
        Employee employee = new Employee(101,"Prajakta",9975891741L,50000);
        dao.deleteEmployee(employee.getEmpId());
        verify(repo,times(1)).deleteById(employee.getEmpId());
    }
}
