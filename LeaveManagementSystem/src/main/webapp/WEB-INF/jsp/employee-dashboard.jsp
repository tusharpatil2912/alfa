<%@ include file="./header.jsp"%>
<%@ include file="./employee-sidebar.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10 col-sm-12">

        <h3>Employee Dashboard</h3>
        <hr />

        <div class="row">
            <div class="col-md-12">
                <table class="table">
                    <tbody>
                        <tr>
                            <th id="">Employee Id</th>
                            <td>${employee.empId}</td>
                        </tr>
                        <tr>
                            <th id="">First Name</th>
                            <td>${employee.fname}</td>
                        </tr>
                        <tr>
                            <th id="">Last Name</th>
                            <td>${employee.lname}</td>
                        </tr>
                        <tr>
                            <th id="">Department Id</th>
                            <td>${employee.deptId}</td>
                        </tr>
                        <tr>
                            <th id="">Email</th>
                            <td>${employee.email}</td>
                        </tr>
                        <tr>
                            <th id="">Phone</th>
                            <td>${employee.phone}</td>
                        </tr>
                        <tr>
                            <th id="">Gender</th>
                            <td>${employee.gender}</td>
                        </tr>
                        <tr>
                            <th id="">City</th>
                            <td>${employee.city}</td>
                        </tr>
                        <tr>
                            <th id="">Country</th>
                            <td>${employee.country}</td>
                        </tr>
                        <tr>
                            <th id="">Date of Birth</th>
                            <td>${employee.dob}</td>
                        </tr>
                       
                    </tbody>
                </table>
            </div>
        </div>

        <h2 class="text-danger">${errMsg}</h2>
    </div>
    <div class="col-md-2"></div>
</div>

<%@ include file="./footer.jsp"%>
