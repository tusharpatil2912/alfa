package com.vfislk.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Employee {
	//private Integer id;
	private Integer empId;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private String phone;
	private String gender;
	//private String deptName;
	private Integer deptId;
	private String city;
	private String country;
	private String dob;
	private Integer available;
	
}
