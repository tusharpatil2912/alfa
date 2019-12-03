<%@ include file="./header.jsp"%>
<%@ include file="./admin-sidebar.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<h2>Register New ${title}</h2>
<hr/> 

<sf:form modelAttribute="emp" cssClass="form" action="./add-new-${posttitle}">
	<sf:hidden path="empId" />

	<div class="form-group row">
		<label class="col-md-3">First Name</label>
		<div class="col-md-6">
			<sf:input path="fname" cssClass="form-control" />
			<sf:errors path="fname" cssClass="text-danger" />
		</div>
	</div>

	<div class="form-group row">
		<label class="col-md-3">Last Name</label>
		<div class="col-md-6">
			<sf:input path="lname" cssClass="form-control" />
		</div>
	</div>

	<div class="form-group row">
		<label class="col-md-3">Email Id</label>
		<div class="col-md-6">
			<sf:input path="email" cssClass="form-control" />
			<sf:errors path="email" cssClass="text-danger" />
		</div>
	</div>

	<div class="form-group row">
		<label class="col-md-3">Password</label>
		<div class="col-md-6">
			<sf:input type="password" path="password" cssClass="form-control" />
		</div>
	</div>

	<div class="form-group row">
		<label class="col-md-3">Gender</label>
		<div class="col-md-9">
			<sf:radiobutton path = "gender" value = "Male" label = "Male" />
            <sf:radiobutton path = "gender" value = "Female" label = "Female" />
		</div>

	</div>

	<div class="form-group row">
		<label class="col-md-3">Date of Birth</label>
		<div class="col-md-6">
			<sf:input path="dob" type="date" cssClass="form-control" />
			
		</div>
	</div>

	  <div class="form-group row">
		<label class="col-md-3">Department</label>
		<div class="col-md-6">
			<sf:select path = "deptId" cssClass="form-control">
                     <sf:option value = "" label = "Select"/>
                     <sf:options items = "${dept}" itemValue="deptId" itemLabel="deptName"/>
            </sf:select>
            <sf:errors path="deptId" cssClass="text-danger" /> 
		</div>
	</div>
 
	<div class="form-group row">
		<label class="col-md-3">City</label>
		<div class="col-md-6">
			<sf:input path="city" cssClass="form-control" />
			
		</div>
	</div>

	<div class="form-group row">
		<label class="col-md-3">Country</label>
		<div class="col-md-6">
			<sf:input path="country" cssClass="form-control" />
		</div>
	</div>

	<div class="form-group row">
		<label class="col-md-3">Phone No.</label>
		<div class="col-md-6">
			<sf:input path="phone" cssClass="form-control" />
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