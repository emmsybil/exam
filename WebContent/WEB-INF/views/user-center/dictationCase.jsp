<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%-- <%@taglib uri="spring.tld" prefix="spring"%> --%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>听写情况</title>
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="keywords" content="">
<link rel="shortcut icon"
	href="<%=basePath%>resources/images/favicon.ico" />
<link href="resources/bootstrap/css/bootstrap-huan.css" rel="stylesheet">
<link href="resources/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
<link href="resources/css/exam.css" rel="stylesheet">
<link href="resources/chart/morris.css" rel="stylesheet">
<link href="resources/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet" />
<style>
a.btn {
	margin-top: 0px;
}
</style>
</head>
<body>
	<header>
		<div class="container">
			<div class="row">
				<div class="col-xs-5">
					<div class="logo">
						<h1>
							<a href="#"><img alt="" src="resources/images/logo.png"></a>
						</h1>
					</div>
				</div>
				<div class="col-xs-7" id="login-info">
					<c:choose>
						<c:when
							test="${not empty sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username}">
							<div id="login-info-user">

								<a
									href="user-detail/${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username}"
									id="system-info-account" target="_blank">${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username}</a>
								<span>|</span> <a href="j_spring_security_logout"><i
									class="fa fa-sign-out"></i> 退出</a>
							</div>
						</c:when>
						<c:otherwise>
							<a class="btn btn-primary" href="user-register">用户注册</a>
							<a class="btn btn-success" href="user-login-page">登录</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</header>
	<!-- Navigation bar starts -->

	<div class="navbar bs-docs-nav" role="banner">
		<div class="container">
			<nav class="collapse navbar-collapse bs-navbar-collapse"
				role="navigation">
				<ul class="nav navbar-nav">
					<li><a href="home"><i class="fa fa-home"></i>主页</a></li>
					<li><a href="student/practice-list"><i class="fa fa-edit"></i>试题练习</a>
					</li>
					<li><a href="exam-list"><i class="fa  fa-paper-plane-o"></i>在线考试</a>
					</li>
					<li><a href="training-list"><i class="fa fa-book"></i>培训资料</a>
					</li>
					<li class="active"><a href="student/usercenter"><i
							class="fa fa-dashboard"></i>会员中心</a></li>
					<li><a href="student/dictationCase/1"
						class="fa fa fa-file-text-o"> 单词听写</a></li>
					<li><a href="student/setting"><i class="fa fa-cogs"></i>个人设置</a>
					</li>
				</ul>
			</nav>
		</div>
	</div>

	<!-- Navigation bar ends -->

	<!-- Slider starts -->

	<div>
		<!-- Slider (Flex Slider) -->

		<div class="container" style="min-height: 500px;">

			<div class="row">
				<div class="col-xs-2">
					<ul class="nav default-sidenav">
						<li><a href="student/usercenter"> <i
								class="fa fa-dashboard"></i> 用户中心
						</a></li>
						<li><a href="student/analysis"> <i
								class="fa fa-bar-chart-o"></i> 统计分析
						</a></li>
						<li><a> <i class="fa fa-history"></i> 考试历史
						</a></li>
						<li><a href="student/training-history"> <i
								class="fa fa-book"></i> 培训历史
						</a></li>
						<li><a href="student/dictationCase/1/1"
							class="fa fa fa-file-text-o"> 单词听写</a></li>
						<li><a href="student/ask-for-leave/filter-1-0-0-0.html"><i
								class="glyphicon glyphicon-list-alt"></i> 请假 </a></li>
						<li><a href="student/score"><i class="fa fa-trophy"></i> 成绩 </a></li>
					</ul>
				</div>
				<div class="col-xs-10">
					<div class="page-header">
						<h1>
							<i class="fa fa fa-file-text-o"></i> 听写单词
						</h1>
					</div>
					<div class="page-header">
						<table class="table-striped table">
							<thead>
								<tr>
									<td>听写时间</td>
									<td>听写单词内容</td>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listWords }" var="item">
									<tr>
										<td>${item.dictationDate }</td>
										<td>${item.words }</td>
									</tr>
								</c:forEach>

							</tbody>
							<tfoot></tfoot>
						</table>
						<div class="text-conter">
							<ul class="pagination pagination-sm">${pageStr}
							</ul>
						</div>
					</div>
					<div class="page-header">
						<h3>
							<i class="fa fa fa-file-text-o"></i> 查询听写情况
						</h3>
						<div>
							<span>选择开始时间：</span> <input type="text" class="sang_Calender"
								id="startTime" maxlength="60" readonly="readonly" /> <span>选择结束时间：</span>
							<input type="text" class="sang_Calender" id="endTime"
								maxlength="60" readonly="readonly" />
							<button class="btn btn-info" id="update-student-btn"
								onclick="dictation.dictationSelect()">查询</button>
						</div>

					</div>
					<div class="page-content row">
						<div id="question-list">
							<table class="table-striped table">
								<thead>
									<tr>
										<td>审阅人</td>
										<td>审阅时间</td>
										<td>听写情况</td>
										<td>罚抄情况</td>
									</tr>
								</thead>
								<tbody id="dictation-text">
									<c:forEach items="${listWords2 }" var="item">
										<tr>
											<td>${item.approverName }</td>
											<td>${item.approverDate }</td>
											<td><span> <c:choose>
														<c:when test="${item.cases==1 }">未通过</c:when>
														<c:otherwise>
												通过
												</c:otherwise>
													</c:choose>
											</span></td>
											<td><c:choose>
													<c:when test="${item.copyingType==1 }">未交</c:when>
													<c:otherwise>
												已交
												</c:otherwise>
												</c:choose>
										</tr>
									</c:forEach>
								</tbody>
								<tfoot></tfoot>
							</table>
							<div class="text-conter">
								<ul id="paging" class="pagination pagination-sm">${pageStr2}
								</ul>
							</div>
						</div>

					</div>

				</div>
			</div>
		</div>
	</div>
		<jsp:include page="../common/footer.jsp"></jsp:include>

	<!-- Slider Ends -->

	<!-- Javascript files -->
	<!-- jQuery -->
	<script type="text/javascript"
		src="resources/js/jquery/jquery-1.9.0.min.js"></script>
	<script src="resources/js/all.js">
	<!-- Bootstrap JS -->
		<script type="text/javascript"
		src="resources/bootstrap/js/bootstrap.min.js">
	</script>
	<script type="text/javascript" src="resources/chart/raphael-min.js"></script>
	<script type="text/javascript" src="resources/chart/morris.js"></script>
	<script type="text/javascript" src="resources/js/exam-finished.js"></script>
	<script type="text/javascript"
		src="resources/js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript"
		src="resources/js/bootstrap-datetimepicker.zh-CN.js"></script>
	<script type="text/javascript" src="resources/js/dictation.js"></script>
</body>
</html>