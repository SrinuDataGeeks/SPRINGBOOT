<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>

<f:form method="POST"  action="saveOrUpdate"  modelAttribute="employeeBean">

Employee Id <f:input path="employeeId" readonly="true" /> <br>

Employee Name <f:input path="employeeName" /> <br>

Employee Sal <f:input path="employeeSal" /> <br>

<input type="submit" value="saveOrUpdate"/>

</f:form>

</body>
</html>