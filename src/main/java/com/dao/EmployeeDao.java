package com.dao;
import com.domain.Employee;
import java.util.List;

public interface EmployeeDao {

    List<Employee> selectEmployee(Employee employee);

    int insertEmployee(Employee employee);

    int updateEmployee(Employee employee);

    int deleteEmployeeById(int id);
}
