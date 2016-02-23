require(["const","main"], function(CONST ,MAIN) {
	var MODEL =
	{
		init:function(){
			$(".easyui-datagrid").datagrid();
			$("#btn_open").linkbutton();
			$("#btn_open").click(function(){
				MAIN.openWindow("213123","form.html",0,1000);
			});
		}
	};
	MODEL.init();
	return MODEL;
});