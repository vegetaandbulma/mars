define(["../lib", "const" ,"auth"], function(LIB, CONST , AUTH) {
	var _window = "appWindow";
	var tabs_id = "33213123";
	var _menus = {
		"rows": [{
			"menuid": "1",
			"icon": "nav-config",
			"title": "系统管理",
			"menus": [{
				"menuid": "11",
				"title": "用户管理",
				"icon": "icon-sys",
				"url": "user/index.shtml"
			}]
		}, {
			"menuid": "2",
			"icon": "nav-config",
			"title": "内容管理",
			"menus": [{
				"menuid": "22",
				"title": "成员管理",
				"icon": "icon-sys",
				"url": "member/index.shtml"
			}, {
				"menuid": "23",
				"title": "评论管理",
				"icon": "icon-sys",
				"url": "comment/index.shtml"
			}, {
				"menuid": "24",
				"title": "分类管理",
				"icon": "icon-sys",
				"url": "category/index.shtml"
			}, {
				"menuid": "25",
				"title": "标签管理",
				"icon": "icon-sys",
				"url": "tag/index.shtml"
			}, {
				"menuid": "26",
				"title": "内容管理",
				"icon": "icon-sys",
				"url": "paper/index.shtml"
			}, {
				"menuid": "27",
				"title": "FTP",
				"icon": "icon-sys",
				"url": "ftp/index.shtml"
			}]
		}]
	};
	
	var MODEL = {
		init: function() {
			if ($("#" + _window).length > 0) {
				console.log("has windows ui !");
			} else {
				$(document.body).append("<div id='" + _window + "' title='' modal='true' collapsible='false' minimizable='false' maximizable='false'></div>");
				console.log("add windows ui !");
			}
			$(".easyui-layout").layout();
			this.getMenu();
			this.initMenu();
			$(".easyui-tabs").tabs();
			console.log("init system ok. ");
		},
		getMenu: function() {
			var param = {"random":LIB.random()};
			$.ajax({
				type: "POST",
				url: CONST.MENU_ACTION,
				data: param,
				async: false,
				dataType: "json",
				success: function(data) {
					_menus = data;
					console.log("URI  [" + CONST.MENU_ACTION + " ]" + data);
					return data;
				}
			});
		},
		addAppTab: function(title, url) {
			var exiBool = $("#appTabs").tabs("exists", title);
			console.log(url + "  " + title);
			if (url && url.indexOf("?") <= 0) {
				url = url + "?q=1";
			}
			if (!exiBool) {
				$("#appTabs").tabs("add", {
					title: title,
					//content: "<iframe frameborder=\"0\" scrolling=\"no\"  src=\"" + url + "\" style=\"width:100%;height:100%;\"></iframe>",
					href: url,
					closable: true
				});
			} else {
				$("#appTabs").tabs("select", title);
			}
		},
		//初始化左侧
		initMenu: function() {
			$("#appNav").accordion({
				animate: false
			});
			$.each(_menus.rows, function(i, n) {
				var menulist = "";
				menulist += "<ul>";
				$.each(n.menus, function(j, o) {
					menulist += "<li><div><a ref=\"" + o.menuid + "\" url=\"" + o.url + "\" href=\"#\" ><span class=\"icon " + o.icon + "\" >&nbsp;</span><span class=\"nav\">" + o.title + "</span></a></div></li> ";
				});
				menulist += "</ul>";
				$("#appNav").accordion("add", {
					title: n.title,
					content: menulist,
					iconCls: "icon " + n.icon
				});
			});
			var that = this;
			$(".easyui-accordion li a").click(function() {
				var tabTitle = $(this).children(".nav").text();
				var url = $(this).attr("url");
				var menuid = $(this).attr("ref");
				//var icon = getIcon(menuid, icon);
				that.addAppTab(tabTitle, url);
				$(".easyui-accordion li div").removeClass("selected");
				$(this).parent().addClass("selected");
			}).hover(function() {
				$(this).parent().addClass("hover");
			}, function() {
				$(this).parent().removeClass("hover");
			});
			//选中第一个
			var panels = $("#appNav").accordion("panels");
			var t = panels[0].panel("options").title;
			$("#appNav").accordion("select", t);
		},
		openWindow: function(title, url, width, height) {
			if (url.indexOf("?") <= 0) {
				url = url + "?q=1";
			}
			if(width <=0 || height <= 0){
				width=450;height=400;
			}
			$("#appWindow").window({
				title: title,
				width: width,
				height: height,
				modal: true,
				resizable: true,
				//	href: ,
				shadow: true,
				closed: false,
				//	closable:false,
				height: height
			});
			$("#appWindow").window('refresh', url);
		}
	};
	MODEL.init();
	return MODEL;
});
