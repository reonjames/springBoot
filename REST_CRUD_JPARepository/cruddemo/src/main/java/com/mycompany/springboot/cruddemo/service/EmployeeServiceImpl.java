package com.mycompany.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.springboot.cruddemo.dao.EmployeeRepository;
import com.mycompany.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeDAO) {
        this.employeeRepository = employeeDAO;
    }


    @Override
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    @Override
    public void deleteById(int theId) {
        // TODO Auto-generated method stub
        employeeRepository.deleteById(theId);
        
    }


    @Override
    public Employee findById(int id) {
        // TODO Auto-generated method stub
        Optional<Employee> result = employeeRepository.findById(id);
        Employee theEmployee=null;
        if(result.isPresent()){
            theEmployee = result.get();
        }
        else{
            throw new RuntimeException("Did not find employee id- "+id);
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee thEmployee) {
        // TODO Auto-generated method stub
        
        return employeeRepository.save(thEmployee);
    }

    
}
