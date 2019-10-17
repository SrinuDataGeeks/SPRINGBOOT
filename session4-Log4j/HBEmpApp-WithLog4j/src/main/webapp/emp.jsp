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

<f:form method="POST"  action="loadById"  modelAttribute="empModelBean">

Employee Id <f:input path="empId" />

<input type="submit" value="getById"/>

</f:form>

</body>
</html>