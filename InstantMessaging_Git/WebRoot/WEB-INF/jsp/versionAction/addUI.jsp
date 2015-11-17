<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>UC - 版本发布</title>
<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
</head>

<body>


	<!--Header-part-->
	<div id="header">
		<h1>
			<a href="homeAction_indexl">UC_后台管理系统</a>
		</h1>
	</div>
	<!--close-Header-part-->

	<!--top-Header-menu-->
	<div id="user-nav" class="navbar navbar-inverse">
		<ul class="nav">
			<li class="dropdown" id="profile-messages"><s:a title=""
					action="adminAction_show" data-toggle="dropdown"
					data-target="#profile-messages" cssClass="dropdown-toggle">
					<i class="icon icon-user"></i>
					<span class="text">欢迎:admin</span>
					<b class="caret"></b>
				</s:a>
				<ul class="dropdown-menu">
				</ul>
			</li>

			<li class=""><s:a action="adminAction_logout">
					<i class="icon icon-share-alt"></i>
					<span class="text">注销</span>
				</s:a></li>
		</ul>
	</div>
	<!--close-top-Header-menu-->

	<!--sidebar-menu-->
	<div id="sidebar">
		<a href="homeAction_index" class="visible-phone"><i
			class="icon icon-home"></i>主页</a>
		<ul>
			<li><a href="homeAction_index"><i class="icon icon-home"></i>
					<span>主页</span> </a></li>
			<li><s:a action="themeAction_list">
					<i class="icon icon-signal"></i>
					<span>活动管理</span>
				</s:a></li>
			<li><s:a action="userAction_list">
					<i class="icon icon-user"></i>
					<span>用户管理</span>
				</s:a></li>
			<li class="active"><s:a action="versionAction_list">
					<i class="icon icon-inbox"></i>
					<span>版本管理</span>
				</s:a></li>
			<li><s:a action="messagePushAction_sendUI">
					<i class="icon icon-comment"></i>
					<span>消息推送</span>
				</s:a>
			</li>
		</ul>
	</div>
	<!--sidebar-menu-->

	<!--main-container-part-->
	<div id="content">
		<div id="content-header">
			<div id="breadcrumb">
				<a href="versionAction_list" title="Go to Home" class="tip-bottom"><i
					class="icon-home"></i> 版本管理</a>
			</div>
		</div>

		<div class="container-fluid">
			<div class="row-fluid">
				<div class="widget-box">
					<div class="widget-title">
						<h5>版本管理</h5>
					</div>
					<s:form action="versionAction_add" method="post"
						enctype="multipart/form-data">

						<div class="ItemBlock_Title1">
							<!-- 信息说明 -->
							<div class="ItemBlock_Title1">
								<img border="0" width="4" height="7"
									src="<%=basePath%>img/item_point.gif" /> 版本基本信息
							</div>
						</div>

						<!-- 表单内容显示 -->
						<div class="ItemBlockBorder">
							<div class="ItemBlock">
								<table
									class="table table-bordered table-striped with-check container"
									style="font-family:微软雅黑; font-size:14px;">
									<tr class="col-sm-10">
										<td class="col-sm-4">软件名称</td>
										<td class="col-sm-6"><s:textfield name="soft_name"
												value="UC" cssClass="InputStyle required" /> *</td>
									</tr>
									<tr class="col-sm-10">
										<td class="col-sm-4">软件版本</td>
										<td class="col-sm-6"><s:textfield name="version"
												cssClass="InputStyle required" /> *</td>
									</tr>
								</table>
							</div>
						</div>

						<div class="ItemBlock_Title1">
							<!-- 信息说明 -->
							<div class="ItemBlock_Title1">
								<img border="0" width="4" height="7"
									src="<%=basePath%>img/item_point.gif" /> 版本文件
							</div>
						</div>

						<!-- 表单内容显示 -->
						<div class="ItemBlockBorder">
							<div class="ItemBlock">
								<table cellpadding="0" cellspacing="0" class="mainForm">
									<tr class="col-sm-10">
										<td class="col-sm-5">请选择发布文件</td>
										<td><input type="file" name="upload"
											class="InputStyle required" style="width:450px;" /></td>
									</tr>
								</table>
							</div>
						</div>

						<!-- 表单操作 -->
						<p></p>
						<div id="InputDetailBar">
							<button type="submit" class="btn btn-success">添加</button>
							<a href="javascript:history.go(-1);"><div
									class="btn btn-default">返回</div> </a>
						</div>

					</s:form>


				</div>

			</div>
		</div>

		<!--end-main-container-part-->
	</div>
	<!--Footer-part-->

	<div class="row-fluid">
		<div id="footer" class="span12">
			2015 &copy; University Campus <a
				href="http://user.qzone.qq.com/492736173/">技术支持:Hyr</a>
		</div>
	</div>


	<!--end-Footer-part-->
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
