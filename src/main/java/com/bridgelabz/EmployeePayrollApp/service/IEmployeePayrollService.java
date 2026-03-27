package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import java.util.List;

public interface IEmployeePayrollService {

    List<EmployeePayrollData> getEmployeePayrollData();

    EmployeePayrollData getEmployeePayrollDataById(long empId);

    EmployeePayrollData createEmployeePayrollData(
            EmployeePayrollDTO employeePayrollDTO);

    EmployeePayrollData updateEmployeePayrollData(long empId,
                                                  EmployeePayrollDTO employeePayrollDTO);

    void deleteEmployeePayrollData(long empId);
}