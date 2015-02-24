<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>历史备注</title>
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

  <a href="../${backPath}">返回</a>

</body>
</html>