<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>UC - 用户${phone}信息管理</title>
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
			<li class="active"><s:a action="userAction_list">
					<i class="icon icon-user"></i>
					<span>用户管理</span>
				</s:a></li>
			<li><s:a action="versionAction_list">
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
				<a href="userAction_list" title="Go to Home" class="tip-bottom"><i
					class="icon-home"></i> 用户管理</a>
			</div>
		</div>
		<div class="box">
			<form>
				<table class="table-condensed table-bordered" width="100%"
					border="0" cellspacing="0" cellpadding="0" align="center">
					<tr>
						<td colspan="2" align="center"
							style="background-color:#1f262d; font-size:20px; line-height:40px; color:#FFF;">个人资料</td>
					</tr>

					<tr>
						<td width="106" height="92" class="content">头像</td>
						<td width="270"><div class="div1">
								<img src="${headpic }" class="content"
									style="width:165px;height:119px" />
							</div>
						</td>
					</tr>
					<tr>
						<td class="content">用户名</td>
						<td class="content "><div class="div1">${phone}</div>
						</td>
					</tr>
					<tr>
						<td class="content">用户昵称</td>
						<td class="content ">${nickname}</td>
					</tr>

					<tr>
						<td class="content">性别</td>
						<td class="content"><s:radio name="sex"
								list="#{'1':'男','0':'女'}"></s:radio></td>
					</tr>
					<tr>
						<td class="content">职业</td>
						<td class="content"><div class="div1">${profession }</div>
						</td>
					</tr>
					<tr>
						<td class="content">爱好</td>
						<td class="content "><div class="div1">${hobby}</div>
						</td>
					</tr>
					<tr>
						<td class="content">手机号</td>
						<td class="content"><div class="div1">${phone }</div>
						</td>
					</tr>
					<tr>
						<td class="content">电子邮箱</td>
						<td class="content"><div class="div1">${email }</div>
						</td>
					</tr>
					<tr>
						<td class="content">个人描述</td>
						<td class="content"><div class="div1">
								<s:textarea cssClass="noedit" name="description" id="textarea"
									cols="27" rows="5"></s:textarea>
							</div>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><s:a action="userAction_list" cssClass="btn btn-success"
								style="width:70px;">确定</s:a>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<div class="row-fluid">
		<div id="footer" class="span12">
			2015 &copy; University Campus <a
				href="http://user.qzone.qq.com/492736173/">技术支持:Hyr</a>
		</div>
	</div>

	<!--goto page -->
	<script type="text/javascript">
		function gotoPage(pageNum) {
			//window.location.href="forumAction_show.action?id=${id}&pageNum="+pageNum;
			$(document.forms[1])
					.append(
							"<input type='hidden' name='pageNum' value='" + pageNum + "'/>");
			document.forms[1].submit();
		};
	</script>

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

	<script type="text/javascript">
		$(".noedit").prop("readonly", true);
	</script>
</body>
</html>
