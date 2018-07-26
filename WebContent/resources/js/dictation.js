$(".sang_Calender").datetimepicker({
	format : 'yyyy:mm:dd hh:ii',
	language : 'zh-CN',
	autoclose : true,
	todayBtn : true,
	forceParse : true,
	showMeridian : false,
	maxView : 'decade',
	todayHighlight : 1
});

$(".pagination li a").click(
		function() {
			var pageId = $(this).data("id");
			if (pageId == null || pageId == "")
				return false;
			document.location.href = util.basePath() + "student/dictationCase/"
					+ pageId + "/1";
		});

$("#paging li a").click(
		function() {
			var pageId = $(this).data("id");
			if (pageId == null || pageId == "")
				return false;
			document.location.href = util.basePath()
					+ "student/dictationCase/1/" + pageId
					+ window.location.search;
		});

var dictation = {

	dictationSelect : function dictationSelect() {

		var startTime = $("#startTime").val();
		var endTime = $("#endTime").val();

		if (startTime == "" || startTime == undefined) {
			util.error("查询失败，开始时间为空");
			return;
		}

		if (endTime == "" || endTime == undefined) {
			util.error("查询失败，结束时间为空");
			return;
		}
		document.location.href = util.basePath()
				+ "student/dictationCase/1/1?startTime=" + startTime
				+ "&endTime=" + endTime;

	}

}