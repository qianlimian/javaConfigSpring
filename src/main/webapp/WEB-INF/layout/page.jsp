<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page.jsp(用于扩展的)</title>
<link rel="stylesheet" type="text/css" href='<s:url value="/resources/style.css"></s:url>' />
</head>
<body>
	<div id="header">
		<t:insertAttribute name="header"></t:insertAttribute> 
	</div>
	<div id="content">
		<t:insertAttribute name="body"></t:insertAttribute> 
	</div>
	<div id="footer">
		<t:insertAttribute name="footer"></t:insertAttribute> 
	</div>
	
</body>
</html>