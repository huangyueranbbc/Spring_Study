if(!Live800Robot){ var Live800Robot = {};}
if(!Live800Robot.etc) {Live800Robot.etc = function(){};}
if(!Live800Robot.load) {Live800Robot.load = function(){};}
if(!Live800Robot.param) {Live800Robot.param = function(){};}
if(!Live800Robot.lan) {Live800Robot.lan = function(){};}
if(!Live800Robot.ext){Live800Robot.ext = function(){};}
/**
 * 提供一些实用方法
 */
if(!Live800Robot.util) {Live800Robot.util = function(){};}

/**
 * 提供配置信息
 */
Live800Robot.etc = {
    CHATDIV: "history",                                     //显示聊天内容层ID	
    HEADERBOX: "headerBox",                                 //显示标题栏
    INPUT_FIELD: "inputbox",                                //输入框ID
    SELECT: "select",                                        //快捷键选择
    txtSize : 200,              							 //提交的问题的最大长度
    ROBOT_BASE_URL: live800_robot_server_url,       //机器人服务器地址+域名
    isNeedJquery: true,
    language:(typeof LIM != "undefined" && typeof LIM.config.language != "undefined") ? LIM.config.language : ((!Live800Robot.param.language)?0:Live800Robot.param.language)
};

Live800Robot.load = {
	isLoadXML:false,
	isLoadJquery:false,
	isEnd:false
	
};

Live800Robot.load.loadRobotmain_js = function() {
	Live800Robot.util.loadScript(Live800Robot.etc.ROBOT_BASE_URL + "chatClient/chat/js/robotmain.js",  Live800Robot.load.initInfo);
};

//初始化配置
Live800Robot.load.initConstant = function(){
	Live800Robot.ext.username = Live800Robot.lan.localRes["youspeak"];
	Live800Robot.config.windowTitle = Live800Robot.lan.localRes["windowTitle"];
	Live800Robot.config.welcome = Live800Robot.lan.localRes["welcome"];
	Live800Robot.config.robotWaitWord = Live800Robot.lan.localRes["robotWaitWord"];
	Live800Robot.config.missing = Live800Robot.lan.localRes["missing"];
	Live800Robot.config.defaultValue = Live800Robot.lan.localRes["defaultValue"];
	Live800Robot.config.robotName = Live800Robot.lan.localRes["robotName"];
	Live800Robot.load.isEnd = true;
};

Live800Robot.lan.loadInitInfo = function() {
	
	Live800Robot.util.loadScript(
			Live800Robot.etc.ROBOT_BASE_URL + "chatClient/localzition/json/" + Live800Robot.etc.language + ".js",  
			function() {
				Live800Robot.load.initConstant();
				Live800Robot.load.isLoadXML = true;
			});
};

Live800Robot.util.loadScript = function(url, callback) {
	
	var S = document.createElement("script");
	
	S.async = "async";
	
	S.onload = S.onreadystatechange = function() {
		
		if(!this.readyState || this.readyState === "loaded" || this.readyState === "complete") {
			
			if(callback && typeof callback === "function") {
				callback();
			}
			
			 S.onload = S.onreadystatechange = null;

             if (S.parentNode) {

                 S.parentNode.removeChild(S);

             }
             
             S = null;
			
		}
		
	};
	
	S.setAttribute("type","text/javascript");
	S.setAttribute("src", url);
	document.getElementsByTagName("head")[0].appendChild(S);
};

Live800Robot.load.loadRobotmain_js();
