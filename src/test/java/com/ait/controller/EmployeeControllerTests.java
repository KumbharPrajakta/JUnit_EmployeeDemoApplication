package com.ait.controller;

import com.ait.model.Employee;
import com.ait.service.EmployeeServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    EmployeeServiceImpl employeeService;
    Employee employeeOne;
    Employee employeeTwo;
    List<Employee> employeeList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        employeeOne = new Employee(1, "Prajakta", 9975891741L, 45000.00);
        employeeTwo  =new Employee(2, "Spruha", 7815715765L, 50000.50);
        employeeList.add(employeeOne);
        employeeList.add(employeeTwo);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveEmployee() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(employeeOne);

        when(employeeService.saveEmployee(employeeOne)).thenReturn(employeeOne);
        this.mockMvc.perform(post("/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getAllEmployee() throws Exception{
        when(employeeService.getAllEmployee()).thenReturn(employeeList);
        this.mockMvc.perform(get("/read")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void updateEmployee() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(employeeOne);

        when(employeeService.updateEmployee(employeeOne))
                .thenReturn(employeeOne);
        this.mockMvc.perform(put("/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void deleteById() throws Exception{
        when(employeeService.deleteEmployee(1))
                .thenReturn("Successfully Deleted");
        this.mockMvc.perform(delete("/delete/1"))
                .andDo(print()).andExpect(status().isOk());
    }
}