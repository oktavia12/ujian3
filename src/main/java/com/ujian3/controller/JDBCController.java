package com.ujian3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class JDBCController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String homeIndex() {
		return "";

	
}
}