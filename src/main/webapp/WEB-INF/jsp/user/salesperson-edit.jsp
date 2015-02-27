<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="../pub/header.jsp" %>
<%@include file="../pub/top-menu.jsp" %>

<div class="row">
  <div class="large-12 columns">
    <h3>用户编辑</h3>
  </div>
  <hr/>
</div>

<body>
  <form:form id="personForm" commandName="salesperson" action="../update" method="POST">
    <form:hidden path="id" />
    <div class="row">
      <div class="large-6 columns">
        <label>登录账号: <form:input path="userName" readonly="true" /></lable>
      </div>
    </div>
    <div class="row">
      <div class="large-6 columns">
        <label>用户姓名: <form:input path="realName" required="true"/></lable>
      </div>
    </div>
    <div class="row">
      <div class="large-6 columns">
        <label>所属主管:
          <form:select path="managerId">
            <form:option value="" label="------请选择主管------"/>
            <form:options items="${managers}" itemValue="id" itemLabel="realName"/>
          </form:select>
        </lable>
      </div>
    </div>

    <div class="row">
      <div class="large-6 columns">
        <input type="submit" value="保存" class="button"/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="../../salespersons" class="button">返回</a>
      </div>
    </div>
  </form:form>
<%@include file="../pub/footer.jsp" %>