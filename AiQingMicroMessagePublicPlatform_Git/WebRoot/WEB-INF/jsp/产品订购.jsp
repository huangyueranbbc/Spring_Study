<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path1 = request.getContextPath();
	String basePath1 = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path1 + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script async src="<%=basePath1%>艾清_订购_file/dp.csp.min.js"></script>
<script async src="<%=basePath1%>艾清_订购_file/feature.min.js"></script>
<script async src="<%=basePath1%>艾清_订购_file/wpo_alog_speed.js"></script>
<script async src="<%=basePath1%>艾清_订购_file/dp.min.js"></script>
<script src="<%=basePath1%>艾清_订购_file/hm.js"></script>
<script async src="<%=basePath1%>艾清_订购_file/element.min.js"></script>
<script async src="<%=basePath1%>艾清_订购_file/monkey.min.js"></script>
<script type="text/javascript" async
	src="<%=basePath1%>艾清_订购_file/rt.js"></script>
<script charset="utf-8" src="<%=basePath1%>艾清_订购_file/v.js"></script>
<script src="<%=basePath1%>艾清_订购_file/alog.min.js"></script>
<script src="<%=basePath1%>艾清_订购_file/hm.js"></script>
<script async src="<%=basePath1%>艾清_订购_file/alog.min(1).js"></script>
<script>
	var F = {};
	(function() {
		var b = {};
		F.context = function(p, r) {
			var q = arguments.length;
			if (q > 1) {
				b[p] = r
			} else {
				if (q == 1) {
					if (typeof p == "object") {
						for ( var o in p) {
							if (p.hasOwnProperty(o)) {
								b[o] = p[o]
							}
						}
					} else {
						return b[p];
					}
				}
			}
		};
	})();
</script>
<script>
	!F.context('staticController') && F.context('staticController', {
		run : function(f) {
			f && f.call(this);
		}, /**/
		fail : function() { /**/
		}
	});
</script>
<script src="<%=basePath1%>艾清_订购_file/staticLoader_f1971d5.js"></script>
<script>
	F.context('staticController').init
			&& F.context('staticController').init(!!'', !!'', !!'', null, '');
</script>
<title>QQ客服—黄石艾清生物科技（中国）有限公司</title>
<script>
	// pc和mobile端会稍有不同，必须严格按照该文档来部署
	void function(g, f, j, c, h, d, b) {
		g.alogObjectName = h, g[h] = g[h] || function() {
			(g[h].q = g[h].q || []).push(arguments)
		}, g[h].l = g[h].l || +new Date, d = f.createElement(j), d.async = !0,
				d.src = c, b = f.getElementsByTagName(j)[0], b.parentNode
						.insertBefore(d, b)
	}(window, document, "script",
			"http://img.baidu.com/hunter/alog/alog.min.js", "alog");
	void function() {
		function c() {
			return;
		}
		window.PDC = {
			mark : function(a, b) {
				alog("speed.set", a, b || +new Date);
				alog.fire && alog.fire("mark")
			},
			init : function(a) {
				alog("speed.set", "options", a)
			},
			view_start : c,
			tti : c,
			page_ready : c
		}
	}();
	void function(n) {
		var o = !1;
		n.onerror = function(n, e, t, c) {
			var i = !0;
			return !e && /^script error/i.test(n) && (o ? i = !1 : o = !0), i
					&& alog("exception.send", "exception", {
						msg : n,
						js : e,
						ln : t,
						col : c
					}), !1
		}, alog("exception.on", "catch", function(n) {
			alog("exception.send", "exception", {
				msg : n.msg,
				js : n.path,
				ln : n.ln,
				method : n.method,
				flag : "catch"
			})
		})
	}(window);
</script>
<script>
	var _hmt = _hmt || [];
	F
			.context(
					'tongji_hm',
					{
						init : (function() {
							return function(rtTag) {
								rtTag && _hmt.push([ '_trackRTEvent', rtTag ]);
								var hm = document.createElement('script');
								hm.src = '//hm.baidu.com/hm.js?a028c07bf31ffce4b2d21dd85b0b8907';
								var s = document.getElementsByTagName('script')[0];
								s.parentNode.insertBefore(hm, s);
							}
						})()
					});
	F.context('tongji_hm').init();
</script>

<script>
	void function(e, t, n, a, o, i, m) {
		e.alogObjectName = o, e[o] = e[o] || function() {
			(e[o].q = e[o].q || []).push(arguments)
		}, e[o].l = e[o].l || +new Date, i = t.createElement(n), i.asyn = 1,
				i.src = a, m = t.getElementsByTagName(n)[0], m.parentNode
						.insertBefore(i, m)
	}(window, document, "script", "http://img.baidu.com/hunter/alog.min.js",
			"alog");
