<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RegisterForm</title>
<style type="text/css">
span.error {
	color:red;
}
label.error {
	color:red;
}
input.error {
	background-color: #ffcccc;
}
</style>
<sf:form action="register" method="post" commandName="spitter" enctype="multipart/form-data">
	<sf:label path="firstName" cssErrorClass="error">FirstName:</sf:label>
	<sf:input path="firstName" cssErrorClass="error"/><sf:errors path="firstName" cssClass="error"></sf:errors><br>
	
	<sf:label path="lastName" cssErrorClass="error">LastName:</sf:label>
	<sf:input path="lastName" cssErrorClass="error"/><sf:errors path="lastName" cssClass="error"></sf:errors><br>
	Email:<sf:input path="email"/><br>
	Username:<sf:input path="username"/><br>
	Password:<sf:password path="password"/><br>
	<input type="file" name="picture" accept="image/jpeg,image/png,image/gif" /><br>
	<input type="submit" value="Register" />
</sf:form>
</head>
<body>

</body>
</html>