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

import com.vfislk.entity.Admin;
import com.vfislk.entity.Department;
import com.vfislk.entity.Employee;
import com.vfislk.entity.Manager;
import com.vfislk.service.AdminService;
import com.vfislk.service.DepartmentService;
import com.vfislk.service.EmployeeService;
import com.vfislk.service.ManagerService;
import com.vfislk.web.validators.DeptFormValidator;
import com.vfislk.web.validators.FormValidator;
import com.vfislk.web.validators.MngFormValidator;

@Controller
public class AdminController {

	@Autowired
	AdminService service;
	
	@Autowired
	DepartmentService deptServ;
	
	@Autowired
	EmployeeService empServ;
	
	@Autowired
	ManagerService mngServ;
	
	@Autowired
	FormValidator fv;
	
	@Autowired
	MngFormValidator mfv;
	
	@Autowired
	DeptFormValidator dfv;

	public static final String ATTR_TITLE = "title";

	@GetMapping("/admin-login")
	public String adminLogin(Model model) {
		model.addAttribute(ATTR_TITLE, "Admin");
		model.addAttribute("emp", new Employee());
		return "login";
		// return "registration-form";
	}
	
	@GetMapping("/admin-dashboard")
	public String adminDashboard(Model model,HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		Admin admin= (Admin) req.getSession().getAttribute("admin");
		model.addAttribute(ATTR_TITLE, "Admin");
		if (admin == null) {
			resp.sendRedirect("./admin-login");
		}
		//model.addAttribute("emp", new Employee());
		return "admin-dashboard";
		}
	
	

	@GetMapping("/admin-logout")
	public void AdminLogout(Model model,HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		model.addAttribute(ATTR_TITLE, "Admin");
		req.getSession().invalidate();
		//req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
		resp.sendRedirect("./admin-login");
	}
	
	
	@GetMapping("/add-new-department")
	public String addNewDepartment(Model model,HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		Admin admin= (Admin) req.getSession().getAttribute("admin");
		model.addAttribute(ATTR_TITLE, "Admin");
		if (admin == null) {
			resp.sendRedirect("./admin-login");
		}
		model.addAttribute(ATTR_TITLE, "Department");
		model.addAttribute("dept", new Department());
		return "add-new-department";
	}
	
	
	@GetMapping("/add-new-employee")
	public String addNewEmployee(Model model,HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		Admin admin= (Admin) req.getSession().getAttribute("admin");
		model.addAttribute(ATTR_TITLE, "Admin");
		if (admin == null) {
			resp.sendRedirect("./admin-login");
		}
		model.addAttribute(ATTR_TITLE, "Employee");
		model.addAttribute("posttitle", "employee");
		model.addAttribute("dept",deptServ.getAllDepartments());
		model.addAttribute("emp", new Employee());
		return "registration-form";
	}
	
	@GetMapping("/add-new-manager")
	public String addNewManager(Model model,HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		Admin admin= (Admin) req.getSession().getAttribute("admin");
		model.addAttribute(ATTR_TITLE, "Admin");
		if (admin == null) {
			resp.sendRedirect("./admin-login");
		}
		model.addAttribute(ATTR_TITLE, "Manager");
		model.addAttribute("posttitle", "manager");
		List<Department> dept= deptServ.getAllDepartments();
		model.addAttribute("dept",dept);
		model.addAttribute("manager", new Manager());
		return "manager-registration-form";
	}
	
	@PostMapping("/add-new-employee")
	public String addNewEmployee(@ModelAttribute("emp") Employee emp,Model model,HttpServletRequest req, HttpServletResponse resp,BindingResult errors) {
		fv.validate(emp, errors);

		if(errors.hasErrors()) {
			model.addAttribute(ATTR_TITLE, "Employee");
			model.addAttribute("posttitle", "employee");
			List<Department> dept= deptServ.getAllDepartments();
			model.addAttribute("dept",dept);
			return "registration-form";
		}
		else
		{
		model.addAttribute("emp", new Employee());
		model.addAttribute(ATTR_TITLE, "Employee");
		req.setAttribute("msg", "Added Successfully");
		empServ.addNewEmployee(emp);
		return "registration-form";
		}
		
	}
	
	@PostMapping("/add-new-department")
	public String addNewDepartment1(@ModelAttribute("dept") Department dept,Model model,HttpServletRequest req, HttpServletResponse resp,BindingResult errors)throws ServletException, IOException {
		dfv.validate(dept, errors);

		if(errors.hasErrors()) {
			model.addAttribute(ATTR_TITLE, "Department");
			return "add-new-department";
		}
		model.addAttribute("dept", new Department());
		model.addAttribute(ATTR_TITLE, "Department");
		req.setAttribute("msg", "Added Successfully");
		deptServ.addNewDepartment(dept);
		return "add-new-department";
		
		
	}
	
	@PostMapping("/add-new-manager")
	public String addNewManager(@ModelAttribute("manager") Manager manager,Model model,HttpServletRequest req, HttpServletResponse resp,BindingResult errors) {
		mfv.validate(manager, errors);

		if(errors.hasErrors()) {
			model.addAttribute(ATTR_TITLE, "Manager");
			model.addAttribute("posttitle", "manager");
			List<Department> dept= deptServ.getAllDepartments();
			model.addAttribute("dept",dept);
			return "manager-registration-form";
		}
		else
		{
		model.addAttribute("manager", new Manager());
		model.addAttribute(ATTR_TITLE, "Manager");
		req.setAttribute("msg", "Added Successfully");
		mngServ.addNewManager(manager);
		return "manager-registration-form";
		}
	}


	@PostMapping("/admin-login")
	public void adminLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Admin admin = service.getAdminByEmailAndPassword(email, password);
		if (admin == null) {
			// invalid login
			req.setAttribute("errMsg", "Invalid username/password");
			req.setAttribute(ATTR_TITLE, "Admin");
			req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
		} else {
			req.getSession().setAttribute("admin", admin);
			resp.sendRedirect("./admin-dashboard");
		}

	}

}
