<%@ page pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>404</title>
<link rel="shortcut icon"
	href="<%=basePath%>resources/images/favicon.ico" />
</head>
<style>
body {
	margin: 0;
	padding: 0;
	background-color: whitesmoke;
}

a {
	text-decoration: none;
}

.header {
	width: 100%;
	height: 30px;
	margin-bottom: 30px;
	font-family: -webkit-pictograph;
}

.header p {
	font-size: xx-large;
	font-family: sans-serif;
}

.header p a {
	display: block;
	background: aliceblue;
	width: 150px;
	font-size: 0.7em;
	text-decoration: none;
	border-radius: 12px;
	background-color: gold;
	height: 40px;
	line-height: 40px;
	text-align: center;
	float: right;
	cursor: pointer;
}

.header p a:hover {
	color: white;
}

.content {
	width: 100%;
	background-color: lightskyblue;
}

.content-up, .content-down {
	width: 100%;
	height: 50px;
}

.content-img img {
	width: 50%;
	padding: 0 auto;
	margin-left: 23%;
}

.footer {
	width: 100%;
	position: fixed;
	height: 50px;
	bottom: 0;
	padding-bottom: 20px;
}

.footer p {
	text-align: center;
}
</style>
<body>

	<div class="header">
		<p>
			Oops!The page you requested was not fonud!<a
				href="javascript:history.back()">Go Back</a>
		</p>
	</div>

	<div class="content">
		<div class="content-up"></div>

		<div class="content-img">
			<img src="<%=basePath%>resources/images/404.jpg">
		</div>

		<div class="content-down"></div>
	</div>


	<div class="footer">
		<p>
			CoreWisdom&nbsp;Copyright&nbsp;©中智软件科技学校在线考试系统-&nbsp;<a
				href="http://www.javaketang.com">主页</a><span>|</span><a
				href="http://www.javaketang.com/html/about/">关于我们</a><span>|</span><a
				href="http://www.javaketang.com">FAQ</a><span>|</span><a
				href="http://www.javaketang.com">联系我们</a>
		</p>
	</div>
</body>
</html>
