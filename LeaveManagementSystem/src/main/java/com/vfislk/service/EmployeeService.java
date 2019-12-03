package com.vfislk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vfislk.dao.EmployeeDao;
import com.vfislk.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao dao;

	public Employee getEmployeeByEmailAndPassword(String email, String password) {
		return dao.findByEmailAndPassword(email, password);
	}

	public void addNewEmployee(Employee emp) {
		dao.addNewEmployee(emp);
	}
	
	public Employee findEmployeeByEmpId(Integer empId) {
		return dao.findEmployeeByEmpId(empId);
		
	}
	
	public List<Employee> getEmployeesByDeptId(Integer deptId) {
		return dao.findEmployeesByDeptId(deptId);
	}
	
	public void leaveCount(Integer empId,Integer available,Integer days) {
		dao.leaveCount(empId,available,days);
	}

}
