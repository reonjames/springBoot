package com.mycompany.springboot.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.springboot.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager thEntityManager) {
        entityManager = thEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> thQuery = entityManager.createQuery("from Employee",Employee.class);
        List<Employee> employees = thQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById( int id){
        Employee thEmployee = entityManager.find(Employee.class,id );
        return thEmployee;
    }

    @Override
    public Employee save(Employee thEmployee){
        Employee employeeId = entityManager.merge(thEmployee);
        return employeeId;
    }

    @Override
    public void deleteById(int theId){
        Employee thEmployee = entityManager.find(Employee.class, theId);
        entityManager.remove(thEmployee);
    }
}
