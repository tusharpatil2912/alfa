<%@ include file="./header.jsp"%>
<%@ include file="./manager-sidebar.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
    <div class="col-md-11 col-sm-12">

        <h3>Employees List</h3>
        <hr />
        
         <div class="row">
        <div>
        <table class="table table-striped table-hover table-responsive">
        <col width="150">
        <col width="150">
        <col width="150">
        <col width="300">
        
        <thead class="table table-dark">
        <tr>
            <th id="empId">Employee Id</th>
            <th id="fname">First Name</th>
            <th id="lname">Last Name</th>
            <th id="email">Email</th>
        </tr>    
        </thead>
        
        <tbody>
            <c:forEach items="${employee}" var="l">
            <tr>
                <td>${l.empId}</td>
                
                <td>${l.fname}</td>
                <td>${l.lname}</td>
                <td>${l.email}</td>
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