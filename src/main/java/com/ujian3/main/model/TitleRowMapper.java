package com.ujian3.main.model;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

public class TitleRowMapper implements RowMapper<Title> {
	@Override
	
	
	public Title mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Title title = new Title();
		title.setWorker_reff_id(rs.getString("worker_reff_id"));
		title.setWorker_title(rs.getString("worker_title"));
		title.setAffected_from(rs.getString("affected_from"));
		
		// TODO Auto-generated method stub
		return title;
		
}
}


