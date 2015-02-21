<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>新建客户</title>
</head>

<body>
  
  <form:form id="customerForm" commandName="customer" action="create" method="POST">
      单位名称: <form:input path="orgName"/> <br/>
      单位地址: <form:input path="orgAddress"/> <br/>
      联系人姓名: <form:input path="contactName"/> <br/>
      联系电话: <form:input path="contactPhone"/> <br/>
      邮箱: <form:input path="email"/> <br/>
    QQ: <form:input path="qq"/> <br/>
    <input type="submit" value="保存" />
    <a href="../customers">返回</a>
  </form:form>

</body>
</html>