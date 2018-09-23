package com.tutorialspoint.dao;

import java.util.List;

import javax.sql.DataSource;

import com.tutorialspoint.Student;

public interface StudentDAO {

	void createTable();
	void createStudents(Student... students);
	int deleteStudent(Long... ids);
	List<Student> findStudent(String name);
	List<Student> findStudent(int age);
	int updateStudent(Student... students);
	DataSource getDataSource();


}
