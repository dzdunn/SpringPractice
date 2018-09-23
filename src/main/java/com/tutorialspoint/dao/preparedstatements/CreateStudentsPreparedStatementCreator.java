package com.tutorialspoint.dao.preparedstatements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;

import com.tutorialspoint.Student;

public class CreateStudentsPreparedStatementCreator implements PreparedStatementCreator {

	private Student[] students;

	public CreateStudentsPreparedStatementCreator(Student... students) {
		this.students = students;
	}

	@Override
	public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
		String sql = "INSERT INTO student (name, age) VALUES (?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		for(Student s : students) {
			ps.setString(1, s.getName());
			ps.setInt(2, s.getAge());
			ps.addBatch();
		}
		return ps;
	}

}
