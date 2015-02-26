<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="pub/header.jsp" %>
<div class="row ">
	<div class="large-4 columns">
    <c:if test="${loginMsg == 1}">  
		  <div data-alert class="alert-box warning">
        用户名或密码错误
        <a href="#" class="close">&times;</a>
      </div>
		</c:if>
	  <c:if test="${loginMsg == 2}">  
	  	<div data-alert class="alert-box success">
		    您已退出
		    <a href="#" class="close">&times;</a>
		  </div>
		</c:if>
  </div>
</div>
<div class="row ">
  <div class="large-6 columns">
  	<h3>请登录</h3>
  	<div class="panel">
		  <form action="doLogin" method="POST">
		  	<label>用户名: 
		       <input name="userName" type="text"/>
		    </label>
		    <label>密码: 
		       <input name="password" type="password"/>
		    </label>
		   <input type="submit" value="登录" class="button"/>
		  </form>
    </div>
  </div>
</div>

<%@include file="pub/footer.jsp" %>