package com.tutorialspoint.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.tutorialspoint.Student;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath*:config/Beans.xml")
@Transactional("txManagerMSSQL")
class StudentDAOMSSQLImplTest {

	@Autowired
	private StudentDAOMSSQLImpl mssqlDataSource;

	@Resource(name = "student")
	private Student student;

	@Test
	void testCreateStudents() {
		mssqlDataSource.createStudents(student);
	}

	@Test
	void testFindStudentsByName() {
		mssqlDataSource.createStudents(student);
		List<Student> result = mssqlDataSource.findStudent(student.getName());
		mssqlDataSource.createStudents(student);
		mssqlDataSource.findStudent(student.getName());
		mssqlDataSource.findStudent(student.getName());

		assertTrue(result.get(0).getName().equals(student.getName()));
	}
}
