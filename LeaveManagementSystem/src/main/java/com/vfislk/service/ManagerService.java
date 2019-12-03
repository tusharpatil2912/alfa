package com.vfislk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vfislk.dao.ManagerDao;
import com.vfislk.entity.Manager;

@Service
public class ManagerService {
	
	@Autowired
	ManagerDao dao;
	
	public Manager getManagerByEmailAndPassword(String email, String password) {
		return dao.findByEmailAndPassword(email, password);
}
	public void addNewManager(Manager manager) {
		dao.addNewManager(manager);
}

}
