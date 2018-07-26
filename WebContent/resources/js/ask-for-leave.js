$(function() {
	leave.initial();
	
});

var context = util.basePath();

var leave = {

	initial : function initial() {
		this.bindSubmitForm();
		this.bindChangeSearchParam(); //分页
		
	},
	
	bindChangeSearchParam : function bindChangeSearchParam() {
		// 分页组件按钮
		$(".pagination li a").click(function() {
			var pageId = $(this).data("id");
			if (pageId == null || pageId == "")
				return false;
			var genrateParamOld = leave.genrateParamOld();
			genrateParamOld.page = pageId;
			leave.redirectUrl(genrateParamOld);

		});
		// 搜索按钮点击
		$("#btn-leave-search").click(function() {
			var condition = leave.genrateParamOld();
			leave.redirectUrl(condition);
		})

	},
	
	genrateParamOld : function genrateParamOld() {
		var id=$("#id").val();
		if(id==""||id==null)
			id=0;
		var start = $("#start").val();
		if (start == "" || start == null)
			start = 0;
		var end = $("#end").val();
		if (end == 0 || end == null)
			end = 0;
		var page = 1;
		var data = new Object();
		data.page = page;
		data.id = id;
		data.start = start;
		data.end = end;
		return data;
	},
	
	redirectUrl : function(newparam) {
		var paramurl = newparam.page;
		paramurl = paramurl + "-" + newparam.id;
		paramurl = paramurl + "-" + newparam.start;
		paramurl = paramurl + "-" + newparam.end;
		paramurl = paramurl + ".html";
		document.location.href = document.getElementsByTagName('base')[0].href
				+ 'student/ask-for-leave/filter-' + paramurl;
	},
	
	bindSubmitForm : function bindSubmitForm() { //提交请假申请
		$("#btn-add-application").click(function(){
			var result = leave.verifyInput("#ask-for-leave-application");
			if (result) {
				var entity = leave.composeEntity("#ask-for-leave-application");
				$(this).attr("disabled",true); //设置按钮禁止，防止重复提交
				var token = $("#btn-token").val();
				jQuery.ajax({
					headers : {
						'Accept' : 'application/json',
						'Content-Type' : 'application/json'
					},
					type : "POST",
					data : JSON.stringify(entity),
					url : context +"student/ask-for-leave-application?token="+token,
					success : function(message, tst, jqXHR) {
						if (!util.checkSessionOut(jqXHR))
							return false;
						
						if (message.result == "success") {
							$(this).removeAttr("disabled"); //恢复按钮状态
							util.success("申请提交成功！",function(){
								document.location.href = context +"student/ask-for-leave";
							});
						}else if(message.result == "repeatSubmit"){
							util.error("请勿重复提交请假申请！",function(){
								document.location.href = context +"student/ask-for-leave";
							});
							
						}else {
							util.error("操作失败请稍后尝试:" + message.result);
						}
					}
				});
			}
		});
	},
	
	verifyInput : function verifyInput(id) { //检查输入的合法性
		var result = true;
		var checkStartTime = this.checkStartTime(id);
		var checkEndTime = this.checkEndTime(id);
		var checkReason = this.checkReason(id);
		var checkType = this.checkType(id);
		
		result = checkStartTime && checkEndTime && checkReason && checkType;
		return result;
	},
	
	checkStartTime : function checkStartTime(id) { //检查开始时间
		var start_time = $(id+" #start").val();
		if (start_time == "") {
			$(id+" .form-time .form-time-start").text("开始时间不能为空");
			$(id + " .form-time #start_Time").focus();
			$(id + " .form-time #start_Time").addClass("has-error");
			return false;
		} 
		return true;
	},
	
	checkEndTime : function checkEndTime(id) { //检查结束时间
		var end_time = $(id+" #end").val();
		if (end_time == "") {
			$(id+" .form-time .form-time-end").text("结束时间不能为空");
			$(id + " .form-time #end_Time").focus();
			$(id + " .form-time #end_Time").addClass("has-error");
			return false;
		} 
		return true;
	},
	
	checkReason : function checkReason(id) { //检查原因
		var reason = $(id+" #reason").val();
		if (reason == "") {
-			$(id+" .form-reason .form-message").text("请假原因不能为空");
			$(id + " .form-reason textarea").focus();
			$(id + " .form-reason textarea").addClass("has-error");
			return false;
		} 
		return true;
	},
	
	checkType : function checkType(id) { //检查请假类型
		var reason = $(id+" #type").val();
		if (reason == "0") {
			$(id+" .form-type .form-message").text("请选择请假类型！");
			$(id + " .form-type select").focus();
			$(id + " .form-type select").addClass("has-error");
			return false;
		} 
		return true;
	},
	
	composeEntity : function composeEntity(id) {
		var leave_entity = new Object();
		leave_entity.type = $(id+" #type").val();
		leave_entity.reason = $(id+" #reason").val();
		leave_entity.start_time = $(id+" #start_time").val();
		leave_entity.end_time = $(id+" #end_Time").val();
		return leave_entity;
	},
	
	// 清空表单，清除表单样式
	emptyForm : function emptyForm(id) {
		$('#' + id)[0].reset();
		$('#' + id +" .form-message").empty();
		$('#' + id +" input").removeClass("has-error");
		$('#' + id +" select").removeClass("has-error");
		$('#' + id +" textarea").removeClass("has-error");
	},
	//点击详情
	leaveParticulars : function leaveParticulars(id) {
		document.location.href = context
				+ "student/ask-for-leave/particulars-list/" + id;
	}
};