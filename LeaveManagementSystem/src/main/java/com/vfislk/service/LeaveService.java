package com.vfislk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vfislk.dao.LeaveDao;
import com.vfislk.entity.Leave;

@Service
public class LeaveService {

	@Autowired
	LeaveDao dao;

	public List<Leave> getAllLeaveApplications() {
		return dao.findAllLeaveApplications();
	}

	public void addNewLeave(Leave leave) {
		dao.addNewLeave(leave);
	}

	public List<Leave> getLeaveApplicationsByEmpId(Integer empId) {
		return dao.findLeaveApplicationsByEmpId(empId);
	}
	
	public List<Leave> getLeaveApplicationsByDeptId(Integer deptId) {
		return dao.findLeaveApplicationsByDeptId(deptId);
	}
	
	public Leave findById(Integer leaveId) {
		return dao.findById(leaveId);
	}
	
	public void approveLeave(Integer leaveId) {
		dao.approveLeave(leaveId);
	}
	
	public void declineLeave(Integer leaveId) {
		dao.declineLeave(leaveId);
	}
	
}
