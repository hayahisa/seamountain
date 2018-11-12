<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page	import="model.UserBean"%>
<%
	UserBean userdetails = new UserBean();
	userdetails = (UserBean)request.getAttribute("userdetails");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p><%=userdetails.getUserName() %></p>
	<p><%=userdetails.getUserNo() %></p>
	<p><%=userdetails.getUserYear() %></p>
	<p><%=userdetails.getCourseId() %></p>

</body>
</html>