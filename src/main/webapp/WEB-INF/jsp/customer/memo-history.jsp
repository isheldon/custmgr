<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../pub/header.jsp" %>
<%@include file="../pub/top-menu.jsp" %>

<div class="row">
  <table width="100%">
    <thead>
      <tr>
        <td width="20%">日期</td>
        <td>备注内容</td>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${memos}" var="memo">
      <tr>
        <td width="20%">${memo['memoTime']}</td>
        <td>${memo['memo']}</td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
  <a href="../${backPath}" class="button">返回</a>
</div>

<%@include file="../pub/footer.jsp" %>