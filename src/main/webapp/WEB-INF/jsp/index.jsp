<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
  ${loginUser.userName} <br>
  ${loginUser.realName} <br>
  ${loginUser.role} <br>

  <a href="<%= request.getContextPath()%>/password">修改密码</a>
  
  <c:if test="${loginUser.role == 'ADMIN'}">  
  <a href="user/managers">主管管理</a>
  <a href="user/salespersons">用户管理</a>
  <a href="customer/customers">客户管理</a>
  <a href="customer/toAllocate">客户分配</a>
  </c:if>

  <c:if test="${loginUser.role == 'MANAGER'}">  
  <a href="customer/selfcustomers">自有客户管理</a>
  <a href="customer/subcustomers">组员客户管理</a>
  </c:if>

  <c:if test="${loginUser.role == 'SALES'}">  
  <a href="customer/selfcustomers">客户管理</a>
  </c:if>

</body>
</html>
