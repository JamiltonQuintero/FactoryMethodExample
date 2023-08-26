package com.jamiltonquintero.factorymethodexample.business.servcie.impl;

import com.jamiltonquintero.factorymethodexample.business.servcie.DataProvider;
import com.jamiltonquintero.factorymethodexample.domain.entity.Employee;
import com.jamiltonquintero.factorymethodexample.persistance.EmployeeRepository;
import com.jamiltonquintero.factorymethodexample.domain.enums.ReportTypeEnum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeDataProvider implements DataProvider<Employee> {


    private final EmployeeRepository employeeRepository;

    public EmployeeDataProvider(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public ReportTypeEnum getType() {
        return ReportTypeEnum.EMPLOYEE;
    }

    @Override
    public List<Employee> getData() {
        return employeeRepository.findAll();
    }
}
