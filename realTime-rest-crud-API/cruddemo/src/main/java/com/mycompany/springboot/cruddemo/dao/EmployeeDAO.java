package com.mycompany.springboot.cruddemo.dao;

import java.util.List;

import com.mycompany.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee thEmployee);

    void deleteById(int theId);
}
