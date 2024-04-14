package com.mycompany.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    // no need to write any code. It will be there in JPA repository.
}
