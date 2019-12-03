package com.vfislk.web.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.vfislk.entity.Employee;
import com.vfislk.entity.Leave;
import com.vfislk.entity.Manager;
import com.vfislk.service.DepartmentService;
import com.vfislk.service.EmployeeService;
import com.vfislk.service.LeaveService;
import com.vfislk.service.ManagerService;

@Controller
public class ManagerController {
	
	@Autowired
	ManagerService service;
	
	@Autowired
	DepartmentService deptServ;
	
	@Autowired
	LeaveService leaveServ;
	
	@Autowired
	EmployeeService empserv;
	
	public static final String ATTR_TITLE = "title";
	
	@GetMapping("/manager-login")
	public String managerLogin(Model model) {
		model.addAttribute(ATTR_TITLE, "Manager");
		return "login";
		//return "leave-applications";
	}
	
	
	
	@GetMapping("/manager-dashboard")
	public String managerDashboard(Model model,HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		Manager manager= (Manager) req.getSession().getAttribute("manager");
		model.addAttribute(ATTR_TITLE, "Manager");
		if (manager == null) {
			resp.sendRedirect("./manager-login");
		}
		return "manager-dashboard";
		}
	
	

	@GetMapping("/manager-logout")
	public void managerLogout(Model model,HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		model.addAttribute(ATTR_TITLE, "manager");
		req.getSession().invalidate();
		//req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
		resp.sendRedirect("./manager-login");
	}
	
	@GetMapping("/view-leave-applications")
	public String leaveApllications(Model model,HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		Manager manager= (Manager) req.getSession().getAttribute("manager");
		model.addAttribute(ATTR_TITLE, "Manager");
		if (manager == null) {
			resp.sendRedirect("./manager-login");
		}
		model.addAttribute(ATTR_TITLE, "Leave");
		List<Leave> leave= leaveServ.getLeaveApplicationsByDeptId(manager.getDeptId());
		model.addAttribute("leave", leave);
		return "leave-applications";
	}
	
	@GetMapping("/leave-details")
	public String leaveDetails(Model model,HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		Manager manager= (Manager) req.getSession().getAttribute("manager");
		model.addAttribute(ATTR_TITLE, "Manager");
		if (manager == null) {
			resp.sendRedirect("./manager-login");
		}
		model.addAttribute(ATTR_TITLE, "Leave");
		Integer leaveId = new Integer(req.getParameter("leaveId"));
		Leave leave= leaveServ.findById(leaveId);
		model.addAttribute("leave", leave);
		Integer empId = leave.getEmpId();
		model.addAttribute("emp", empserv.findEmployeeByEmpId(empId));
		return "leave-details";
	}
	
	@GetMapping("/approve-leave")
	public String approveLeave(Model model,HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		Manager manager= (Manager) req.getSession().getAttribute("manager");
		model.addAttribute(ATTR_TITLE, "Manager");
		if (manager == null) {
			resp.sendRedirect("./manager-login");
		}
		model.addAttribute(ATTR_TITLE, "Leave");
		Integer leaveId = new Integer(req.getParameter("leaveId"));
		/***/
		Leave leavec= leaveServ.findById(leaveId);
		Integer empId=leavec.getEmpId();
		Integer days=leavec.getDays();
		Employee emp=empserv.findEmployeeByEmpId(empId);
		Integer available=emp.getAvailable();
		model.addAttribute("available", available);
		System.out.println(empId);
		/***/
		empserv.leaveCount(leavec.getEmpId(), emp.getAvailable(), leavec.getDays());
		leaveServ.approveLeave(leaveId);
		List<Leave> leave= leaveServ.getLeaveApplicationsByDeptId(manager.getDeptId());
		model.addAttribute("leave", leave);
		return "leave-applications";
	}
	
	@GetMapping("/decline-leave")
	public String declineLeave(Model model,HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		Manager manager= (Manager) req.getSession().getAttribute("manager");
		model.addAttribute(ATTR_TITLE, "Manager");
		if (manager == null) {
			resp.sendRedirect("./manager-login");
		}
		model.addAttribute(ATTR_TITLE, "Leave");
		Integer leaveId = new Integer(req.getParameter("leaveId"));
		leaveServ.declineLeave(leaveId);
		List<Leave> leave= leaveServ.getLeaveApplicationsByDeptId(manager.getDeptId());
		model.addAttribute("leave", leave);
		return "leave-applications";
	}
	
	@GetMapping("/view-all-employees")
	public String viewAllEmployees(Model model,HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		Manager manager= (Manager) req.getSession().getAttribute("manager");
		model.addAttribute(ATTR_TITLE, "Manager");
		if (manager == null) {
			resp.sendRedirect("./manager-login");
		}
		model.addAttribute(ATTR_TITLE, "Employees");
		List<Employee> employee= empserv.getEmployeesByDeptId(manager.getDeptId());
		model.addAttribute("employee", employee);
		return "employees-list";
	}
	

	@PostMapping("/manager-login")
	public void managerLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Manager manager = service.getManagerByEmailAndPassword(email, password);
		if (manager == null) {
			// invalid login
			req.setAttribute("errMsg", "Invalid username/password");
			req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
		} else {
			req.getSession().setAttribute("manager", manager);
			resp.sendRedirect("./manager-dashboard");
		}

	}	
	
	
}
