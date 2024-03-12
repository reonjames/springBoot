package com.luv2code.springjpacrud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
    
    //define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    //define constructor
    private Student(){

    }

    public Student(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    //define getter/setters
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getfirstName(){
        return firstName;
    }

    public void setfirstName(String firstName){
        this.firstName=firstName;
    }

    public String getlastName(){
        return lastName;
    }

    public void setlastName(String lastName){
        this.lastName=lastName;
    }

    public String getemail(){
        return email;
    }

    public void setemail(String email){
        this.email=email;
    }

    //define toString() method
    @Override
    public String toString(){
        return "Student("+
                "id="+id+
                ", firstName='"+ firstName+'\''+
                ", lastName='"+ lastName+'\''+
                ", email='"+ email+'\''+
                ')';
    }
}
