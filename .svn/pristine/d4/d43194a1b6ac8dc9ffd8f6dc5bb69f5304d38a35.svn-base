// 搜索按钮点击
$("#btn-score-search").click(function() {
	var condition = score.genrateParamOld();
	score.redirectUrl(condition);
});

var score = {
	genrateParamOld : function genrateParamOld() {
		var examType = $("#search-examType option:selected").val();
		var fieldName = $("#search-subject option:selected").text();
		var pass = $("#search-pass option:selected").val();
		var page = 1;
		var data = new Object();
		data.page = page;
		data.examType = examType;
		data.fieldName = fieldName;
		data.pass = pass;
		return data;
	},
	redirectUrl : function redirectUrl(newparam) {
		var paramurl = newparam.page;
		paramurl = paramurl + "-" + newparam.pass;
		document.location.href = document.getElementsByTagName('base')[0].href
				+ 'student/score/filter-' + paramurl + "?examType="
				+ newparam.examType + "&fieldName=" + newparam.fieldName;
	},
}

// 分页组件按钮
$(".pagination li a").click(function() {
	var pageId = $(this).data("id");
	if (pageId == null || pageId == "")
		return false;
	var getParamOld = score.genrateParamOld();
	getParamOld.page = pageId;
	score.redirectUrl(getParamOld);

});
