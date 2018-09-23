package com.tutorialspoint.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
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
import com.tutorialspoint.dao.preparedstatements.StudentBatchStatementSetter;
import com.tutorialspoint.dao.preparedstatements.StudentByIdBatchStatementSetter;
import com.tutorialspoint.dao.rowmappers.StudentRowMapper;

@Component("studentDAOMySQLImpl")
@Transactional("txManagerMSSQL")
public class StudentDAOMySQLImpl implements StudentDAO {

	@Autowired
	@Qualifier("mySQLDataSource")
	private BasicDataSource mySQLDataSource;

	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	public void setUp() {
		jdbcTemplate = new JdbcTemplate(mySQLDataSource);
	}

	@Override
	public void createTable() {
		jdbcTemplate.execute("CREATE TABLE `student` ("
				+ "`id` bigint(10) unsigned NOT NULL AUTO_INCREMENT, "
				+ "`name` varchar(255) NOT NULL, "
				+ "`age` int(10) unsigned NOT NULL,"
				+ "PRIMARY KEY (`id`),"
				+ " UNIQUE KEY `id_UNIQUE` (`id`)"
				+ ") ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 "
				+ "COLLATE=utf8mb4_0900_ai_ci;"
				+ "SELECT * FROM test.student;");
	}

	@Override
	public void createStudents(final Student... students) {
		String sql = ("INSERT INTO student (name, age) VALUES (?, ?);");
		jdbcTemplate.batchUpdate(sql, new StudentBatchStatementSetter(students));

	}

	@Override
	public int deleteStudent(Long... ids) {
		String sql = "DELETE FROM student WHERE id = ?";
		PreparedStatement ps;
		int totalUpdated = 0;
		try {
			ps = mySQLDataSource.getConnection().prepareStatement(sql);
			for (Long id : ids) {
				ps.setLong(1, id);
				ps.addBatch();
			}
			int[] result = ps.executeBatch();
			ps.close();
			for (int i : result) {
				totalUpdated += i;
			}
			return totalUpdated;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Student> findStudent(String name) {
		String sql = "SELECT * FROM student WHERE name = ?";
		return jdbcTemplate.query(sql, new Object[] { name }, new StudentRowMapper());

	}

	@Override
	public List<Student> findStudent(int age) {
		String sql = "SELECT * FROM student 	WHERE age = ?";
		return jdbcTemplate.query(sql, new Object[] { age }, new StudentRowMapper());
	}

	@Override
	public int updateStudent(Student... students) {
		String sql = "UPDATE student Set age = ?, name = ? where id = ?";
		int[] result = jdbcTemplate.batchUpdate(sql, new StudentByIdBatchStatementSetter(students));
		int totalUpdated = 0;
		for (int i : result) {
			totalUpdated += i;
		}
		return totalUpdated;
	}

	@Override
	public DataSource getDataSource() {
		return mySQLDataSource;
	}




}
