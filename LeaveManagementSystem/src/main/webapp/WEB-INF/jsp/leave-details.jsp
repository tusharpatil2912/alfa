<%@ include file="./header.jsp"%>
<%@ include file="./manager-sidebar.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h5>Leave Details</h5>

<table class="table">
	<caption></caption>
	<tr>
		<th id="">Emp Id</th>
		<td>${leave.empId}</td>
	</tr>
	<tr>
		<th id="">Emp Name</th>
		<td>${emp.fname} ${emp.lname}</td>
	</tr>
	<tr>
		<th id="">Emp Email</th>
		<td>${emp.email}</td>
	</tr>
	<tr>
		<th id="">Leave Type</th>
		<td>${leave.leaveType}</td>
	</tr>
	<tr>
		<th id="">From Date</th>
		<td>${leave.fromDate}</td>
	</tr>
	<tr>
		<th id="">To Date</th>
		<td>${leave.toDate}</td>
	</tr>
	<tr>
		<th id="">Description</th>
		<td><pre style="font-family: inherit; font-size: inherit; ">${leave.description}</pre></td>
	</tr>
</table>

<hr />

<a class="btn btn-success ${leave.status!='PENDING'?'disabled':''}" href="./approve-leave?leaveId=${leave.leaveId}">Approve</a>
<a class="btn btn-danger ${leave.status!='PENDING'?'disabled':''}" href="./decline-leave?leaveId=${leave.leaveId}">Decline</a>
<%@ include file="./footer.jsp"%>