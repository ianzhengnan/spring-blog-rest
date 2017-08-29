<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home page</title>
</head>
<body>
Welcome, <span>${sessionScope.user_session.username}</span>&nbsp;&nbsp;<span><a href="${ctx}/account/logout">logout</a></span><br>
<a href="${ctx}/${sessionScope.user_session.username}/article">发布的文章</a> &nbsp;&nbsp;
<a href="${ctx}/postlist">管理文章</a>
<a href="${ctx}/postedit">新增</a>
</body>
</html>