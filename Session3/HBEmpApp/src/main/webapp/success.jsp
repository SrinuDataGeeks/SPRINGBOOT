<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
  <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Page</title>
</head>
<body>
<h1></h1>

<c:choose>

<c:when test="${employeeList != null  &&  employeeList.size() > 0}">
	<table border="1">
	<tr>
	<th> Employee ID </th>
	<th> Employee Name </th>
	<th> Employee Sal </th>
	<th> Edit </th>
	<th> Delete </th>
	</tr>
	<c:forEach items="${employeeList}" var="employee">
	<tr>
	<td>${employee.employeeId } </td>
	<td>${employee.employeeName } </td>
	<td>${employee.employeeSal } </td>
	<td><a href='./editPage?empId=${employee.employeeId}'> Edit</a></td>
	<td><a href='./delete?empId=${employee.employeeId}'> Delete</a></td>
	</tr>
	</c:forEach>
	</table>
</c:when>

<c:otherwise>
<h1> <font color="red"> <strong> Employee Details Does not exist </strong></font></h1>
</c:otherwise>

</c:choose>
	
	
</body>
</html>