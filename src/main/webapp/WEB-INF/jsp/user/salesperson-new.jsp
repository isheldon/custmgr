<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>新建用户</title>
</head>

<body>
  <form id="personForm" action="create" method="POST">
       登录账号: <input name="userName" type="text"/>
    <br/>
       用户姓名: <input name="realName" type="text"/>
    <br/>
       所属主管:
    <select name="managerId">
      <option value="">请选择主管</option>
      <c:forEach items="${managers}" var="manager">
        <option value="${manager['id']}">${manager['realName']}</option>
      </c:forEach>
    </select>
    <br/>
    <input type="submit" value="保存" />
    <a href="../salespersons">返回</a>
   </form>
</body>
</html>