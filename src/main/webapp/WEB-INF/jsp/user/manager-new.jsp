<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="../pub/header.jsp" %>
<%@include file="../pub/top-menu.jsp" %>

<div class="row">
  <div class="large-12 columns">
    <h3>添加主管</h3>
  </div>
  <hr/>
</div>
<form action="create" method="POST">
  <div class="row ">
    <div class="large-6 columns">
      <label>登录账号: <input name="userName" type="text" required/></label>
    </div>
  </div>
  <div class="row ">
    <div class="large-6 columns">
      <label>用户姓名: <input name="realName" type="text" required/></label>
    </div>
  </div>
  <div class="row ">
    <div class="large-6 columns">
      <input type="submit" value="保存" class="button"/>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <a href="../managers" class="button">返回</a>
    </div>
  </div>
</form>

<%@include file="../pub/footer.jsp" %>