<%@ include file="./header.jsp"%>
<%@ include file="./admin-sidebar.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<h2>Register New ${title}</h2>
<hr/> 

<sf:form modelAttribute="dept" cssClass="form" action="./add-new-department">
	<sf:hidden path="deptId" />

	<div class="form-group row">
		<label class="col-md-3">Department Name</label>
		<div class="col-md-6">
			<sf:input path="deptName" cssClass="form-control" />
			<sf:errors path="deptName" cssClass="text-danger" />
		</div>
	</div>

	<div class="form-group row">
		<label class="col-md-3">Short Name</label>
		<div class="col-md-6">
			<sf:input path="deptShortName" cssClass="form-control" />
			<sf:errors path="deptShortName" cssClass="text-danger" />
		</div>
	</div>

	<div class="form-group row">
		<label class="col-md-3">Department Code</label>
		<div class="col-md-6">
			<sf:input path="deptCode" cssClass="form-control" />
			<sf:errors path="deptCode" cssClass="text-danger" />
		</div>
	</div>

	<div class="form-group row">
		<label class="col-md-3"></label>
		<div class="col-md-8">
			<button class="btn btn-primary">Register</button>
		</div>
	</div>
</sf:form>
<h2 class="text-primary">${msg}</h2>
<%@ include file="./footer.jsp"%>