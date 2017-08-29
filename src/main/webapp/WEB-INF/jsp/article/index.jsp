<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${sessionScope.user_session.username} - 所有文章</title>

	<script>
        function onPrePressed(e){
            var prePage = ${requestScope.pageModel.currentPage} > 1 ? ${requestScope.pageModel.currentPage - 1} : 1;
            window.location = "${ctx}/${requestScope.username}/article?page=" + prePage;
        }

        function onNextPressed(e){
            var nextPage = ${requestScope.pageModel.currentPage} < ${requestScope.pageModel.totalPage} ? ${requestScope.pageModel.currentPage + 1} : ${requestScope.pageModel.totalPage};
            window.location = "${ctx}/${requestScope.username}/article?page=" + nextPage;
        }

	</script>

</head>
<body>
<p><a href="${ctx }/main">主页</a></p>
<ul>
<c:forEach items="${requestScope.articles}" var="art" varStatus="stat">
	<li>
		<span><c:if test="${ art.top == '1' }">[置顶]</c:if></span>
		<span><a href="${ctx}/${sessionScope.user_session.username}/article/${art.id}">${art.subject}</a></span> &nbsp;&nbsp;
		<span>${art.createAt == null ? "空" : art.lastModifyAt}</span>&nbsp;&nbsp;
		<span>阅读：${art.visitCount == null ? 0 : art.visitCount}</span>&nbsp;&nbsp;
		<span>评论：${art.commentCount == null ? 0 : art.commentCount}</span>
	</li>
</c:forEach>
</ul>
<a href="${ctx}/${requestScope.username}/article?page=1">首页</a>&nbsp;&nbsp;
<a href="javascript:onPrePressed()">上一页</a>&nbsp;&nbsp;
<a href="javascript:onNextPressed()">下一页</a>&nbsp;&nbsp;
<a href="${ctx}/${requestScope.username}/article?page=${requestScope.pageModel.totalPage}">最后一页</a>&nbsp;&nbsp;
<span>共${requestScope.pageModel.totalPage}页</span>
</body>
</html>