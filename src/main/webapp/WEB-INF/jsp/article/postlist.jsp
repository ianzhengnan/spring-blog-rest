<%--
  Created by IntelliJ IDEA.
  User: zhengnan
  Date: 2017/8/27
  Time: 上午10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!doctype html>
</html>
<html>
<head>
    <title>管理文章</title>

    <script>
        function onPrePressed(e){
            var prePage = ${requestScope.pageModel.currentPage} > 1 ? ${requestScope.pageModel.currentPage - 1} : 1;
            window.location = "${ctx}/postlist?page=" + prePage;
        }

        function onNextPressed(e){
            var nextPage = ${requestScope.pageModel.currentPage} < ${requestScope.pageModel.totalPage} ? ${requestScope.pageModel.currentPage + 1} : ${requestScope.pageModel.totalPage};
            window.location = "${ctx}/postlist?page=" + nextPage;
        }

        window.onload = function(){
            var spantest = document.getElementById("testspan");

        }

    </script>


</head>
<body>
<p><a href="${ctx}/main">主页</a></p>
<span><a href="${ctx}/postlist?status=draft"><span><c:if test="${requestScope.status != null && requestScope.status == 'draft' }">*</c:if></span>草稿</a></span>|
<span><a href="${ctx}/postlist?status=publish"><span><c:if test="${requestScope.status == null || requestScope.status == 'publish' }">*</c:if></span>已发布</a></span>|
<span><a href="${ctx}/category">类别管理</a></span>
<ul>
    <c:forEach items="${requestScope.articles}" var="art" varStatus="stat">
        <li>
            <span><c:if test="${ art.top == '1' }">[置顶]</c:if></span>
            <span><a href="${ctx}/${sessionScope.user_session.username}/article/${art.id}">${art.subject}</a></span> &nbsp;&nbsp;
            <span>${art.createAt == null ? "空" : art.lastModifyAt}</span>&nbsp;&nbsp;
            <span>阅读：${art.visitCount == null ? 0 : art.visitCount}</span>&nbsp;&nbsp;
            <span>评论：${art.commentCount == null ? 0 : art.commentCount}</span>
            <span style="text-align: right;"><a href="${ctx}/postedit?id=${art.id}">编辑</a>
                |<a href="${ctx}/del?id=${art.id}">删除</a>
                |<c:choose>
                    <c:when test="${art.top == ''}"><a href="${ctx}/top?id=${art.id}">置顶</a></c:when>
                    <c:otherwise><a href="${ctx}/untop?id=${art.id}">取消置顶</a></c:otherwise>
                </c:choose>
            </span>
        </li>
    </c:forEach>
    <a href="${ctx}/postlist?page=1">首页</a>&nbsp;&nbsp;
    <a href="javascript:onPrePressed()">上一页</a>&nbsp;&nbsp;
    <a href="javascript:onNextPressed()">下一页</a>&nbsp;&nbsp;
    <a href="${ctx}/postlist?page=${requestScope.pageModel.totalPage}">最后一页</a>&nbsp;&nbsp;
    <span>共${requestScope.pageModel.totalPage}页</span>
</ul>
</body>
</html>
