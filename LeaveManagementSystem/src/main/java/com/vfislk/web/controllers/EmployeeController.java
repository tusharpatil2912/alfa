package com.vfislk.web.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vfislk.entity.Employee;
import com.vfislk.entity.Leave;
import com.vfislk.service.DepartmentService;
import com.vfislk.service.EmployeeService;
import com.vfislk.service.LeaveService;
import com.vfislk.web.validators.LeaveFormValidator;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@Autowired
	DepartmentService deptServ;
	
	@Autowired
	LeaveService leaveServ;
	
	@Autowired
	LeaveFormValidator lfv;
	
	public static final String ATTR_TITLE = "title";
	
	@GetMapping("/employee-login")
	public String employeeLogin(Model model) {
		model.addAttribute(ATTR_TITLE, "Employee");
		return "login";
		//return "employee-dashboard";
	}
	
	
	
	@GetMapping("/employee-dashboard")
	public String employeeDashboard(Model model,HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		Employee employee= (Employee) req.getSession().getAttribute("employee");
		model.addAttribute(ATTR_TITLE, "Employee");
		if (employee == null) {
			resp.sendRedirect("./employee-login");
		}
		return "employee-dashboard";
		}
	
	

	@GetMapping("/employee-logout")
	public void employeeLogout(Model model,HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		model.addAttribute(ATTR_TITLE, "employee");
		req.getSession().invalidate();
		//req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
		resp.sendRedirect("./employee-login");
	}
	
	@GetMapping("/apply-leave")
	public String leaveApplication(Model model,HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		Employee employee= (Employee) req.getSession().getAttribute("employee");
		model.addAttribute(ATTR_TITLE, "Employee");
		if (employee == null) {
			resp.sendRedirect("./employee-login");
		}
		model.addAttribute(ATTR_TITLE, "Leave");
		model.addAttribute("leave", new Leave());
		return "leave-form";
	}
	
	@GetMapping("/leave-history")
	public String leaveHistory(Model model,HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		Employee employee= (Employee) req.getSession().getAttribute("employee");
		model.addAttribute(ATTR_TITLE, "Employee");
		if (employee == null) {
			resp.sendRedirect("./employee-login");
		}
		model.addAttribute(ATTR_TITLE, "Leave");
		List<Leave> leave= leaveServ.getLeaveApplicationsByEmpId(employee.getEmpId());
		model.addAttribute("leave", leave);
		return "leave-history";
	}

	@PostMapping("/employee-login")
	public void employeeLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Employee employee = service.getEmployeeByEmailAndPassword(email, password);
		if (employee == null) {
			// invalid login
			req.setAttribute("errMsg", "Invalid username/password");
			req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
		} else {
			req.getSession().setAttribute("employee", employee);
			resp.sendRedirect("./employee-dashboard");
		}

	}
	
	@PostMapping("/apply-leave")
	public String addNewLeave(@ModelAttribute("leave") Leave leave,Model model,HttpServletRequest req, HttpServletResponse resp,BindingResult errors)throws ServletException, IOException {
		Employee employee= (Employee) req.getSession().getAttribute("employee");
		model.addAttribute(ATTR_TITLE, "Employee");
		lfv.validate(leave, errors);

		if(errors.hasErrors()) {
			model.addAttribute(ATTR_TITLE, "Employee");
			return "leave-form";
		}
		else
		{
		
		if (employee == null) {
			resp.sendRedirect("./employee-login");
		}
		model.addAttribute("leave", new Leave());
		model.addAttribute(ATTR_TITLE, "Leave");
		req.setAttribute("msg", "Applied Successfully");
		model.addAttribute("empId", employee.getEmpId());
		model.addAttribute("deptId", employee.getDeptId());
		leave.setEmpId(employee.getEmpId());
		leave.setDeptId(employee.getDeptId());
		leaveServ.addNewLeave(leave);
		return "leave-form";
		}
		
	}
	
	
}
