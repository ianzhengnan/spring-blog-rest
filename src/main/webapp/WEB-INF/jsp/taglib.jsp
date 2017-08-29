<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- 设置一个项目路径变量 -->
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<c:set var="main" value="${ctx}/main"></c:set>
<c:set var="postlist" value="${ctx}/postlist"></c:set>
<c:set var="postedit" value="${ctx}/postedit"></c:set>
<c:set var="logout" value="${ctx}/account/logout"></c:set>

