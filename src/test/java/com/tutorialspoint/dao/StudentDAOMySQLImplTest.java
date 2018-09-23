package com.tutorialspoint.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.tutorialspoint.Student;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath*:config/Beans.xml")
@Transactional("txManagerMySQL")
class StudentDAOMySQLImplTest {

	@Autowired
	private StudentDAOMySQLImpl studentDAOMySQLImpl;


	@Resource(name = "student")
	private Student student;

	@BeforeEach
	void setUp() throws Exception {

	}

	@AfterEach
	void tearDown() throws Exception {

	}

	@Test
	void teststudentDAOMySQLImplExists() {
		assertNotNull(studentDAOMySQLImpl);
	}

	@Test
	void testCreateStudents() {
		student.getAge();
		studentDAOMySQLImpl.createStudents(student);

		List<Student> results = studentDAOMySQLImpl.findStudent(student.getName());
		Student result = results.get(results.size()-1);

		assertEquals(result.getName(), student.getName());
		assertEquals(result.getAge(), student.getAge());
	}

	@Test
	void testDeleteStudent() {
		List<Student> students = studentDAOMySQLImpl.findStudent(student.getName());
		Long id = students.get(students.size() - 1).getId();
		Long id2 = students.get(0).getId();
		studentDAOMySQLImpl.deleteStudent(id, id2);
		List<Student> students_result = studentDAOMySQLImpl.findStudent(student.getName());
		boolean r = students_result.stream().anyMatch(x -> x.getId() == 1L);
		assertFalse(r);
	}

	@Test
	void testFindStudentByName() {
		List<Student> result = studentDAOMySQLImpl.findStudent(student.getName());
		boolean r = result.stream().allMatch(x -> x.getName().equals(student.getName()));
		assertTrue(r);
	}

	@Test
	void testFindStudentInt() {
		List<Student> result = studentDAOMySQLImpl.findStudent(student.getAge());
		boolean r = result.stream().allMatch(x -> x.getAge().equals(student.getAge()));
		assertTrue(r);
	}

	@Test
	void testUpdateStudent() {
		List<Student> result = studentDAOMySQLImpl.findStudent(student.getName());
		Student s1 = result.get(0);
		Student s2 = result.get(result.size()-1);
		s1.setAge(student.getAge()+10);
		s2.setAge(student.getAge()+10);

		studentDAOMySQLImpl.updateStudent(s1, s2);
		List<Student> result2 = studentDAOMySQLImpl.findStudent(student.getName());
		assert(result2.get(0).getAge().equals(student.getAge() + 10));
		assert(result2.get(result2.size()-1).getAge().equals(student.getAge()+ 10));

	}

}
