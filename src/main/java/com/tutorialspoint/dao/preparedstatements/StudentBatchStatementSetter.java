package com.tutorialspoint.dao.preparedstatements;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import com.tutorialspoint.Student;

public class StudentBatchStatementSetter implements BatchPreparedStatementSetter {

	private Student[] students;

	public StudentBatchStatementSetter(Student... students) {
		this.students = students;
	}

	@Override
	public void setValues(PreparedStatement ps, int i) throws SQLException {
		ps.setString(1, students[i].getName());
		ps.setInt(2, students[i].getAge());
	}

	@Override
	public int getBatchSize() {
		return students.length;
	}

}