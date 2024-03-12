package com.luv2code.springjpacrud.dao;

import com.luv2code.springjpacrud.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);
}

