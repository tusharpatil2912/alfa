package com.vfislk.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.vfislk.entity.Manager;

public interface ManagerDao {
	
	@Select("select * from managers where email=#{email} and password=#{password}")
	public Manager findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
	
	
	@Insert("insert into managers(fname,lname,email,password,gender,dob,deptId,city,country,phone) values(#{fname},#{lname},#{email},#{password},#{gender},#{dob},#{deptId},#{city},#{country},#{phone})")
	@Options(useGeneratedKeys = true, keyProperty = "empId")
	public void addNewManager(Manager manager);


}
