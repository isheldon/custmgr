<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>登录</title>
</head>

<body>
  <c:if test="${loginMsg == 1}">  
      用户名或密码错误
  </c:if> 
  <c:if test="${loginMsg == 2}">  
      您已退出
  </c:if> 
  <br/>
  <form action="doLogin" method="POST">
       用户名: <input name="userName" type="text"/>
   <br/>
       密码: <input name="password" type="password"/>
   <input type="submit" value="登录" />
  </form>
</body>
</html>