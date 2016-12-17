<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RegisterForm</title>
<sf:form method="post" commandName="spitter">
	FirstName:<sf:input path="firstName"/><br>
	LastName:<sf:input path="lastName"/><br>
	Email:<sf:input path="email"/><br>
	Username:<sf:input path="username"/><br>
	Password:<sf:password path="email"/><br>
	<input type="submit" value="Register" />
</sf:form>
</head>
<body>

</body>
</html>