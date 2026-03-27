package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    // GET all employees
    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        List<EmployeePayrollData> empDataList =
                employeePayrollService.getEmployeePayrollData();
        ResponseDTO responseDTO = new ResponseDTO(
                "Get Employee Payroll Data", empDataList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // GET employee by ID
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(
            @PathVariable("empId") long empId) {
        EmployeePayrollData empData =
                employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO responseDTO = new ResponseDTO(
                "Get Employee Payroll Data for ID: " + empId, empData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // POST create employee
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(
            @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData =
                employeePayrollService
                        .createEmployeePayrollData(employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO(
                "Created Employee Payroll Data Successfully", empData);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // PUT update employee
    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(
            @PathVariable("empId") long empId,
            @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData =
                employeePayrollService
                        .updateEmployeePayrollData(empId, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO(
                "Updated Employee Payroll Data Successfully", empData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // DELETE employee
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(
            @PathVariable("empId") long empId) {
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO responseDTO = new ResponseDTO(
                "Deleted Employee Payroll Data for ID: " + empId, null);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}