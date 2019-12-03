package com.vfislk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.vfislk.entity.Department;

public interface DepartmentDao {
	
	@Select("select * from departments")
	public List<Department> findAllDepartments();
	
	@Insert("insert into departments(deptName, deptShortName, deptCode) values(#{deptName}, #{deptShortName}, #{deptCode})")
	public void addNewDepartment(Department dept);

}
