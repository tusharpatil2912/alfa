package com.vfislk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.vfislk.entity.Employee;

public interface EmployeeDao {
	
	
	@Select("select * from employees where email=#{email} and password=#{password}")
	public Employee findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
	
	
	@Insert("insert into employees(fname,lname,email,password,gender,dob,deptId,city,country,phone,available) values(#{fname},#{lname},#{email},#{password},#{gender},#{dob},#{deptId},#{city},#{country},#{phone},24)")
	@Options(useGeneratedKeys = true, keyProperty = "empId")
	public void addNewEmployee(Employee emp);
	
	@Select("select * from employees where empId=#{empId}")
	public Employee findEmployeeByEmpId(Integer empId);
	
	@Select("select * from employees where deptId=#{deptId}")
	public List<Employee> findEmployeesByDeptId(Integer deptId);
	
	@Update("update employees set available=available-#{days} where empId=#{empId}")
	public void leaveCount(@Param("empId") Integer empId,@Param("available") Integer available,@Param("days") Integer days);
	
}
