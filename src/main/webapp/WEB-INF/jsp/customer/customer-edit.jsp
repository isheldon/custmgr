<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="../pub/header.jsp" %>
<%@include file="../pub/top-menu.jsp" %>

<div class="row">
  <div class="large-12 columns">
    <h3>编辑客户</h3>
  </div>
  <hr/>
</div>

  <form:form id="customerForm" commandName="customer" action="../update" method="POST">
    <form:hidden path="id" />
    <div class="row">
      <div class="large-12 columns">
        <label>单位名称: <form:input path="orgName" required="true"/> </label>
      </div>
    </div>
    <div class="row">
      <div class="large-12 columns">
        <label>单位地址: <form:input path="orgAddress" /> </label>
      </div>
    </div>
    <div class="row">
      <div class="large-6 columns">
        <label>联系人姓名: <form:input path="contactName" /> </label>
      </div>
      <div class="large-6 columns">
        <label>联系电话: <form:input path="contactPhone" /> </label>
      </div>
    </div>
    <div class="row">
      <div class="large-6 columns">
        <label>邮箱: <form:input path="email" /> </label>
      </div>
      <div class="large-6 columns">
        <label>QQ: <form:input path="qq" /> </label>
      </div>
    </div>
    
    <div class="row">
      <div class="large-6 columns">
        <input type="submit" value="保存" class="button"/>
        <a href="${backPath}" class="button">返回</a>
      </div>
    </div>
  </form:form>

<%@include file="../pub/footer.jsp" %>
