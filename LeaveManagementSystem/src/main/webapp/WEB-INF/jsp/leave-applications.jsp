<%@ include file="./header.jsp"%>
<%@ include file="./manager-sidebar.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
    <div class="col-md-11 col-sm-12">

        <h3>Leave Applications</h3>
        <hr />
        
         <div class="row">
        <div>
        <table class="table table-striped table-hover">
        <col width="150">
        <col width="200">
        <col width="250">
        <col width="150">
        <col width="300">
        <thead class="table table-dark">
        <tr>
            <th id="empId">Employee Id</th>
            
            <th id="leaveType">Leave Type</th>
            <th id="postingDate">Posting Date</th>
            <th id="status" >Status</th>
            <th id="action">Action</th>
        </tr>    
        </thead>
        
        <tbody>
            <c:forEach items="${leave}" var="l">
            <tr>
                <td>${l.empId}</td>
                
                <td>${l.leaveType}</td>
                <td>${l.postingDate}</td>
                <td><button class="badge badge-pill badge-${l.status=='APPROVED'?'success':l.status=='DECLINED'?'danger':'primary'}">${l.status}</button></td>
                <td><a href="./leave-details?leaveId=${l.leaveId}"><button class="btn btn-primary">View Details</button></a></td>
            </tr>
            </c:forEach>
        </tbody>
        </table>
        </div>
        </div>
        
        
        <h2 class="text-danger">${errMsg}</h2>
    </div>
    <div class="col-md-2"></div>
</div>

<%@ include file="./footer.jsp"%>