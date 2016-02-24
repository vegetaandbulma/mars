define(["../lib", "const"], function(LIB, CONST) {
	var _login_window = "_login_ui";
	var _login_button = "login_btn";
	var MODEL = {
		init: function() {
			if ($("#"+_login_window).length > 0) {
				console.log("has windows ui !");
			} else {
				$(document.body).append("<div id='_login_ui' title='' modal='true' collapsible='false' minimizable='false' maximizable='false'></div>");
				console.log("add windows ui !");
			}
			this.base();
			this.verify();
		},
		verify:function(){
			t = this;
			setInterval(function() {
				//clearInterval(wait);
				console.log("auth verify");t.loginWindow("登陆",300,250);
			}, 60 * 1000);
		},
		login:function(){
			var param = {"random":LIB.random()};
			param = $.extend(param,{"username":"11"});
			param = $.extend(param,{"password":"22"});
			$.ajax({
				type: "POST",
				url: CONST.ROUTE.LOGIN_ACTION,
				data: param,
				async: false,
				dataType: "json",
				success: function(data) {
					_menus = data;
					console.log("URI  [" + CONST.ROUTE.LOGIN_ACTION + " ]" + data);
					$("#"+_login_window).window('close');
					return data;
				}
			});
		},
		windowLoad:function(){
			t = this;
			$("#login_btn").click(function(){console.log("12weqwewqwqe");
				t.login();
			});
		},
		loginWindow: function(title, width, height) {
			var url = CONST.ROUTE.LOGIN_VIEW;
			if (url.indexOf("?") <= 0) {
				url = url + "?q=1";
			}
			if(width <=0 || height <= 0){
				width=450;height=400;
			}
			t = this;
			$("#"+_login_window).window({
				title: title,
				width: width,
				height: height,
				modal: true,
				resizable: false,
				//	href: ,
				shadow: true,
				//closed: false,
				closable:false,
				onLoad:function(){
					t.windowLoad();
				}
			});
			$("#"+_login_window).window('refresh', url);
			$("#"+_login_window).window('center');
		},//ajax 会话拦截
		base:function(){
			t = this;
			$.ajaxSetup({
				contentType: "application/x-www-form-urlencoded;charset=utf-8",
				cache: false,
				complete: function(XMLHttpRequest, textStatus) {
					try {
						var data = $.parseJSON(XMLHttpRequest.responseText);
						console.log("ajax filter data:[" + data + "    " + LIB.isObject(data) + "]");
						if(LIB.isObject(data) && data.status === CONST.STATUS.SESSION_TIME_OUT){
							t.loginWindow("登陆",300,250);
						}
					} catch(e) {};
					
				}
			});
		},
		lockScreen:function(){
			this.loginWindow("登陆",300,250);
		}
	};
	MODEL.init();
	return MODEL;
});