package com.luv2code.springjpacrud.dao;

import java.util.List;

import com.luv2code.springjpacrud.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    void update(Student theStudent);

    void delete(Integer Id);
}

