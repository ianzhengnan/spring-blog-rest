<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${sessionScope.user_session.username}的文章 - ${requestScope.article.subject}</title>
	<script src="${ctx}/js/jquery-3.2.1.min.js"></script>
	<script>
		$(document).ready(function(){
			<%--$("#art_comment").load(--%>
			    <%--"${ctx}/${sessionScope.user_session.username}/article/${requestScope.article.id}/comments"--%>
			<%--);--%>
			$.get(
                "${ctx}/${sessionScope.user_session.username}/article/${requestScope.article.id}/comments",
				function(result){
                    $("#art_comment").html(result);
				}
			);
		});

	</script>
</head>
<body>
<p><a href="${ctx}/${sessionScope.user_session.username}/article">所有文章</a></p>
<article>
	<h1>${requestScope.article.subject}</h1>
	<p><span>${requestScope.article.createAt}</span>&nbsp;&nbsp;
	<span>阅读：${requestScope.article.visitCount == null ? 0 : requestScope.article.visitCount}</span>&nbsp;&nbsp;
	<span>评论：${requestScope.article.commentCount == null ? 0 : requestScope.article.commentCount}</span></p>
	<p>${requestScope.article.content}</p>
</article>

<div id="art_comment"></div>

</body>
</html>