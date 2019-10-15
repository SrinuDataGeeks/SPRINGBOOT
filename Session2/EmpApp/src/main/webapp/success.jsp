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



<c:when test="${employee != null }">
<br><font color="blue"> <strong> ${employee.employeeId }  :: ${employee.employeeName } :: ${employee.employeeSal }</strong></font>
</c:when>

<c:otherwise>
<h1> <font color="red"> <strong> Employee Details Does not exist </strong></font></h1>
</c:otherwise>
</c:choose>
	
	
</body>
</html>