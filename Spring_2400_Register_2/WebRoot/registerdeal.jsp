<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.hyr.register.service.*" %>
<%@page import="com.hyr.register.model.*" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String username=request.getParameter("username");
String password=request.getParameter("password");
String password2=request.getParameter("password2");
User user=new User();
user.setUsername(username);
user.setPassword(password);
Class.forName("com.mysql.jdbc.Driver");
Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/admin","root","666666");
UserManager userManager=new UserManager();
boolean exist=userManager.exists(user);
if(exist){
response.sendRedirect("registerfailed.jsp");
return;
}
userManager.add(user);
response.sendRedirect("registersuccess.jsp");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  </body>
</html>
