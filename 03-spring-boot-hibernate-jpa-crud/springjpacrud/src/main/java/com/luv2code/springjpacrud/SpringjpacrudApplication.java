package com.luv2code.springjpacrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.springjpacrud.dao.StudentDAO;
import com.luv2code.springjpacrud.entity.Student;

import java.util.List;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class SpringjpacrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringjpacrudApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner->{
			createStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudent(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
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

	private void queryForStudent(StudentDAO studentDAO){
		List<Student> queryStudent = studentDAO.findAll();

		for(Student singleStudent:queryStudent){
			System.out.println(singleStudent);
		}
	}

	private void updateStudent(StudentDAO studentDAO){
		Student st = studentDAO.findById(1);
		System.out.println("student = "+st);
		st.setlastName("new");
		studentDAO.update(st);
		System.out.println("updated student = "+st);
	}

	private void deleteStudent(StudentDAO theStudent){
		int studentId = 4;
		System.out.println("delete student id : "+studentId);
		theStudent.delete(studentId);
	}
}
