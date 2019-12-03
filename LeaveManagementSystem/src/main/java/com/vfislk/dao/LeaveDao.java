package com.vfislk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.vfislk.entity.Leave;

public interface LeaveDao {
	
	@Select("select * from leaves where deptId=#{deptId}")
	public List<Leave> findAllLeaveApplications();
	
	@Insert("insert into leaves(leaveType,toDate,fromDate,description,empId,deptId,days) values(#{leaveType},#{toDate},#{fromDate},#{description},#{empId},#{deptId},#{days})")
	@Options(useGeneratedKeys = true, keyProperty = "leaveId")
	public void addNewLeave(Leave leave);
	
	@Select("select * from leaves where empId=#{empId} order by leaveId desc")
	public List<Leave> findLeaveApplicationsByEmpId(Integer empId);
	
	@Select("select * from leaves where deptId=#{deptId} order by leaveId desc")
	public List<Leave> findLeaveApplicationsByDeptId(Integer deptId);
	
	@Select("select * from leaves where leaveId=#{leaveId}")
	public Leave findById(Integer leaveId);
	
	@Update("update leaves set status='APPROVED' where leaveId=#{leaveId}")
	public void approveLeave(Integer leaveId);
	
	@Update("update leaves set status='DECLINED' where leaveId=#{leaveId}")
	public void declineLeave(Integer leaveId);

}
