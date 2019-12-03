package com.vfislk.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.vfislk.service.DepartmentService;

@Controller
public class DepartmentController {
	
	@Autowired
	DepartmentService service;
	
	public static final String ATTR_TITLE = "title";
	
	

}
