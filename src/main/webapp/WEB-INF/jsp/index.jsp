<%@ page language="java" pageEncoding="utf-8"%>
<html>
<body>
  ${loginUser.userName} <br>
  ${loginUser.realName} <br>
  ${loginUser.role} <br>
  
   <a href="user/managers">主管管理</a>
   <a href="user/salespersons">用户管理</a>
   <a href="customer/customers">客户管理</a>
   <a href="customer/toAllocate">客户管理</a>
</body>
</html>
