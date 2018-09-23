package com.tutorialspoint.dao.preparedstatements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;

public class DeletePreparedStatementCreator implements PreparedStatementCreator{

	private Long[] ids;

	public DeletePreparedStatementCreator(Long... ids) {
		this.ids = ids;
	}

	@Override
	public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

		String sql = "DELETE FROM student WHERE id = :id";
		PreparedStatement ps = con.prepareStatement(sql);
		for(Long id: ids) {
			ps.setLong(1, id);
			ps.addBatch();
		}
		return ps;
	}

}