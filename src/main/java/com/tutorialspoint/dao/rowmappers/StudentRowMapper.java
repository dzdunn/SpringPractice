package com.tutorialspoint.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tutorialspoint.Student;

public class StudentRowMapper implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student s = new 	Student();
		s.setAge(rs.getInt("age"));
		s.setName(rs.getString("name"));
		s.setId(rs.getLong("id"));
		return s;
	}





}
