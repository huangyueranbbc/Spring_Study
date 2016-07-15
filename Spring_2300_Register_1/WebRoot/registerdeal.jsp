<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String username=request.getParameter("username");
String password1=request.getParameter("password1");
String password2=request.getParameter("password2");
Class.forName("com.mysql.jdbc.Driver");
Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/admin","root","666666");
//检查用户名是否存在
String sqlQuery="select count(*) from userregister where username = ?";
PreparedStatement psQuery=connection.prepareStatement(sqlQuery);
psQuery.setString(1, username);
ResultSet rs=psQuery.executeQuery();
rs.next();
int count=rs.getInt(1);
if(count>0){
	response.sendRedirect("registerfailed.jsp");
	psQuery.close();
	connection.close();
	return;
}


String sql="insert into userregister values(null,?,?)";
PreparedStatement pstmt=connection.prepareStatement(sql);
pstmt.setString(1, username);
pstmt.setString(2, password1);
pstmt.executeUpdate();
pstmt.close();
connection.close();

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
