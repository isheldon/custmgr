<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>客户分配</title>
</head>

<body>
  <form name="searchForm" action="toAllocate" method="POST">
    <select name="allocation">
      <option value="ALL" <c:if test="${allocation == 'ALL'}">selected</c:if>>全部</option>
      <option value="YES" <c:if test="${allocation == 'YES'}">selected</c:if>>已分配</option>
      <option value="NO" <c:if test="${allocation == 'NO'}">selected</c:if>>未分配</option>
    </select> <input type="submit" value="搜索" />
  </form>

  <form name="allocationForm" action="allocate" method="POST">
    <table>
      <thead>
        <tr>
          <td>全选</td>
          <td>单位名称</td>
          <td>联系人姓名</td>
          <td>联系电话</td>
          <td>所属销售</td>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${customers}" var="customer">
        <tr>
          <td>
            <input type="checkbox" name="customerId"/>
          </td>
          <td>${customer['orgName']}</td>
          <td>${customer['contactName']}</td>
          <td>${customer['contactPhone']}</td>
          <td>${customer['userName']}</td>
        </tr>
        </c:forEach>
      </tbody>
    </table>
  </form>
</body>
</html>