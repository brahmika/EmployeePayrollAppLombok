package com.bridgelabz.employeepayrollapp.model;

public class EmployeePayrollData {

    public long employeeId;
    public String name;
    public double salary;

    // Default Constructor
    public EmployeePayrollData() {}

    // Constructor
    public EmployeePayrollData(long employeeId,
                               String name, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeePayrollData: employeeId=" + employeeId
                + ", name=" + name + ", salary=" + salary;
    }
}