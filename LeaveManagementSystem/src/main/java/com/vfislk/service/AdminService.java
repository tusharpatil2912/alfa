package com.vfislk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vfislk.dao.AdminDao;
import com.vfislk.entity.Admin;

@Service
public class AdminService {
	
	@Autowired
	AdminDao dao;
	
	public Admin getAdminByEmailAndPassword(String email, String password) {
			return dao.findByEmailAndPassword(email, password);
	}

}
