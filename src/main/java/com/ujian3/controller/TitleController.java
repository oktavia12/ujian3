package com.ujian3.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujian3.main.model.Title;
import com.ujian3.main.model.TitleRowMapper;
import com.ujian3.main.model.Worker;
import com.ujian3.main.model.WorkerRowMapper;


public class TitleController {
@RestController
@RequestMapping("/Title")
public class TitleControler {
	
	
	@Autowired
	JdbcTemplate jdbc ;
	
	public List<Title> getTitle() {
	
	String sql = "Select * from Worker";
	
	List <Title> title = jdbc.query(sql,new TitleRowMapper());
	
	return title;
	}
	
	public int insertTitle(Title title) {
		return jdbc.update("INSERT INTO title(`Worker_reff_id`, `Worker_title`, `Affected_from`) values" 
				+ "('"+title.getWorker_reff_id() + "','"+title.getWorker_title() + "','" + title.getAffected_from()+")"); 
	}
	
	
	@RequestMapping( "/")
public int updateTitle(Title title) {
	
	

		
	return jdbc.update("update title set title_reff_id = '"+ title.getWorker_reff_id() +"', Worker_title = '"+ title.getWorker_title() +"', Affected_from = '"+ title.getAffected_from()+"'");
}
	
	
}
@DeleteMapping( "/{id}")
public int deleteTitle(String id) {
	return jdbc.update("DELETE FROM tbl_Title WHERE worker_reff_id = '" + id + "'");
	
	

	
}
}
