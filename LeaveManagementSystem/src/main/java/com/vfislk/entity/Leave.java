package com.vfislk.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Leave {
	private Integer leaveId;
	private String leaveType;
	private String fromDate;
	private String toDate;
	private String description;
	private String postingDate;
	private String adminRemark;
	//private String adminRemarkDate;
	private String status;
	private Integer empId;
	private Integer deptId;
	private Integer days;
	
}
