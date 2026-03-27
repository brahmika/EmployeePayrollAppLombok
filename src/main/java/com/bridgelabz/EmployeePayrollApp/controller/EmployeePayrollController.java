package com.bridgelabz.EmployeePayrollApp.controller;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeePayrollDTO;
import com.bridgelabz.EmployeePayrollApp.dto.ResponseDTO;
import com.bridgelabz.EmployeePayrollApp.model.EmployeePayrollData;
import com.bridgelabz.EmployeePayrollApp.service.IEmployeePayrollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeeService;

    @GetMapping("/")
    public ResponseDTO getAllEmployees() {
        log.info("GET all employees");
        List<EmployeePayrollData> list = employeeService.getEmployeePayrollData();
        return new ResponseDTO("Fetched all employees", list);
    }

    @GetMapping("/get/{id}")
    public ResponseDTO getEmployeeById(@PathVariable int id) {
        log.info("GET employee by ID: {}", id);
        EmployeePayrollData data = employeeService.getEmployeePayrollDataById(id);
        return new ResponseDTO("Fetched employee", data);
    }

    @PostMapping("/create")
    public ResponseDTO createEmployee(@RequestBody EmployeePayrollDTO dto) {
        log.info("POST create employee");
        EmployeePayrollData data = employeeService.createEmployeePayrollData(dto);
        return new ResponseDTO("Employee created", data);
    }

    @PutMapping("/update/{id}")
    public ResponseDTO updateEmployee(@PathVariable int id,
                                      @RequestBody EmployeePayrollDTO dto) {
        log.info("PUT update employee {}", id);
        EmployeePayrollData data = employeeService.updateEmployeePayrollData(id, dto);
        return new ResponseDTO("Employee updated", data);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDTO deleteEmployee(@PathVariable int id) {
        log.info("DELETE employee {}", id);
        employeeService.deleteEmployeePayrollData(id);
        return new ResponseDTO("Employee deleted", id);
    }
}