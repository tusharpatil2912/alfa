package com.vfislk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vfislk.dao.DepartmentDao;
import com.vfislk.entity.Department;

@Service
public class DepartmentService {
	
	@Autowired
	DepartmentDao dao;
	
	public List<Department> getAllDepartments() {
		return dao.findAllDepartments();
	}
	
	public void addNewDepartment(Department dept) {
		dao.addNewDepartment(dept);
	}
}

