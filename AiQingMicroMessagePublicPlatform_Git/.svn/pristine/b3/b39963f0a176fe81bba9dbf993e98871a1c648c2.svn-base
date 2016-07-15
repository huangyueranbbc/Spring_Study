function uaredirect(f){try{if(document.getElementById("bdmark")!=null){return}
var b=false;if(arguments[1]){var e=window.location.host;var a=window.location.href;if(isSubdomain(arguments[1],e)==1){f=f+"/#m/"+a;b=true}else{if(isSubdomain(arguments[1],e)==2){f=f+"/#m/"+a;b=true}else{f=a;b=false}}}else{b=true}
if(b){var c=window.location.hash;if(!c.match("fromapp")){if((navigator.userAgent.match(/(iPhone|iPod|Android|ios|iPad)/i))){return true}}}}catch(d){}}
function isSubdomain(c,d){this.getdomain=function(f){var e=f.indexOf("://");if(e>0){var h=f.substr(e+3)}else{var h=f}
var g=/^www\./;if(g.test(h)){h=h.substr(4)}
return h};if(c==d){return 1}else{var c=this.getdomain(c);var b=this.getdomain(d);if(c==b){return 1}else{c=c.replace(".","\\.");var a=new RegExp("\\."+c+"$");if(b.match(a)){return 2}else{return 0}}}};
/*判断手机端*/
function setCookie(name,value){
	var Days = 1; //此 cookie 将被保存1天
    var exp = new Date(); 
    exp.setTime(exp.getTime() + Days*24*60*60*1000);
	document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
}
function getCookie(name){
  var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
  if(arr != null) return unescape(arr[2]); return null;
}
function delCookie(name){     //删除cookie
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval=getCookie(name);
    if(cval!=null) document.cookie= name + "="+cval+";expires="+exp.toGMTString();
}
function addhtml(){
    var m_pic =typeof('_m_pic')!=='undefined'?_m_pic: IMG_URL+"images/mobile_font.png";
    var m_title = typeof('_m_title')!=='undefined'?_m_title: "进入手机版";
    var m_url = typeof('_m_url')!=='undefined'?_m_url: WWW_URL+"gp/mobile.html";
    document.writeln("<div class=\"mobile\" id=\"MPhone\"><p><a href=\""+m_url+"\"><img src=\""+IMG_URL+"images/mobile_btn.png\" /></a><em class=\"tips\"><img src=\""+m_pic+"\" /></em><em class=\"close\" id=\"closed\"><img src=\""+IMG_URL+"images/mobile_close.png\" /></em></p></div>");
    $("#MPhone").parent().css({"display":"block"});
    var scH = (Math.floor(window.screen.height))/4+"px";
    $("#MPhone").css({"max-height":scH,"height":scH});
    $("#MPhone img").css({"width":"118%"});
}
if(uaredirect(WWW_URL)){
	if (document.cookie.indexOf("mphone") !== -1){
		var Nm = getCookie("mphone");
		if(Nm<3){
			addhtml();
			$("#closed").bind("click", function(){
				delCookie("mphone");
				Nm++;
				setCookie("mphone",Nm);
				$(this).parent().parent().hide();
			});
		}else{
			$("#MPhone").remove();
		}
	}else{
		setCookie("mphone","0");
		addhtml();
		var Nm = getCookie("mphone");
		$("#closed").bind("click", function(){
			delCookie("mphone");
			Nm++;
			setCookie("mphone",Nm);
			$(this).parent().parent().hide();
		});
	}
}
