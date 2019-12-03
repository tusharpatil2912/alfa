<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ include file="./header.jsp"%>
<%@ include file="./employee-sidebar.jsp"%>

<h3>Apply For Leave</h3>
<hr />


<sf:form modelAttribute="leave" cssClass="form" action="./apply-leave">
    <sf:hidden path="empId"  />
    <sf:hidden path="deptId"  />

    <div class="form-group row">
        <label for="From Date" class="col-sm-2 col-form-label">From
            Date</label>
        <div class="col-sm-10">
            <sf:input path="fromDate" type="date" class="form-control" id="fromDate" name="fromDate" onchange="cal()"/>
            <sf:errors path="fromDate" cssClass="text-danger" />
        </div>
    </div>
    
    <div class="form-group row">
        <label for="To Date" class="col-sm-2 col-form-label">To Date</label>
        <div class="col-sm-10">
            <sf:input path="toDate" type="date" class="form-control" id="toDate" name="toDate" onchange="cal()"/>
            <sf:errors path="toDate" cssClass="text-danger" />
        </div>
    </div>
	<div id="days" class="form-group row">
		<label for="Days" class="col-sm-2 col-form-label">Days</label>
		<div class="col-sm-10">
		<sf:input path="days" type="text" class="form-control" id="days2" name="days"/>
		</div>
	</div>	
    <div class="form-group row">
        <label for="leavetype" class="col-sm-2 col-form-label">Leave Type</label>
        <div class="col-sm-10">
            <sf:select path="leaveType" class="custom-select my-1 mr-sm-2" id="leavetype">
            	<sf:option value = "">--Select--</sf:option>
    			<sf:option value="Sick Leave">Sick Leave</sf:option>
    			<sf:option value="Paid Leave">Paid Leave</sf:option>
    			<sf:option value="Casual Leave">Casual Leave</sf:option>
  			</sf:select>
  			<sf:errors path="leaveType" cssClass="text-danger" />
        </div>
    </div>



    <div class="form-group row">
        <label for="body" class="col-sm-2 col-form-label">Description</label>
        <div class="col-sm-10">
            <sf:textarea path="description" class="form-control" rows="5" id="description" name="description"/>
        </div>
    </div>
    <div class="col-md-4">
        <button class="btn btn-primary">Send</button>
    </div>
    <div class="col-md-4">
    </div>
</sf:form>
<h2 class="text-primary">${msg}</h2>
<%@ include file="./footer.jsp"%>