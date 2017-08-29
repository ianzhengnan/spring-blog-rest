<%--
  Created by IntelliJ IDEA.
  User: I076453
  Date: 8/28/2017
  Time: 6:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>${sessionScope.user_session.username} - 类别管理</title>
    <script src="${ctx}/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">

        window.onload = function () {
            $("#addbtn").on("click",function(){
                var title = $("#category").val();
                var settings = "";
                if(title == null){
                    alert('请输入类别');
                }
                $.ajax({
                    "url": "${ctx}/category/new",
                    "method": "POST",
                    "data": {
                        "title": title
                    }
                }).done(function(response){
                    console.log(response);
                    window.location = "${ctx}/category";
                });

            });
        }
        function delCat(id, title){
            if(confirm("确认删除" + title + " 吗？")){
                $.ajax({
                    "url": "${ctx}/category/del/" + id,
                    "method": "POST"
                }).done(function(response){
                    console.log(response);
                    window.location = "${ctx}/category";
                });
            }
        }
    </script>
</head>
<body>
<p><a href="${ctx}/main">主页</a></p>
<span><a href="${ctx}/postlist?status=draft"><span><c:if test="${requestScope.status != null && requestScope.status == 'draft' }">*</c:if></span>草稿</a></span>|
<span><a href="${ctx}/postlist?status=publish"><span><c:if test="${requestScope.status == null || requestScope.status == 'publish' }">*</c:if></span>已发布</a></span>|
<span><a href="${ctx}/category">类别管理</a></span>

<c:forEach items="${requestScope.categories}" var="category">
    <table border="1">
        <th>类别</th>
        <th>文章</th>
        <th>操作</th>
        <tr>
            <td>${category.title}</td>
            <td>${category.articles}</td>
            <td>
                <a href="${ctx}/category/edit/${category.id}">编辑</a>|
                <a href="javascript:delCat('${category.id}','${category.title}');">删除</a>
            </td>
        </tr>
    </table>
</c:forEach>

<input id="category" type="text" name="title">
<button id="addbtn">添加分类</button>


</body>
</html>
