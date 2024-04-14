package com.mycompany.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.springboot.cruddemo.dao.EmployeeDAO;
import com.mycompany.springboot.cruddemo.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


    @Override
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        // TODO Auto-generated method stub
        employeeDAO.deleteById(theId);
        
    }


    @Override
    public Employee findById(int id) {
        // TODO Auto-generated method stub
        
        return employeeDAO.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee thEmployee) {
        // TODO Auto-generated method stub
        
        return employeeDAO.save(thEmployee);
    }

    
}
