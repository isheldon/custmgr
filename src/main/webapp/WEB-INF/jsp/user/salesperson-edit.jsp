<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>用户编辑</title>
</head>

<body>
  <form:form id="personForm" commandName="salesperson" action="../update" method="POST">
    <form:hidden path="id" />
       登录账号: <form:input path="userName" readonly="true" />
    <br/>
       用户姓名: <form:input path="realName"/>
    <br/>
       所属主管:
    <form:select path="managerId">
      <form:option value="" label="请选择主管"/>
      <form:options items="${managers}" itemValue="id" itemLabel="realName"/>
    </form:select>
    <br/>
    <input type="submit" value="保存" />
    <a href="../../salespersons">返回</a>
  </form:form>
</body>
</html>