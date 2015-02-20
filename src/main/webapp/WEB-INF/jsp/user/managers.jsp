<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>主管管理</title>
</head>

<a href="manager/new">添加主管</a>
<body>
  <table>
    <thead>
      <tr><td>登录帐号</td><td>用户姓名</td><td>操作</td></tr>
    </thead>
    <tbody>
      <c:forEach items="${managers}" var="manager">
      <tr>
        <td>${manager['userName']}</td>
        <td>${manager['realName']}</td>
        <td><a href="manager/delete/${manager['id']}">删除</a></td>
      </tr>
      </c:forEach>
    </tbody> 
  </table>
</body>
</html>