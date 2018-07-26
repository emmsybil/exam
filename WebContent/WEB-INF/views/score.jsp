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
<title>成绩</title>
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
<style>
a.btn {
	margin-top: 0px;
}

.section-navi-item {
	display: inline-block;
	height: 24px;
	background: rgb(239, 237, 237);
	padding: 0 10px;
	margin: 3px;
	font-family: arial;
	text-align: center;
	line-height: 24px;
	color: #428bca;
	font-size: 12px;
	cursor: pointer;
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
						<li><a href="student/exam-history"> <i
								class="fa fa-history"></i> 考试历史
						</a></li>
						<li><a href="student/training-history"> <i
								class="fa fa-book"></i> 培训历史
						</a></li>
						<li><a href="student/dictationCase/1/1"
							class="fa fa fa-file-text-o"> 单词听写</a></li>
						<li><a
							href="student/ask-for-leave/filter-1-0-0-0.html"><i
								class="glyphicon glyphicon-list-alt"></i> 请假 </a></li>
						<li class="active"><a href="student/score"><i class="fa fa-trophy"></i> 成绩 </a></li>
					</ul>
				</div>

				<div class="col-xs-10" id="right-content">
					<div class="page-header">
						<h1>
							<i class="fa fa-trophy"></i> 成绩历史
						</h1>
					</div>
					<div class="page-content">
						<div id="score-filter">
							<table class="table-striped table">
								<thead>
									<tr>
										<td>科目名称</td>
										<td>考试类型</td>
										<td>及格</td>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><select class="df-input-narrow" id="search-subject">
												<option value="0">请选择</option>
												<c:forEach items="${fieldList}" var="fieldList">
													<option <c:if test="${fieldName eq fieldList.fieldName}">selected="selected"</c:if> value="${fieldList.fieldId}">${fieldList.fieldName}</option>
												</c:forEach>
										</select></td>
										<td><select class="df-input-narrow" id="search-examType">
												<option value="0">请选择</option>
												<option value="1" <c:if test="${examType == 1}">selected="selected"</c:if>>笔试</option>
												<option value="2" <c:if test="${examType == 2}">selected="selected"</c:if>>机试</option>
										</select></td>
										<td><select class="df-input-narrow" id="search-pass">
												<option value="0">请选择</option>
												<option value="1" <c:if test="${pass == 1}">selected="selected"</c:if>>是</option>
												<option value="2" <c:if test="${pass == 2}">selected="selected"</c:if>>否</option>
										</select></td>
										<td><button class="btn btn-sm btn-default" type="button"
												id="btn-score-search" data-id="0">
												<i class="fa fa-search"></i>查找
											</button></td>
									</tr>
								</tbody>
								<tfoot></tfoot>
							</table>
						</div>
						
						<div id="score-list">
							<table class="table-striped table">
								<thead>
									<tr>
										<td>考试科目</td>
										<td>考试时间</td>
										<td>类型</td>
										<td>分数</td>
										<td>及格</td>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${scoreList}" var="item">
										<tr>
											<td>${item.fieldName}</td>
											<td>${item.examTime}</td>
											<td><c:if test="${item.examType==1}">笔试</c:if>
											<c:if test="${item.examType==2}">机试</c:if></td>
											<td>${item.score}</td>
											<td><c:if test="${item.pass==1}">是</c:if> <c:if
													test="${item.pass==2}">否</c:if></td>
											<c:if test="${item.pass==2}"></c:if>
										</tr>
									</c:forEach>
								</tbody>
								<tfoot></tfoot>
							</table>
							<!-- 分页组件 -->
							<div class="page-link-content" style="text-align: center;">
								<ul class="pagination pagination-sm" id="pagination">
									<li class="disabled"><span style="color: #428bca;">总共${count}条</span></li>
									${pageStr}
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

<jsp:include page="common/footer.jsp"></jsp:include>
	<!-- Slider Ends -->

	<!-- Javascript files -->
	<!-- jQuery -->
	<script type="text/javascript"
		src="resources/js/jquery/jquery-1.9.0.min.js"></script>
	<!-- Bootstrap JS -->
	<script type="text/javascript"
		src="resources/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/chart/raphael-min.js"></script>
	<script type="text/javascript" src="resources/chart/morris.js"></script>
	<script type="text/javascript" src="resources/js/all.js"></script>
	<script type="text/javascript" src="resources/js/scoreHistory.js"></script>
	
</body>
</html>