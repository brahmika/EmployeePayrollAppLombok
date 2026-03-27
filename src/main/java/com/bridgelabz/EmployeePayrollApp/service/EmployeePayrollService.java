package com.bridgelabz.EmployeePayrollApp.service;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeePayrollDTO;
import com.bridgelabz.EmployeePayrollApp.model.EmployeePayrollData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    private final List<EmployeePayrollData> employeeList = new ArrayList<>();
    private int counter = 1;

    // GET ALL
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        log.info("Fetching all employees from service layer");
        return employeeList;
    }

    // GET BY ID
    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        log.info("Fetching employee with ID: {}", empId);
        return employeeList.stream()
                .filter(emp -> emp.getId() == empId)
                .findFirst()
                .orElse(null);
    }

    // CREATE
    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO dto) {
        log.info("Creating employee in service layer: {}", dto);

        EmployeePayrollData emp = new EmployeePayrollData();
        emp.setId(counter++);
        emp.setName(dto.getName());
        emp.setSalary(dto.getSalary());

        employeeList.add(emp);
        log.info("Employee added: {}", emp);

        return emp;
    }

    // UPDATE
    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO dto) {
        log.info("Updating employee with ID: {}", empId);

        EmployeePayrollData emp = getEmployeePayrollDataById(empId);
        if (emp != null) {
            emp.setName(dto.getName());
            emp.setSalary(dto.getSalary());
            log.info("Employee updated: {}", emp);
        }
        return emp;
    }

    // DELETE
    @Override
    public void deleteEmployeePayrollData(int empId) {
        log.warn("Deleting employee with ID: {}", empId);
        employeeList.removeIf(emp -> emp.getId() == empId);
    }
}