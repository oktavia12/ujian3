package com.ujian3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujian3.main.model.Bonus;
import com.ujian3.main.model.BonusRowMapper;
import com.ujian3.main.model.Worker;
import com.ujian3.main.model.WorkerRowMapper;


@RestController
public class BonusController {
	

		@Autowired
		JdbcTemplate jdbc ;
		
		public List<Bonus> getbonus() {
		
		String sql = "Select * from Bonus";
		
		List <Bonus> bonus = jdbc.query(sql,new BonusRowMapper());
		
		return bonus;
		}
		
		public int insertBonus(Bonus bonus) {
			return jdbc.update("INSERT INTO bonus(`Worker_reff_id`, `Bonus_date`, `Bonus_amount`) values" 
					+ "('"+bonus.getWorker_ref_id() + "','"+ bonus.getBonus_date() + "','"+ bonus.getBonus_amount()+")"); 
		}
		
		
		@RequestMapping( "/")
	public int updateWorker(Worker worker) {
		
		

			
		return jdbc.update("update worker set worker_id = '"+ worker.getWorker_id() +"', first_name = '"+ worker.getFirst_name() +"', Last_name = '"+ worker.getLast_name() +"',Salary = '"+ worker.getSalary()+"', Joining_date = '"+ worker.getJoining_date() +"', Department = '"+ worker.getDepartement()+"'");
	}
		
		public int deleteBonus(String id) {
			return jdbc.update("DELETE FROM tbl_bonus WHERE worker_id = '" + id + "'");
			
			

			
			
		}
}
