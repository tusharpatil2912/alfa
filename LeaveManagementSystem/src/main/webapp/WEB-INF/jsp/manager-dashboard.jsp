<%@ include file="./header.jsp"%>
<%@ include file="./manager-sidebar.jsp"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-11 col-sm-12">

        <h3>Manager Dashboard</h3>
        <hr />
        
        <div class="row">
        <div class="col-md-12">
            <table class="table">
                <tbody>
                    <tr>
                        <th id="">Employee Id</th>
                        <td>${manager.empId}</td>
                    </tr>
                    <tr>
                        <th id="">First Name</th>
                        <td>${manager.fname}</td>
                    </tr>
                    <tr>
                        <th id="">Last Name</th>
                        <td>${manager.lname}</td>
                    </tr>
                    <tr>
                        <th id="">Email</th>
                        <td>${manager.email}</td>
                    </tr>
                    <tr>
                        <th id="">Phone</th>
                        <td>${manager.phone}</td>
                    </tr>
                    <tr>
                        <th id="">Gender</th>
                        <td>${manager.gender}</td>
                    </tr>
                    <tr>
                        <th id="">City</th>
                        <td>${manager.city}</td>
                    </tr>
                    <tr>
                        <th id="">Country</th>
                        <td>${manager.country}</td>
                    </tr>
                    <tr>
                        <th id="">Date of Birth</th>
                        <td>${manager.dob}</td>
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