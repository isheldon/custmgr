<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../pub/header.jsp" %>
<%@include file="../pub/top-menu.jsp" %>

<div class="row">
  <div class="large-12 columns">
    <h3>新建用户</h3>
  </div>
  <hr/>
</div>

<form id="personForm" action="create" method="POST">
  <div class="row">
    <div class="large-6 columns">
      <label>登录账号: <input name="userName" type="text" required/></lable>
    </div>
  </div>
  <div class="row">
    <div class="large-6 columns">
      <label>用户姓名: <input name="realName" type="text" required/></lable>
    </div>
  </div>
  <div class="row">
    <div class="large-3 columns">
      <label>所属主管:
        <select name="managerId">
          <option value="">------请选择主管------</option>
          <c:forEach items="${managers}" var="manager">
            <option value="${manager['id']}">${manager['realName']}</option>
          </c:forEach>
        </select>
      </lable>
    </div>
  </div>
     
  <div class="row">
    <div class="large-6 columns">
      <input type="submit" value="保存" class="button"/>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <a href="../salespersons" class="button">返回</a>
    </div>
  </div>
 </form>
<%@include file="../pub/footer.jsp" %>