package com.tutorialspoint.dao.preparedstatements;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import com.tutorialspoint.Student;

public class StudentByIdBatchStatementSetter implements BatchPreparedStatementSetter {

	private Student[] students;

	public StudentByIdBatchStatementSetter(Student... students) {
		this.students = students;
	}

	@Override
	public void setValues(PreparedStatement ps, int i) throws SQLException {
		ps.setInt(1, students[i].getAge());
		ps.setString(2, students[i].getName());
		ps.setLong(3, students[i].getId());
	}

	@Override
	public int getBatchSize() {
		return students.length;
	}

}

