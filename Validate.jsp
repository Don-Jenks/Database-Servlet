<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page Login</title>
</head>
<body>

<h1>User Details</h1>
<!-- Form to get username and password then open the validateuser JSP page -->
<form method="get" action="validateuser.jsp">
	Enter Username: <input type="text" name="user"><br/><br/>
	Enter Password: <input type="password" name="pass"><br/>
	<input type="submit" value="SUBMIT">
</form>

</body>
</html>