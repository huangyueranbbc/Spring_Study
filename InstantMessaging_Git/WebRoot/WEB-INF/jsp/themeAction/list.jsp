<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>UC - 活动管理</title>
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
					<span class="text">注销 </span>
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
			<li class="active"><s:a action="themeAction_list">
					<i class="icon icon-signal"></i>
					<span>活动管理</span>
				</s:a>
			</li>
			<li><s:a action="userAction_list">
					<i class="icon icon-user"></i>
					<span>用户管理</span>
				</s:a>
			</li>
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
				<a href="themeAction_list" title="Go to Home" class="tip-bottom"><i
					class="icon-home"></i> 活动管理</a>
			</div>
		</div>

		<table>
			<tbody>
				<tr>
					<td class="col-sm-3">
						<div id="lists_search">
							<form action="themeAction_listbycheck" method="get">主题类型：


							
					</td>
					<td><s:select name="themebytypeid"
							onchange="onSortByChange(this.value)" list="#request.typelists" />
					</td>
					<td>
						</div>
					</td>
					<td><s:a action="typeAction_list" cssClass="btn btn-success">修改主题类型</s:a>
					</td>
				</tr>

				<tr>
					<td class="col-sm-3">
						<div id="lists_search">用户手机：
					</td>
					<td><s:textfield name="phone" value=""></s:textfield>
					<td>
						</div>
					</td>
				</tr>

				<tr>
					<td class="col-sm-3">
						<div id="lists_search">关键字：
					</td>
					<td><s:textfield name="keyword" value=""></s:textfield>
					<td>
						<button type="submit" id="btn_list_search" class="btn btn-success">查询</button>
					</td>
					<td>
						</form>
						</div>
					</td>
				</tr>
			</tbody>
		</table>


		<div class="container-fluid">
			<div class="row-fluid">
				<div class="widget-box">
					<div class="widget-title">
						<span class="icon"> <input type="checkbox"
							id="title-checkbox" name="title-checkbox" /> </span>
						<h5>活动管理</h5>
					</div>

					<div class="widget-content nopadding">
						<table class="table table-bordered table-striped with-check">
							<thead>
								<tr>
									<th><i class="icon-resize-vertical"></i></th>
									<th></th>
									<th>活动信息</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="recordList">
									<tr class="TableDetail1 template">
										<td><input type="checkbox" /></td>
										<td style="width:140px"><s:a
												action="themeAction_show?id=%{id}">
												<img src="${themepic }" style="width:140px;height:97px" />
											</s:a>
										</td>
										<td>
											<p>主题【${typename}】</p>
											<p>内容:${content}</p>
											<p>地点：${ip}</p>
											<p>
												作者:${phone}&nbsp;&nbsp;发表时间:
												<s:date name="createtime" format="yyyy-MM-dd HH:mm:ss" />
												&nbsp;
											</p>
										</td>

										<td width="100px"><s:a action="themeAction_show?id=%{id}">查看</s:a>
											<s:a action="themeAction_delete?id=%{id}"
												onClick="return delConfirm()">删除</s:a>
										</td>
									</tr>
								</s:iterator>

								<!-- ~~~~~~~~~~~~~~~ 分页信息 ~~~~~~~~~~~~~~~ -->
								<s:form action="themeAction_list" method="get">
								</s:form>

								<tr>
									<td colspan="12">
										<div class="list_page">
											<div id="pages">
												共 ${pageCount} 页： &nbsp;

												<!-- 首页 -->
												<s:if test="currentPage==1">
													<%-- 等于当前页的显示效果 --%>
													<a href="javascript:gotoPage(1)" title="首页"
														style="cursor: hand;" class=" btn btn-default disabled">首页</a>
												</s:if>
												<s:else>
													<%-- 不等于当前页的显示效果 --%>
													<a href="javascript:gotoPage(1)" title="首页"
														style="cursor: hand;">首页</a>
												</s:else>


												<!-- 上一页 -->
												<s:if test="currentPage==1">
													<%-- 等于当前页的显示效果 --%>
													<a href='javascript:gotoPage(${currentPage})'
														class=" btn btn-default disabled">上一页</a>&nbsp;
						</s:if>
												<s:else>
													<%-- 不等于当前页的显示效果 --%>
													<a href='javascript:gotoPage(${currentPage-1})'>上一页</a>&nbsp;
						</s:else>

												<s:iterator begin="%{beginPageIndex}" end="%{endPageIndex}"
													var="num">
													<s:if test="currentPage==#num">
														<%-- 等于当前页的显示效果 --%>
														<span class="current">${num}</span>
													</s:if>
													<s:else>
														<%-- 不等于当前页的显示效果 --%>
														<a href="javascript:gotoPage(${num});">&nbsp;${num}&nbsp;</a>
													</s:else>
												</s:iterator>

												<!-- 下一页 -->
												<s:if test="currentPage==endPageIndex">
													<%-- 等于当前页的显示效果 --%>
													<a href='javascript:gotoPage(${currentPage})'
														class=" btn btn-default disabled">下一页</a>&nbsp;
												</s:if>
												<s:else>
													<%-- 不等于当前页的显示效果 --%>
													<a href='javascript:gotoPage(${currentPage+1})'>下一页</a>&nbsp;
												</s:else>

												<!-- 尾页 -->
												<s:if test="currentPage==endPageIndex">
													<%-- 等于当前页的显示效果 --%>
													<a href="javascript:gotoPage(${endPageIndex})" title="尾页"
														style="cursor: hand;" class=" btn btn-default disabled">尾页</a>
												</s:if>
												<s:else>
													<%-- 不等于当前页的显示效果 --%>
													<a href="javascript:gotoPage(${endPageIndex})" title="尾页"
														style="cursor: hand;">尾页</a>
												</s:else>


												转到： <select id="pn" onchange="gotoPage(this.value)">
													<s:iterator begin="1" end="%{pageCount}" var="num">
														<option value="${num}">${num}</option>
													</s:iterator>
												</select>
												<div style="clear:both"></div>
											</div>
									</td>

								</tr>
								<!-- ~~~~~~~~~~~~~~~ 分页结束 ~~~~~~~~~~~~~~~ -->

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
</body>
</html>
