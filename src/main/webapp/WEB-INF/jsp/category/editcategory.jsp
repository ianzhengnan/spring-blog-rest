<%--
  Created by IntelliJ IDEA.
  User: I076453
  Date: 8/28/2017
  Time: 6:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>编辑类别</title>
</head>
<body>
<form:form action="edit" modelAttribute="category" method="post">
    标题：<form:input path="title"/><br>
    描述：<form:input path="description"/><br>
    <input type="submit" value="提交">
</form:form>
</body>
</html>
