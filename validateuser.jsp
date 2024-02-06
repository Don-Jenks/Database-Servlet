<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Verifying Details</h1>
<!-- Instantiating a bean to validate a user -->
<jsp:useBean id="ValidateCode" class="validate.bean.ValidateCode">

<!-- Setting the value of the created bean using the form data -->
<jsp:setProperty name="ValidateCode" property="user"/>
<jsp:setProperty name="ValidateCode" property="pass"/>

</jsp:useBean>
<!-- Displaying the form data -->
<p>Username : <jsp:getProperty name="ValidateCode" property="user"/></p>
<p>Password : <jsp:getProperty name="ValidateCode" property="pass"/></p>

<!-- Validating the user using the validate() method -->
<%if(ValidateCode.validate("Donald", "changeit")) { %>
	Welcome! You are a VALID USER<br/>
<%}else{ %>
	Error! You are an INVALID USER<br/>
<%} %>

<p>Select this link to go to a page that will connect and print the tables of a database!</p>
<a href="database.html">Database Page</a>

</body>
</html>