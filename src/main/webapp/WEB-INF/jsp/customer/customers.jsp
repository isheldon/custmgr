<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="../pub/header.jsp" %>
<%@include file="../pub/top-menu.jsp" %>

<script type="text/javascript">
jQuery(function(){
  $("#uploadCust").click(function(){
    if ($("#customerFile").val() == "") {
      window.alert("请选择数据文件");
      return false;
    }
  });
  
});
</script>

<div class="row">
  <div class="large-12 columns">
    <c:if test="${formAction == 'customers'}">
      <h3>客户管理</h3>
    </c:if>
    <c:if test="${formAction == 'selfcustomers'}">
      <h3>自有客户管理</h3>
    </c:if>
    <c:if test="${formAction == 'subcustomers'}">
      <h3>组员客户管理</h3>
    </c:if>
  </div>
  <hr/>
</div>

  <form:form id="customerForm" commandName="customer" action="${formAction}" method="POST">
    <div class="row">
      <div class="large-4 columns">
        <label>单位名称: <form:input path="orgName"/> </label>
      </div>
      <div class="large-4 columns">
        <label>联系人: <form:input path="contactName"/> </label>
      </div>
      <div class="large-4 columns">
        <label>电话: <form:input path="contactPhone"/> </label>
      </div>
    </div>
    <div class="row">
      <div class="large-4 columns">
        <label>联系状态: 
          <form:select path="contacted">
            <form:option value="" label="全部"/>
            <form:option value="0" label="未联系"/>
            <form:option value="1" label="已联系"/>
            <form:option value="2" label="未接通"/>
          </form:select>
        </label>
      </div>
      <div class="large-4 columns">
        <label>所属销售: <form:input path="userName"/> </label>
      </div>
      <div class="large-4 columns">
        <input type="submit" value="搜索" class="button"/>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <c:if test="${formAction != 'subcustomers'}">
          <a href="new" class="button">添加客户</a>
        </c:if>
      </div>
      <hr/>
    </div>
  </form:form>
  
  <c:if test="${formAction == 'customers'}">
  <form action="importCustomers" method="POST" enctype="multipart/form-data">
    <div class="row">
      <div class="large-4 columns">
        数据文件: <input type="file" name="customerFile" id="customerFile"/>
      </div>
      <div class="large-8 columns">
        <input type="submit" id="uploadCust" value="上传客户数据" class="button"/>
      </div>
    </div>
  </form>
  <hr/>
  </c:if>

  <div class="row">
    <table width="100%">
      <thead>
        <tr>
          <td>单位名称</td>
          <td>联系人姓名</td>
          <td>联系电话</td>
          <td>所属销售</td>
          <td>联系状态</td>
          <td>备注内容</td>
          <td>备注时间</td>
          <td>操作</td>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${customers}" var="customer">
        <tr>
          <td>${customer['orgName']}</td>
          <td>${customer['contactName']}</td>
          <td>${customer['contactPhone']}</td>
          <td>${customer['userName']}</td>
          <td>
            <c:if test="${customer['contacted'] == 0}">未联系</c:if> 
            <c:if test="${customer['contacted'] == 1}">已联系</c:if> 
            <c:if test="${customer['contacted'] == 2}">未接通</c:if> 
          </td>
          <td>${customer['lastMemo']}</td>
          <td>${customer['lastMemoTime']}</td>
          <td>
            <c:if test="${formAction == 'selfcustomers' || formAction == 'customers'}">
              <a href="edit/${customer['id']}">编辑</a>
              <a href="delete/${customer['id']}">删除</a>
            </c:if>
            <c:if test="${formAction != 'selfcustomers'}">
              <a href="memohistory/${customer['id']}">历史备注</a>
            </c:if>
            <c:if test="${formAction == 'selfcustomers'}">
              <a href="newMemo/${customer['id']}">添加备注</a>
            </c:if>
          </td>
        </tr>
        </c:forEach>
      </tbody> 
    </table>
  </div>

<%@include file="../pub/footer.jsp" %>
