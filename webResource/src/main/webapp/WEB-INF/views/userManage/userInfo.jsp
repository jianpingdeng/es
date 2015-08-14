<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" deferredSyntaxAllowedAsLiteral="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
</head>
<body>
用户名：${user.username}<br/>
密码：${user.password}<br/>
状态:${user.locked}<br/>
<hr>
<c:forEach items="${roles}" var="item" varStatus="status">
   <li>${item}</li>
</c:forEach>
<hr>
<c:forEach items="${permissions}" var="item" varStatus="status">
    <li>${item}</li>
</c:forEach>


</body>
</html>
