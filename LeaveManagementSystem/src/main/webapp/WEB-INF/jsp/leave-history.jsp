<%@ include file="./header.jsp" %>
<%@ include file="./employee-sidebar.jsp" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Leave History</h2>
<table class="table">
    <caption></caption>
    <thead>
        <tr>
        	<th id="leaveType">Leave Type</th>
            <th id="fromDate">From Date</th>
            <th id="toDate">To Date</th>
            <th id="postingDate">Posting Date</th>
            <th id="status">Status</th>
        </tr>   
    </thead>
    <tbody>
        <c:forEach items="${leave}" var="m">
        <tr>
        	<td>${m.leaveType}</td>
            <td>${m.fromDate}</td>
            <td>${m.toDate}</td>
            <td>${m.postingDate}</td>
            <td><button class="badge badge-pill badge-${m.status=='APPROVED'?'success':m.status=='DECLINED'?'danger':'primary'}">${m.status}</button></td>
        </tr>
        </c:forEach>
    </tbody>
</table>

<%@ include file="./footer.jsp" %> 