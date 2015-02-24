<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>新建客户</title>
</head>

<body>

  <form:form id="customerForm" commandName="customer" action="create" method="POST">
    <form:hidden path="userId" />
      单位名称: <form:input path="orgName" />
    <br />
      单位地址: <form:input path="orgAddress" />
    <br />
      联系人姓名: <form:input path="contactName" />
    <br />
      联系电话: <form:input path="contactPhone" />
    <br />
      邮箱: <form:input path="email" />
    <br />
    QQ: <form:input path="qq" />
    <br />
    <input type="submit" value="保存" />

    <c:choose>
      <c:when test="${empty customer.userId}">
        <a href="customers">返回</a>
      </c:when>
      <c:otherwise>
        <a href="selfcustomers">返回</a>
      </c:otherwise>
    </c:choose>
  </form:form>

</body>
</html>