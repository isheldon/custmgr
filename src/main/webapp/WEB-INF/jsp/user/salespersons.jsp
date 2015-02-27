<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../pub/header.jsp" %>
<%@include file="../pub/top-menu.jsp" %>

<div class="row">
  <div class="large-12 columns">
    <h3>用户管理</h3>
  </div>
  <hr/>
</div>

<div class="row">
  <a href="salesperson/new" class="button">添加用户</a>
  <table width="100%">
    <thead>
      <tr><td>登录帐号</td><td>用户姓名</td><td>所属主管</td><td>操作</td></tr>
    </thead>
    <tbody>
      <c:forEach items="${salespersons}" var="person">
      <tr>
        <td>${person['userName']}</td>
        <td>${person['realName']}</td>
        <td>${person['managerName']}</td>
        <td>
          <a href="salesperson/edit/${person['id']}">编辑</a> &nbsp;
          <a href="salesperson/delete/${person['id']}">删除</a>
        </td>
      </tr>
      </c:forEach>
    </tbody> 
  </table>
</div>

<%@include file="../pub/footer.jsp" %>