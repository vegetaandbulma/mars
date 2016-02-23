define(["../lib", "const"], function(lib, CONST) {
	var MODEL = {
		init: function() {
			if ($("#_login_ui").length > 0) {
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
				console.log("auth verify");t.login("Login","form.html",300,250);
			}, 60 * 1000);
		},
		login: function(title, url, width, height) {
			if (url.indexOf("?") <= 0) {
				url = url + "?q=1";
			}
			if(width <=0 || height <= 0){
				width=450;height=400;
			}
			$("#_login_ui").window({
				title: title,
				width: width,
				height: height,
				modal: true,
				resizable: false,
				//	href: ,
				shadow: true,
				//closed: false,
				closable:false
			});
			$("#_login_ui").window('refresh', url);
			$("#_login_ui").window('center');
		},
		base:function(){
			t = this;
			$.ajaxSetup({
				contentType: "application/x-www-form-urlencoded;charset=utf-8",
				cache: false,
				complete: function(XMLHttpRequest, textStatus) {
					try {
						var data = $.parseJSON(XMLHttpRequest.responseText);
						console.log("ajax filter data:[" + data + "    " + lib.isObject(data) + "]");
						if(lib.isObject(data) && data.status === CONST.SUCCESS){
							t.login("Login","form.html",300,250);
						}
					} catch(e) {};
					
				}
			});
		},
		lockScreen:function(){
			
		}
	};
	MODEL.init();
	return MODEL;
});