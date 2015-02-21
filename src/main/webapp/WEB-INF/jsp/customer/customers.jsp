<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>客户管理</title>
</head>

<body>
  <a href="new">添加客户</a>

  <form:form id="customerForm" commandName="customer" action="customers" method="POST">
      单位名称: <form:input path="orgName"/> &nbsp;
      联系人: <form:input path="contactName"/> &nbsp;
      电话: <form:input path="contactPhone"/> &nbsp;
      联系状态:
    <form:select path="contacted">
      <form:option value="" label="全部"/>
      <form:option value="0" label="未联系"/>
      <form:option value="1" label="已联系"/>
      <form:option value="2" label="未接通"/>
    </form:select> &nbsp;
      所属销售: <form:input path="userName"/> &nbsp;
    <input type="submit" value="搜索" />
  </form:form>

  <table>
    <thead>
      <tr>
        <td>单位名称</td>
        <td>联系人姓名</td>
        <td>联系电话</td>
        <td>所属销售</td>
        <td>联系状态</td>
        <td>备注内容</td>
        <td>备注时间</td>
        <td>操作</td>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${customers}" var="customer">
      <tr>
        <td>${customer['orgName']}</td>
        <td>${customer['contactName']}</td>
        <td>${customer['contactPhone']}</td>
        <td>${customer['userName']}</td>
        <td>
          <c:if test="${customer['contacted'] == 0}">未联系</c:if> 
          <c:if test="${customer['contacted'] == 1}">已联系</c:if> 
          <c:if test="${customer['contacted'] == 2}">未接通</c:if> 
        </td>
        <td>${customer['lastMemo']}</td>
        <td>${customer['lastMemoTime']}</td>
        <td><a href="customer/memohistory/${customer['id']}">历史备注</a></td>
      </tr>
      </c:forEach>
    </tbody> 
  </table>
</body>
</html>