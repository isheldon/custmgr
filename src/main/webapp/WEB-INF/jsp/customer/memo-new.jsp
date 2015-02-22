<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>添加备注</title>
</head>

<body>
  历史备注
  <table>
    <thead>
      <tr>
        <td>日期</td>
        <td>备注内容</td>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${memos}" var="memo">
      <tr>
        <td>${memo['memoTime']}</td>
        <td>${memo['memo']}</td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
  
  <form action="../createMemo" method="POST">
    <input type="hidden" name="customerId" value="${customer.id}"/>
    联系状态:
    <select name="contacted">
      <option value="0" <c:if test="${customer.contacted == 0}">selected</c:if>>未联系</option>
      <option value="1" <c:if test="${customer.contacted == 1}">selected</c:if>>已联系</option>
      <option value="2" <c:if test="${customer.contacted == 2}">selected</c:if>>未接通</option>
    </select>
    <br/>
    文字描述：
    <textarea name="memo" rows="5" cols="20"></textarea>
    <br/>

    <input type="submit" value="保存" />
    <a href="../selfcustomers">返回</a>
  </form>

</body>
</html>