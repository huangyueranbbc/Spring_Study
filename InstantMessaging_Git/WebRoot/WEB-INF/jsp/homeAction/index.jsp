<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>UC - 后台主页</title>
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
			<li class="active"><a href="homeAction_index"><i
					class="icon icon-home"></i> <span>主页</span> </a>
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
			<li><s:a action="versionAction_list">
					<i class="icon icon-inbox"></i>
					<span>版本管理</span>
				</s:a>
			</li>
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
		<!--breadcrumbs-->
		<div id="content-header">
			<div id="breadcrumb">
				<a href="homeAction_index" title="Go to Home" class="tip-bottom"><i
					class="icon-home"></i>主页</a>
			</div>
		</div>
		<!--End-breadcrumbs-->

		<!--Action boxes-->
		<div class="container-fluid">

			<!--End-Action boxes-->

			<!--Chart-box-->
			<div class="row-fluid">
				<div class="widget-box" style="width:1000px">
					<div class="widget-title bg_lg">
						<span class="icon"><i class="icon-signal"></i> </span>
						<h5>用户增长趋势</h5>
					</div>
					<div class="widget-content">
						<div class="row-fluid">
							<div class="span10"
								style="padding-bottom:20px;width:100%;border-bottom:1px solid #EBEBEB">
								<div class="chart"></div>
							</div>
							<hr />

							<div class="span9" style="margin-top:20px;">
								<ul class="site-stats">
									<li style="margin-left:-70px" class="bg_lh"><i
										class="icon-user"></i> <strong>${usercount }</strong> <small>用户总数</small>
									</li>
									<li class="bg_lh"><i class="icon-globe"></i> <strong>${todayusercount
											}</strong> <small>今日新增</small></li>

								</ul>
							</div>
						</div>

					</div>
				</div>
			</div>
			<!--End-Chart-box-->

		</div>
	</div>
	<input type="hidden" id="regcount" value="${regnums }" />
	<!--end-main-container-part-->
	<div id="abc"></div>
	<!--Footer-part-->

	<div class="row-fluid">
		<div id="footer" class="span12">
			2015 &copy; University Campus <a
				href="http://user.qzone.qq.com/492736173/">技术支持:Hyr</a>
		</div>
	</div>

	<!--end-Footer-part-->

	<!--end-Footer-part-->
	<script src="<%=basePath%>js/excanvas.min.js"></script>
	<script src="<%=basePath%>js/jquery.min.js"></script>
	<script src="<%=basePath%>js/jquery.ui.custom.js"></script>
	<script src="<%=basePath%>js/bootstrap.min.js"></script>
	<script src="<%=basePath%>js/jquery.flot.min.js"></script>
	<script src="<%=basePath%>js/jquery.flot.resize.min.js"></script>
	<script src="<%=basePath%>js/jquery.peity.min.js"></script>

	<script src="<%=basePath%>js/matrix.chat.js"></script>

	<script type="text/javascript">
		$(".noedit").prop("readonly", true);
	</script>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {

							var regcount = document.getElementById("regcount").value;
							// === Prepare peity charts === //
							var regcountList = new Array();
							regcountList = regcount;
							regcountList = regcountList.replace(/\s/g, "");
							// === Prepare the chart data ===/
							var sin = [], cos = [];
							var index = 0;
							var counts = new Array();

							for ( var i = 0; i < regcountList.length; i++) {
								if (!isNaN(regcountList[i])) {
									counts[index] = regcountList[i];
									index++;
								}
							}

							for ( var i = 0; i < counts.length; i++) {
								sin.push([ i + 1, counts[i] ]);
							}

							// === Make chart === //
							var plot = $.plot($(".chart"), [ {
								data : sin,
								label : "用户增长趋势",
								color : "#ee7951"
							} ], {
								series : {
									lines : {
										show : true
									},
									points : {
										show : true
									}
								},
								grid : {
									hoverable : true,
									clickable : true
								},
								yaxis : {
									min : 0,
									max : 50
								}
							});

							// === Point hover in chart === //
							var previousPoint = null;
							$(".chart")
									.bind(
											"plothover",
											function(event, pos, item) {

												if (item) {
													if (previousPoint != item.dataIndex) {
														previousPoint = item.dataIndex;

														$('#tooltip')
																.fadeOut(
																		200,
																		function() {
																			$(
																					this)
																					.remove();
																		});
														var x = item.datapoint[0]
																.toFixed(2), y = item.datapoint[1];

														maruti.flot_tooltip(
																item.pageX,
																item.pageY,
																"今日注册人数：" + y);
													}

												} else {
													$('#tooltip')
															.fadeOut(
																	2,
																	function() {
																		$(this)
																				.remove();
																	});
													previousPoint = null;
												}
											});

							// === Calendar === //    
							var date = new Date();
							var d = date.getDate();
							var m = date.getMonth();
							var y = date.getFullYear();

							$('.calendar').fullCalendar({
								header : {
									left : 'prev,next',
									center : 'title',
									right : 'month,basicWeek,basicDay'
								},
								editable : true,
								events : [ {
									title : 'All day event',
									start : new Date(y, m, 1)
								}, {
									title : 'Long event',
									start : new Date(y, m, 5),
									end : new Date(y, m, 8)
								}, {
									id : 999,
									title : 'Repeating event',
									start : new Date(y, m, 2, 16, 0),
									end : new Date(y, m, 3, 18, 0),
									allDay : false
								}, {
									id : 999,
									title : 'Repeating event',
									start : new Date(y, m, 9, 16, 0),
									end : new Date(y, m, 10, 18, 0),
									allDay : false
								}, {
									title : 'Lunch',
									start : new Date(y, m, 14, 12, 0),
									end : new Date(y, m, 15, 14, 0),
									allDay : false
								}, {
									title : 'Birthday PARTY',
									start : new Date(y, m, 18),
									end : new Date(y, m, 20),
									allDay : false
								}, {
									title : 'Click for Google',
									start : new Date(y, m, 27),
									end : new Date(y, m, 29),
									url : 'http://www.google.com'
								} ]
							});
						});

		maruti = {
			// === Peity charts === //
			peity : function() {
				$.fn.peity.defaults.line = {
					strokeWidth : 1,
					delimeter : ",",
					height : 24,
					max : null,
					min : 0,
					width : 50
				};
				$.fn.peity.defaults.bar = {
					delimeter : ",",
					height : 24,
					max : null,
					min : 0,
					width : 50
				};
				$(".peity_line_good span").peity("line", {
					colour : "#57a532",
					strokeColour : "#459D1C"
				});
				$(".peity_line_bad span").peity("line", {
					colour : "#FFC4C7",
					strokeColour : "#BA1E20"
				});
				$(".peity_line_neutral span").peity("line", {
					colour : "#CCCCCC",
					strokeColour : "#757575"
				});
				$(".peity_bar_good span").peity("bar", {
					colour : "#459D1C"
				});
				$(".peity_bar_bad span").peity("bar", {
					colour : "#BA1E20"
				});
				$(".peity_bar_neutral span").peity("bar", {
					colour : "#4fb9f0"
				});
			},

			// === Tooltip for flot charts === //
			flot_tooltip : function(x, y, contents) {

				$('<div id="tooltip">' + contents + '</div>').css({
					top : y + 5,
					left : x + 5
				}).appendTo("body").fadeIn(200);
			}
		}
	</script>
</body>
</html>