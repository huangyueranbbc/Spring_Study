<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><style type="text/css" id="12934951000"></style><style type="text/css" id="12934952000"></style><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>University Campus</title>
<style type="text/css">
html,body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,code,form,fieldset,legend,input,textarea,p,blockquote,th,td{margin:0;padding:0;font-family:Helvetica, Tahoma, Arial, "Hiragino Sans GB", "Hiragino Sans GB W3", "Microsoft YaHei", STXihei, STHeiti, Heiti, SimSun, sans-serif; font-size:100%;}
html,body{color:#333}
body{background:#fff; max-width: 1920px;}
ul,ol,li{ list-style:none;}
a:link, a:visited{ color:#333; text-decoration:none;}
a:hover{ color:#666;}
img{ border:none;}
em{ font-style:normal;}
h1,h2,h3,h4,h5{ font-weight:normal;}
.clearfloat:after{ content:'.';display:block;overflow:hidden;visibility:hidden;font-size:0;line-height:0;width:0;height:0;}
.clearfloat{zoom:1;}
/* top */
.w980{ width: 980px; margin: 0 auto;}
.topbar{ position: absolute; left: 0; top: 0; width:100%; height:150px; z-index: 900;}
.toppic{ max-width:1176px; min-width:880px; width:80%; height:75px; margin:0 auto;}
.toppic a:link, .toppic a:visited{ color: #fff;}
.topicfixed{ position: fixed; left: 0; top: 0; background: #fff; border-bottom: 1px solid #f1f1f1;}
.topicfixed a:link, .topicfixed a:visited{ color: #333;}
.topside{ float:left; width:59%;}
.topNav{ float:left; width:450px; padding-left: 18px;}
.topNav li{ float:left;}
.topNav li a{ float: left; padding: 0 20px; line-height:75px; font-size:1.125em;}
.topNav li a:hover{ background: #12b7f5;}
.topNav li.current a{ background: #12b7f5;}
.topicfixed .topNav li a.barzc{ display: inline;}
.topicfixed .topNav li a:hover{ background: none; color: #12b7f5;}
.logoLink{ float:left; display:block; width:196px; height:0px; overflow:hidden; padding-top:76px; font-size:0; background:transparent url(img/ucImg/logoUC.png) no-repeat left 15px;}
.topTool{ float:right; width:280px; font-size:0.875em;}
.topTool ul{ width: 100%; height: 40px; padding-top: 6px;}
.topTool li{ float: right; margin-left: 30px; position: relative; line-height: 40px;}

.topTool .login{ height:43px; line-height:43px;}
.topTool .login span{ padding:0 18px; color:#cecece;}
.topTool a:hover{ color:#12b7f5;}
.flashData{ clear: both; width: 100%; line-height:17px; text-align: right; letter-spacing: 0.025em;}
.flashData a:hover{ text-decoration:underline;}



/* banner */
.crossbanenr{ position: relative; width: 100%; height: 780px;top: 0;
    background: url(img/ucImg/background-s.png) no-repeat center bottom;
    background:url(img/ucImg/background-b.png) no-repeat center bottom\9 ;background-size: cover}
a.downbtn{ position: absolute; left: 50%; bottom: 300px;bottom: 340px\9;width: 386px; height: 0; overflow: hidden; margin-left:-193px; padding-top: 76px; background: transparent url(img/ucImg/downbtn.png) no-repeat 0 0; text-align: center; line-height: 76; font-size: 30px; letter-spacing: 15px;}
a.downbtn:hover{ background-position: 0 -75px;}
.kouhao{ font-size: 80px; font-weight:-50;  color: white; font-family: "微软雅黑"; position:relative; top:50px;text-align: center; }
    
</style>


<body>
<!--S header-->
<div id="topbar" class="topbar">
    <div class="toppic">
        <div class="topside">
         <strong class="logoLink">University Campus</strong>
        </div>
        <div class="topTool">
            <ul>
                <li id="loginInfo">
                    <s:a  action="adminAction_loginUI">后台登录</s:a>
                </li>
            </ul>
        </div>
    </div>
</div>
<!--E header-->

<!--S banner-->
<div class="crossbanenr" style="height: 650px;">
    <!--<div class="crosstitle"></div>-->
    <h1 class="kouhao">UC<p></p>有 你 <span style="color:#29B905;">更</span> <span style="color: #FFCF2D;">精</span> <span style="color:#39D1E7;">彩</span></h1>
    <s:a action="downloadOrUpload_download" cssClass="downbtn" >立即下载</s:a>
</div>

<!--E banner-->

</body></html>
</html>
