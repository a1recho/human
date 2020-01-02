package com.service;

import com.domain.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> selectEmployee(Employee employee);

    int insertEmployee(Employee employee);

    int updateEmployee(Employee employee);

    int deleteEmployeeById(int id);
}
