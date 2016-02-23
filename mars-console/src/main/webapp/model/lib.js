requirejs.config({
	"baseUrl": "lib",
	"urlArgs": 'ver=1111',
	"paths": {
		"jquery": "jquery/jquery-2.0.3.min",
		"easyui": "jquery.easy.ui/jquery.easyui.min",
		"easyui-lang": "jquery.easy.ui/locale/easyui-lang-zh_CN"
	},
	shim: {
		"easyui-lang": ['jquery','easyui'],
		"easyui": ['jquery']
	}
});

define(["jquery", "easyui", "easyui-lang"], function() {

	var LIB = {
		init: function() {
			
		},
		random: function() {
			var time = new Date().getTime();
			var randomparam = 1000 * Math.random() + time;
			return randomparam;
		},
		isUndefined: function(object) {
			if (typeof(object) == "undefined") {
				return true;
			} else {
				return false;
			}
		},
		isNull: function(object) {
			if (!object && typeof(object) != "undefined" && object != 0) {
				return true;
			} else {
				return false;
			}
		},
		isObject: function(object) {
			if (typeof object === "object" && !(object instanceof Array)) {
				var hasProp = false;
				for (var prop in object) {
					hasProp = true;
					break;
				}
				return hasProp;
			} else {
				return false;
			}
		},
		isArray: function(object) {
			if (typeof object === "object" && (object instanceof Array)) {
				return true;
			} else {
				return false;
			}
		}
	};
	console.log("init lib ok [lib.js]");
	LIB.init();
	return LIB;
});