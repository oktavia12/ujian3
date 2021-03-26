package com.ujian3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ujian3.main.model.Worker;
import com.ujian3.main.model.WorkerRowMapper;



@RestController
public class WorkerController {
	@Autowired
	JdbcTemplate jdbc ;
	
	public List<Worker> getworker() {
	
	String sql = "Select * from Worker";
	
	List <Worker> worker = jdbc.query(sql,new WorkerRowMapper());
	
	return worker;
	}
	
	public int insertWorker(Worker worker) {
		return jdbc.update("INSERT INTO worker(`Worker_id`, `First_name`, `Last_name`, `Salary`, `Joining_date`, `Department`) values" 
				+ "('"+worker.getWorker_id() + "','"+ worker.getFirst_name() + "','" + worker.getLast_name() + "','"+worker.getSalary()+"','"+worker.getJoining_date()+"','"+worker.getDepartement()+")"); 
	}
	
	
	@RequestMapping( "/")
public int updateWorker(Worker worker) {
	
	

		
	return jdbc.update("update worker set worker_id = '"+ worker.getWorker_id() +"', first_name = '"+ worker.getFirst_name() +"', Last_name = '"+ worker.getLast_name() +"',Salary = '"+ worker.getSalary()+"', Joining_date = '"+ worker.getJoining_date() +"', Department = '"+ worker.getDepartement()+"'");
}
	
	public int deleteWorker(String id) {
		return jdbc.update("DELETE FROM tbl_worker WHERE worker_id = '" + id + "'");
		
		
	}
//	Gaji Tertinggi
	@GetMapping("/gajitertinggi")
	public List<Worker> listMaxGaji() {
		String sql = "SELECT * FROM tbl_worker ORDER BY salary DESC LIMIT 5";
		List<Worker> worker = jdbc.query(sql, new WorkerRowMapper());
		return worker;
	}

//	Gaji Yang Sama
	@GetMapping("/gajisama")
	public List<Worker> listGaji() {
		String sql = "SELECT * FROM tbl_worker WHERE salary in (SELECT salary FROM tbl_worker GROUP BY salary HAVING COUNT(*) > 1 );";
		List<Worker> worker = jdbc.query(sql, new WorkerRowMapper());
		return worker;
	}
	
	

//	Create
	@PostMapping("/")
	public String add(@RequestBody Worker worker) {

		if (this.insertWorker(worker) == 1) {
			return "Insert data berhasil";
		} else {
			return "Insert data gagal";
		}
	}





//	Delete
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		deleteWorker(id);
}
}
