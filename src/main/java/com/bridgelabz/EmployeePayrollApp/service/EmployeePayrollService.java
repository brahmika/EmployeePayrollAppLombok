package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class EmployeePayrollService
        implements IEmployeePayrollService {

    // In-memory list to store employees
    private List<EmployeePayrollData> employeePayrollList
            = new ArrayList<>();

    // Auto increment ID counter
    private AtomicLong idCounter = new AtomicLong(1);

    // GET all employees
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollList;
    }

    // GET employee by ID
    @Override
    public EmployeePayrollData getEmployeePayrollDataById(
            long empId) {
        return employeePayrollList.stream()
                .filter(emp -> emp.employeeId == empId)
                .findFirst()
                .orElse(null);
    }

    // CREATE employee
    @Override
    public EmployeePayrollData createEmployeePayrollData(
            EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = new EmployeePayrollData(
                idCounter.getAndIncrement(),
                employeePayrollDTO.getName(),
                employeePayrollDTO.getSalary()
        );
        employeePayrollList.add(empData);
        return empData;
    }

    // UPDATE employee
    @Override
    public EmployeePayrollData updateEmployeePayrollData(
            long empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData =
                getEmployeePayrollDataById(empId);
        if (empData != null) {
            empData.name = employeePayrollDTO.getName();
            empData.salary = employeePayrollDTO.getSalary();
        }
        return empData;
    }

    // DELETE employee
    @Override
    public void deleteEmployeePayrollData(long empId) {
        EmployeePayrollData empData =
                getEmployeePayrollDataById(empId);
        if (empData != null) {
            employeePayrollList.remove(empData);
        }
    }
}