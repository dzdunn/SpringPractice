package com.tutorialspoint.dao.preparedstatements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;

import com.tutorialspoint.Student;

public class UpdatePreparedStatementCreator implements PreparedStatementCreator {

	private Student[] students;

	public UpdatePreparedStatementCreator(Student...students) {
		this.students = students;
	}

	@Override
	public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
		String sql = "UPDATE student SET name = :name, age = :age WHERE id = :id";
		PreparedStatement ps = con.prepareStatement(sql);
		for(Student s : students) {
			ps.setString(1, s.getName());
			ps.setInt(2, s.getAge());
			ps.setLong(3, s.getId());
			ps.addBatch();
		}
		return ps;

	}

}