</script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath1%>艾清_客服_file/style_i.css"><%@ include
		file="/WEB-INF/jsp/public/common.jspf"%>
	<div class="sub_img"></div>

	</div>
	</div>
	</div>

	<!-- *******************  end header   *********************** -->
	<div class="pbd pbd-inner pbd-jkrs">
		<div class="main">
			<iframe frameborder="0" style="display: none;"></iframe>
			<div id="bdshare_s" style="display: block;">
				<div id="bdshare_l" style="display: none;">
					<div id="bdshare_l_c"></div>
				</div>
			</div>

			<script>
				F
						.context({
							'channel' : 'zhifang_detail||', // 
							'channel_content' : '', // 
							'da_page' : 'item_detail', // 
							'nuomi_base' : 'http://www.nuomi.com',
							'logout_nuomi' : '/pclogin/main/logout',
							'baid_uss_url' : 'http://uid.nuomi.baidu.com/getbduss',
							'logout_baidu' : 'https://passport.baidu.com/?logout',
							'xll' : '', // 
							'label_sort_js' : '', // 
							'loginTest' : '', // 
							'passport_base' : 'http://passport.baidu.com',
							'nuomi_old_base' : 'http://login.nuomi.com',
							'login_idc' : '' || 'sh',
							'passport_reg' : 'http://passport.baidu.com/v2/?reg&tpl=nuomi&color=pink',
							'sample_hit' : '139' // 
						});
			</script>

<link rel="stylesheet" type="text/css" href="<%=basePath1%>艾清_订购_file/global_7a563eb.css"><link rel="stylesheet" type="text/css" href="<%=basePath1%>艾清_订购_file/common_846370e.css"><link rel="stylesheet" type="text/css" href="<%=basePath1%>艾清_订购_file/header_580acc6.css"><link rel="stylesheet" type="text/css" href="<%=basePath1%>艾清_订购_file/detail_old_3320f03.css"><link rel="stylesheet" type="text/css" href="<%=basePath1%>艾清_订购_file/detail_8eedd7b.css"><link rel="stylesheet" type="text/css" href="<%=basePath1%>艾清_订购_file/detail_2dbdc03.css"><script type="text/javascript" src="<%=basePath1%>艾清_订购_file/template_ac009f5.js"></script><script src="<%=basePath1%>艾清_订购_file/logger.js"></script><link href="<%=basePath1%>艾清_订购_file/bdsstyle.css" rel="stylesheet" type="text/css">


			<!--[if IE 6]>
<div id="kie-bar" class="kie-bar">
目前您正在使用ie6浏览器，该浏览器已经过时了，为了更加安全和方便地进行团购，推荐您使用以下浏览器：<a href="http://www.microsoft.com/china/windows/IE/upgrade/index.aspx" class="kie-setup-IE8"  target="_blank" title="免费升级至IE8浏览器">免费升级</a>或下载使用<a href="http://browser.baidu.com/" class="kie-setup-baidu" target="_blank" title="百度浏览器">百度浏览器</a>，体验极速浏览体验！</div>
<style>
        .kie-bar {
            height: 24px;
            line-height: 1.8;
            font-weight:normal;
            text-align: center;
            border-bottom:1px solid #fce4b5;
            background-color:#FFFF9B;
            color:#e27839;
            position: relative;
            font-size: 14px;
            text-shadow:  0 0  1px #efefef;
            padding: 5px 0;
        }
        .kie-bar a {
            color:#08c;
            text-decoration: none;
        }
    </style>
<![endif]-->
  <div class="sub_img">
        
        
        </div>
   
</div>    </div>
</div>
        
<!-- *******************  end header   *********************** -->
<div class="pbd pbd-inner pbd-jkrs">
    <div class="main">
    <iframe frameborder="0" style="display: none;"></iframe>
<div id="bdshare_s" style="display: block;">
<div id="bdshare_l" style="display: none;">
<div id="bdshare_l_c">
</div></div></div>

<script>
    F.context({
        'channel': 'zhifang_detail||', // 
        'channel_content': '', // 
        'da_page': 'item_detail', // 
        'nuomi_base': 'http://www.nuomi.com',
        'logout_nuomi': '/pclogin/main/logout',
        'baid_uss_url': 'http://uid.nuomi.baidu.com/getbduss',
        'logout_baidu': 'https://passport.baidu.com/?logout',
        'xll': '', // 
        'label_sort_js': '', // 
        'loginTest': '', // 
        'passport_base': 'http://passport.baidu.com',
        'nuomi_old_base': 'http://login.nuomi.com',
        'login_idc':'' || 'sh',
        'passport_reg': 'http://passport.baidu.com/v2/?reg&tpl=nuomi&color=pink',
        'sample_hit': '139' // 
    });
</script>


<!--[if IE 6]>
<div id="kie-bar" class="kie-bar">
目前您正在使用ie6浏览器，该浏览器已经过时了，为了更加安全和方便地进行团购，百度糯米推荐您使用以下浏览器：<a href="http://www.microsoft.com/china/windows/IE/upgrade/index.aspx" class="kie-setup-IE8"  target="_blank" title="免费升级至IE8浏览器">免费升级</a>或下载使用<a href="http://browser.baidu.com/" class="kie-setup-baidu" target="_blank" title="百度浏览器">百度浏览器</a>，体验极速浏览体验！</div>
<style>
        .kie-bar {
            height: 24px;
            line-height: 1.8;
            font-weight:normal;
            text-align: center;
            border-bottom:1px solid #fce4b5;
            background-color:#FFFF9B;
            color:#e27839;
            position: relative;
            font-size: 14px;
            text-shadow:  0 0  1px #efefef;
            padding: 5px 0;
        }
        .kie-bar a {
            color:#08c;
            text-decoration: none;
        }
    </style>
