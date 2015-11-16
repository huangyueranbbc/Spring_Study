<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0086)https://ocs.infinitus.com.cn/robot/chatClientNew/chatbox.jsp -->
<HTML>
<HEAD>
<TITLE>机器人客服</TITLE>
<META content=IE=8 http-equiv=X-UA-Compatible>
<META content="text/html; charset=UTF-8" http-equiv=Content-Type>
<LINK rel=stylesheet type=text/css href="机器人客服_files/new_main.css">
<LINK rel=stylesheet type=text/css href="机器人客服_files/new_main2.css">
<LINK title=newSkin rel=stylesheet type=text/css
	href="机器人客服_files/skin.css">
<SCRIPT type=text/javascript src="机器人客服_files/jquery.js"></SCRIPT>
<!--[if IE 6]>
        <script src="../chatClient/chat/js/png.js"></script>
    <![endif]-->
<SCRIPT type=text/javascript>
	if (!Live800Robot)
		var Live800Robot = {};
	Live800Robot.param = {
		"language" : "0",
		"logUrl" : "<%=basePath%>images/logo.png",
		"chatTitle" : "机器人客服",
		"skinType" : "blue",
		"uniqueKey" : "D3D7A4D499EBE4C2D3B8CF1A3F7F9E20_1437277449324_8932",
		"enterurl" : "",
		"companyId" : "8932",
		"info" : "",
		"contact" : "",
		"chatfrom" : "web",
		"selfdim" : "",
		"selfQueryParam" : "companyId=8932&hashCode=59bf08ab97e84e24fdedb5b987f2b097&timestamp=1437277449325&info=null&contact=null",
		"udButtonJson" : "",
		"udButtonOpen" : "false"
	};
</SCRIPT>

<SCRIPT type=text/javascript src="机器人客服_files/loadTopBanner.js"></SCRIPT>

<SCRIPT type=text/javascript src="机器人客服_files/robot.js"></SCRIPT>

<SCRIPT type=text/javascript src="机器人客服_files/chatbox.js"></SCRIPT>

<META name=GENERATOR content="MSHTML 9.00.8112.16672">
</HEAD>
<BODY>
	<DIV id=chatbox class=content>
		<DIV class=content_left_center></DIV>
		<DIV class=content_right_center></DIV>
		<DIV class=content_top>
			<DIV class=content_top_left></DIV>
			<DIV class=content_top_right></DIV>
		</DIV>
		<DIV id=top class=top>
			<DIV id=logo></DIV>
			<DIV class=lefttop>
				<DIV class=lefttop_top1></DIV>
				<!--top1-->
				<DIV id=functionContainer class=lefttop_top2></DIV>
				<!--top2-->
				<!-- 大功能 -->
			</DIV>
			<!--lefttop-->
			<DIV class=righttop>
				<DIV id=exitChat></DIV>
				<SPAN id=rbg></SPAN>
			</DIV>
			<!--righttop-->
		</DIV>
		<DIV id=center class=center>
			<!-- center -->
			<DIV id=main class=main>
				<DIV id=banner></DIV>
				<DIV class=clo></DIV>
			</DIV>
			<!--main-->
			<DIV id=side class=side>
				<DIV class=center_left1_container>
					<DIV id=history></DIV>
					<DIV style="DISPLAY: none" id=emotionsBox></DIV>
					<DIV style="DISPLAY: none" id=sysTip></DIV>
				</DIV>
			</DIV>
			<!--side-->
			<DIV id=bottom class=bottom>
				<DIV class=center_left>
					<DIV class=center_left2>
						<DIV id=tool_wrap></DIV>
					</DIV>
					<DIV class=center_left3>
						<DIV id=inputarea>
							<TEXTAREA id=inputbox>                        </TEXTAREA>
						</DIV>
						<DIV>
							<DIV style="MARGIN-TOP: -10px" id=subwrap>
								<DIV
									style="BACKGROUND-IMAGE: url(https://ocs.infinitus.com.cn/robot/chatClientNew/refactor/style/theme/blue/images/send0.jpg)"
									id=enter></DIV>
							</DIV>
							<DIV class=clo></DIV>
						</DIV>
					</DIV>
				</DIV>
			</DIV>
		</DIV>
		<!--bottom-->
	</DIV>
	<!-- end center -->
	<DIV id=content_bottom class=content_bottom>
		<DIV class=content_bottom_left></DIV>
		<DIV class=content_bottom_right></DIV>
	</DIV>
	<DIV></DIV>
	<BGSOUND id=sound loop=1 src="">
	<IFRAME style="DISPLAY: none" height=0
		src="机器人客服_files/closevisitor.htm" width=0> </IFRAME>
	<DIV id=scorInfo>
		<SPAN id=headerBox>&nbsp;</SPAN> <SPAN id=headerBoxTime></SPAN>
	</DIV>
	<SPAN id=footerBox>&nbsp;</SPAN>
	<TEXTAREA id=editor_temp_text>    </TEXTAREA>
</BODY>
</HTML>
