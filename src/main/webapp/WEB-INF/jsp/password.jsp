<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="pub/header.jsp" %>
<%@include file="pub/top-menu.jsp" %>

<script type="text/javascript">
jQuery(function(){
  $("#pwdsubmit").click(function(){
    var pwd = $("#pwd").val();
    var repwd = $("#repwd").val();
    if (pwd != repwd) {
      window.alert("两次输入的密码不一致，请修改");
      return false;
    }
  });
});
</script>

<div class="row ">
	<div class="large-4 columns">
	  <c:if test="${pwdMsg == 1}">
	  	<div data-alert class="alert-box success">
		    密码已修改
		    <a href="#" class="close">&times;</a>
		  </div>
		</c:if>
  </div>
</div>

<div class="row ">
  <div class="large-6 columns">
  	<div class="panel">
      <form action="chgpwd" method="POST">
  	    <label>密码:
         <input id="pwd" name="password" type="password" required/>
        </label>
        <label>确认密码:
   	      <input id="repwd" name="repassword" type="password" required/>
        </label>
       <input id="pwdsubmit" type="submit" value="确定"  class="button"/>
      </form>
    </div>
  </div>
</div>

<%@include file="pub/footer.jsp" %>