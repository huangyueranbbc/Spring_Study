<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>UC - 版本管理</title>
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
				</ul></li>

			<li class=""><s:a action="adminAction_logout">
					<i class="icon icon-share-alt"></i>
					<span class="text">注销</span>
				</s:a>
			</li>
		</ul>
	</div>
	<!--close-top-Header-menu-->

	<!--sidebar-menu-->
	<div id="sidebar">
		<a href="homeAction_index" class="visible-phone"><i
			class="icon icon-home"></i>主页</a>
		<ul>
			<li><a href="homeAction_index"><i class="icon icon-home"></i>
					<span>主页</span> </a>
			</li>
			<li><s:a action="themeAction_list">
					<i class="icon icon-signal"></i>
					<span>活动管理</span>
				</s:a>
			</li>
			<li><s:a action="userAction_list">
					<i class="icon icon-user"></i>
					<span>用户管理</span>
				</s:a>
			</li>
			<li class="active"><s:a action="versionAction_list">
					<i class="icon icon-inbox"></i>
					<span>版本管理</span>
				</s:a>
			</li>
			<li><s:a action="messagePushAction_sendUI">
					<i class="icon icon-comment"></i>
					<span>消息推送</span>
				</s:a></li>
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

					<!-- 其他功能超链接 -->
					<div id="TableTail">
						<div id="TableTail_inside">
							<s:a cssClass="btn btn-success" action="versionAction_addUI">发布新版本</s:a>
						</div>
					</div>

					<div class="widget-content nopadding">
						<table
							class="table table-bordered table-striped with-check container-fluid"
							style="font-family:微软雅黑; font-size:14px;">
							<thead>
								<tr>
									<th>软件名称</th>
									<th>版本号</th>
									<th>发布时间</th>
									<th>软件下载地址</th>
									<th>服务器存放路径</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="#versionList">
									<tr class="TableDetail1 template">
										<td class="col-md-2">${soft_name}&nbsp;</td>
										<td class="col-md-1">${version}&nbsp;</td>
										<td class="col-md-2">${time}&nbsp;</td>
										<td class="col-md-1">${url }&nbsp;</td>
										<td class="col-md-3">${path}&nbsp;</td>
										<td class="col-md-2"><s:a onClick="return delConfirm()"
												action="versionAction_delete?id=%{id}">删除</s:a> <s:a
												action="versionAction_download?id=%{id}">下载</s:a>
										</td>
									</tr>
								</s:iterator>

							</tbody>
						</table>

					</div>
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
