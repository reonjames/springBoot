package com.luv2code.springjpacrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.springjpacrud.dao.StudentDAO;
import com.luv2code.springjpacrud.entity.Student;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class SpringjpacrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringjpacrudApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner->{
			//createStudent(studentDAO);
			readStudent(studentDAO);
		};
	}
	private void createStudent(StudentDAO studentDAO){
		// create the student object
		Student tempStudent = new Student("Paul", "Joe", "paul@joe.com");

		// save the student object
		studentDAO.save(tempStudent);

		//display id of saved student
		System.out.println("saved student generated id"+tempStudent.getId());
	}

	private void readStudent(StudentDAO studentDAO){
		//create a student object
		Student tempStudent = new Student("daffey", "duck", "daffey@duck.com");
		//save the student
		studentDAO.save(tempStudent);
		//display id of the saved student
		System.out.println("saved student id = "+tempStudent.getId());
		//retrieve student based on the id: primary key
		Student retrieveStudent = studentDAO.findById(tempStudent.getId());
		//display student
		System.out.println("my student = "+retrieveStudent);
	}
}
