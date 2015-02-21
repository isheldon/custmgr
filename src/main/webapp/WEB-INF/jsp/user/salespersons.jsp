<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>用户管理</title>
</head>

<a href="salesperson/new">添加用户</a>
<body>
  <table>
    <thead>
      <tr><td>登录帐号</td><td>用户姓名</td><td>所属主管</td><td>操作</td></tr>
    </thead>
    <tbody>
      <c:forEach items="${salespersons}" var="person">
      <tr>
        <td>${person['userName']}</td>
        <td>${person['realName']}</td>
        <td>${person['managerName']}</td>
        <td>
          <a href="salesperson/edit/${person['id']}">编辑</a> &nbsp;
          <a href="salesperson/delete/${person['id']}">删除</a>
        </td>
      </tr>
      </c:forEach>
    </tbody> 
  </table>
</body>
</html>