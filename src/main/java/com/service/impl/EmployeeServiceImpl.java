package com.service.impl;
import com.dao.EmployeeDao;
import com.domain.Employee;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> selectEmployee(Employee employee){
        return employeeDao.selectEmployee(employee);
    }

    @Override
    public int insertEmployee(Employee employee){
        int rows = employeeDao.insertEmployee(employee);
        return rows;
    }

    @Override
    public int updateEmployee(Employee employee){
        int rows = employeeDao.updateEmployee(employee);
        return rows;
    }

    @Override
    public int deleteEmployeeById(int id){
        return employeeDao.deleteEmployeeById(id);
    }

}
