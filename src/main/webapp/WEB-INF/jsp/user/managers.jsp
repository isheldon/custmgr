<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../pub/header.jsp" %>
<%@include file="../pub/top-menu.jsp" %>

<div class="row">
  <div class="large-12 columns">
    <h3>主管管理</h3>
  </div>
  <hr/>
</div>

<div class="row">
  <a href="manager/new" class="button">添加主管</a>
  <table width="100%">
    <thead>
      <tr><td>登录帐号</td><td>用户姓名</td><td>操作</td></tr>
    </thead>
    <tbody>
      <c:forEach items="${managers}" var="manager">
      <tr>
        <td>${manager['userName']}</td>
        <td>${manager['realName']}</td>
        <td><a href="manager/delete/${manager['id']}">删除</a></td>
      </tr>
      </c:forEach>
    </tbody> 
  </table>
</div>

<%@include file="../pub/footer.jsp" %>