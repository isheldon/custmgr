<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>修改密码</title>
</head>

<body>
  <c:if test="${pwdMsg == 1}">  
      密码已修改
  </c:if> 
  <br/>
  <form action="chgpwd" method="POST">
       密码: <input name="password" type="password"/>
   <br/>
       确认密码: <input name="repassword" type="password"/>
   <input type="submit" value="确定" />
  </form>
</body>
</html>