<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>UC - 管理员登陆</title>
<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
<link rel="stylesheet" href="<%=basePath%>css/matrix-login.css" />
</head>

<body>
	<div id="loginbox">
		<s:form action="adminAction_login" id="loginform"
			class="form-vertical">
			<div class="control-group normal_text">
				<h3>
					<img src="img/ucImg/logo.png" alt="Logo" />
				</h3>
			</div>
			<div class="control-group">
				<div class="controls">
					<div class="main_input_box">
						<span class="add-on bg_lg"><i class="icon-user"></i> </span><input
							name="phone" type="text" placeholder="用户名" />
					</div>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<div class="main_input_box">
						<span class="add-on bg_ly"><i class="icon-lock"></i> </span><input
							name="password" type="password" placeholder="密码" />
					</div>
				</div>
			</div>
			<div class="form-actions">

				<span class="pull-right"><button type="submit"
						class="btn btn-success">登录</button> <a href="index.jsp"
					Class="btn btn-success">返回</a>
			</div>
		</s:form>
	</div>


	<script src="<%=basePath%>js/excanvas.min.js"></script>
	<script src="<%=basePath%>js/jquery.min.js"></script>
	<script src="<%=basePath%>js/jquery.ui.custom.js"></script>
	<script src="<%=basePath%>js/bootstrap.min.js"></script>
	<script src="<%=basePath%>js/jquery.flot.min.js"></script>
	<script src="<%=basePath%>js/jquery.flot.resize.min.js"></script>
	<script src="<%=basePath%>js/jquery.peity.min.js"></script>
	<script src="<%=basePath%>js/matrix.dashboard.js"></script>

	<script src="<%=basePath%>js/matrix.chat.js"></script>
</body>
</html>