package com.vfislk.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.vfislk.service.EmployeeService;
import com.vfislk.service.LeaveService;

@Controller
public class LeaveController {
	
	@Autowired
	LeaveService service;
	
	@Autowired
	EmployeeService empserv;
	
	public static final String ATTR_TITLE = "title";
	
		
	
	
	

}
