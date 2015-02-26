<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="contain-to-grid sticky">
<nav class="top-bar" data-topbar role="navigation">
  <section class="top-bar-section">
    <!-- Left Nav Section -->
    <ul class="left">
      <c:if test="${loginUser.role == 'ADMIN'}">  
      <li><a href="<%= request.getContextPath()%>/user/managers">主管管理</a></li>
      <li><a href="<%= request.getContextPath()%>/user/salespersons">用户管理</a></li>
      <li><a href="<%= request.getContextPath()%>/customer/customers">客户管理</a></li>
      <li><a href="<%= request.getContextPath()%>/customer/toAllocate">客户分配</a></li>
      </c:if>
      
      <c:if test="${loginUser.role == 'MANAGER'}">
      <li><a href="<%= request.getContextPath()%>/customer/selfcustomers">自有客户管理</a></li>
      <li><a href="<%= request.getContextPath()%>/customer/subcustomers">组员客户管理</a></li>
      </c:if>
      <c:if test="${loginUser.role == 'SALES'}">
      <li><a href="<%= request.getContextPath()%>/customer/selfcustomers">自有客户管理</a></li>
      </c:if>
    </ul>
  </section>
  
  <!-- Right Nav Section -->
  <section class="top-bar-section">
    <ul class="right">
      <li class="has-dropdown">
        <a href="#">你好, ${loginUser.realName}</a>
        <ul class="dropdown">
          <li><a href="<%= request.getContextPath()%>/password">修改密码</a></li>
          <li><a href="<%= request.getContextPath()%>/logout">退出</a></li>
        </ul>
      </li>
    </ul>
  </section>
    
</nav>
</div>
<br/>
