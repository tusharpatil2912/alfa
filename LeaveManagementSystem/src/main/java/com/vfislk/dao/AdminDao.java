package com.vfislk.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.vfislk.entity.Admin;

public interface AdminDao {
	
	@Select("select * from admin where email=#{email} and password=#{password}")
	public Admin findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

}
