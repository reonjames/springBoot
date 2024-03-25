package com.restcontroller.restapi.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restcontroller.restapi.entity.Student;

import jakarta.annotation.PostConstruct;


@RestController
@RequestMapping("/rest")
public class StudentRestController {
private List<Student> st;
@PostConstruct
public void loadData(){
    st=new ArrayList<>();
    st.add(new Student("reon","james"));
    st.add(new Student("nihal","limbu"));
    st.add(new Student("sangeeth","pradeep"));
}
    @GetMapping("/student")
    public List<Student> getStudent(){
       return st;
    }
    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        if(st.size()<=studentId || studentId<0){
            throw new StudentNotFound("Student Id not found"+studentId);
        }
       return st.get(studentId);
    }

    

   
}
