package com.tutorialspoint.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tutorialspoint.Student;
import com.tutorialspoint.dao.preparedstatements.CreateStudentsPreparedStatementCreator;
import com.tutorialspoint.dao.preparedstatements.DeletePreparedStatementCreator;
import com.tutorialspoint.dao.preparedstatements.UpdatePreparedStatementCreator;
import com.tutorialspoint.dao.rowmappers.StudentRowMapper;


@Component("studentDAOMSSQLImpl")
@Transactional("txManagerMSSQL")
public class StudentDAOMSSQLImpl implements StudentDAO {

	@Autowired
	@Qualifier("mssqlDataSource")
	private BasicDataSource mssqlDataSource;

	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	private void setUp() {
		jdbcTemplate = new JdbcTemplate(mssqlDataSource);
	}

	@Override
	public void createTable() {
		jdbcTemplate.execute("IF NOT EXISTS (select * from sysobjects where name='Student')"
				+ "CREATE TABLE Student("
				+ "id bigint, "
				+ "name varchar(255),"
				+ "age int"
				+ ")");
	}

	@Override
	public void createStudents(Student... students) {

		jdbcTemplate.update(new CreateStudentsPreparedStatementCreator(students));
	}

	@Override
	public int deleteStudent(Long... ids) {
		return jdbcTemplate.update(new DeletePreparedStatementCreator(ids));
	}

	@Override
	public List<Student> findStudent(String name) {
		String sql = "SELECT * FROM student where name = ?";
		List<Student> students = jdbcTemplate.query(sql, new Object[] {name}, new StudentRowMapper());
		return students;
	}

	@Override
	public List<Student> findStudent(int age) {
		String sql = "SELECT * FROM student where age = ?";
		List<Student> students = jdbcTemplate.query(sql, new Object[] {age}, new StudentRowMapper());
		return students;
	}

	@Override
	public int updateStudent(Student... students) {
		jdbcTemplate.update(new UpdatePreparedStatementCreator(students));
		return 0;
	}

	@Override
	public DataSource getDataSource() {
		return mssqlDataSource;
	}



}