<![endif]-->


<div class="p-detail">
<div data-huodong="共有多少人团购"></div>
<div class="p-bread-crumb" mon="deal_id=2972980" alog-alias="bainuo-detail-bread-crumb" alog-group="bainuo-detail-bread-crumb">
<div class="w-bread-crumb" mon="area=breadCrumbs">
</div></div>
<div class="static-hook-real static-hook-id-6">
</div>
<div class="p-item-info" mon="deal_id=2972980">
<div class="w-item-info clearfix">
<h2>艾清空气清新微乳剂</h2>
<div class="item-title">
<span class="text-main">仅售8.5元</span>
</div>
<div class="ii-images clearfix static-hook-real static-hook-id-7">
<div class="w-item-images">
<div id="j-images-board" class="images-board">
<div class="item-status clearfix ">
<div class="ico-status ico-freeappointment"></div>
</div>
<img src="<%=basePath1%>images/cp.png" class="item-img-large">
</div>
<ul id="j-images-list" class="images-list clearfix">
<li class="images images-last">
<img src="<%=basePath1%>images/cp.png">
</li>
</ul>
</div>
</div>
<div class="ii-intro">
<div class="w-item-intro"><div class="promotion-area static-hook-real static-hook-id-8"></div><div class="price-area-wrap clearfix static-hook-real static-hook-id-9"><div class="price-area clearfix has-promotion-icon">
  <div class="match-price-area"><span class="unit">¥</span><span class="real-price">8.5</span></div><div class="current-price-area"><div class="price">¥10</div>
  <div class="name">订购价</div></div></div></div><div class="static-hook-real static-hook-id-10"></div><ul class="ugc-strategy-area clearfix  static-hook-real static-hook-id-11" mon="area=promoteBuy&amp;element_type=function" alog-alias="bainuo-detail-item-intro-more" alog-group="bainuo-detail-item-intro-more"><li class="item-bought"><div class="sl-wrap"><div class="sl-wrap-cnt"><div class="item-bought-num"><span class="intro-strong">3</span>人已团购</div></div></div></li><li id="j-ugc-grade" class="ugc-grade "><div class="sl-wrap"><div class="sl-wrap-cnt"><div class="no-comment">暂无评论<div class="no-comment-reason"><span class="ico-mark-up"></span><p>暂无用户评价</p></div></div></div></div></li><li class="item-strategy"><div class="sl-wrap"><div class="sl-wrap-cnt"><s:a action="homeAction_gszz" target="_blank" class="good-shopper">商家资质认证</s:a></div></div></li></ul><div class="buy-panel-wrap app-share"><div class="app-share-erweima-wrap"></div><div class="buy-panel"><div class="validdate-buycount-area static-hook-real static-hook-id-12"><div class="item-buycount-row j-item-buycount-row clearfix app-share" data-stock="10000" data-personmax="50" data-min="1" data-max="50"><div class="name">数量</div><div class="buycount-ctrl">
 
 
 <!------------------------------------- 表单提交 ------------------------------------->   
 <s:form action="orderAction_qrdd" method="get">
  <a href="javascript:;" class="j-ctrl ctrl minus disabled"><span class="horizontal"></span></a>
  <s:textfield value="1" name="sum" maxlength="50"></s:textfield>
  <a href="javascript:;" class="ctrl j-ctrl plus "><span class="horizontal"></span><span class="vertical"></span></a>
</s:form>
 <!------------------------------------- 表单提交 ------------------------------------->   
 
 
  </div><div class="text-wrap"><span class="err-wrap j-err-wrap"></span></div></div></div><div class="item-buy-area clearfix"><div style="float:left" class="static-hook-real static-hook-id-13" id="buy-button-wrap">
  <a href="javascript:gotoPage()"  class="btn-buy btn-buy-l ">立即抢购</a>
  </div></div></div></div><script type="text/template" data-role="tips-tags"><div class="tips-tags"><div class="tips-tags-mask"></div><i></i><div class="tips-tags-main"><span class="tips-tags-desc">${desc}</span><!--if:${link}--><a href="${link}" target="_blank">查看详情</a><!--/if--></div></div></script></div>
</div>
</div></div>
	<!--goto page -->
	<script type="text/javascript">
		function gotoPage() {
			document.forms[0].submit();
		};
	</script>



<script src="<%=basePath1%>艾清_订购_file/jquery-1.10.2.min_f2fb5194.js"></script>
<script type="text/javascript" src="<%=basePath1%>艾清_订购_file/common_sync_js_0_b029562.js"></script>

<script type="text/javascript" src="<%=basePath1%>艾清_订购_file/shop_branch_08f7595.js"></script>
<script type="text/javascript" src="<%=basePath1%>艾清_订购_file/detail_cd2854f.js"></script>

	
       </div></div>
  

</BODY></HTML>