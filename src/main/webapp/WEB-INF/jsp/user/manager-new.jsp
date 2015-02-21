<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" pageEncoding="utf-8"%>

<html>
<head>
<title>新建主管</title>
</head>

<body>
  <form action="create" method="POST">
      登录账号: <input name="userName" type="text"/>
   <br/>
      用户姓名: <input name="realName" type="text"/>
   <br/>
   <input type="submit" value="保存" />
   <a href="../managers">返回</a>
  </form>
</body>
</html>