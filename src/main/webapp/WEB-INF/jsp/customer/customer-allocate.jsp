<%@page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../pub/header.jsp" %>
<%@include file="../pub/top-menu.jsp" %>
<script type="text/javascript">
jQuery(function(){
  $("#allocatesales").click(function(){
    if ($(":checkbox:checked").length == 0) {
      window.alert("请至少选择一个客户");
      return false;
    }
  });
});
</script>

<div class="row">
  <div class="large-12 columns">
    <h3>客户分配</h3>
  </div>
  <hr/>
</div>

  <form name="searchForm" action="toAllocate" method="POST">
    <div class="row">
      <div class="large-3 columns">
        <select name="allocation">
          <option value="ALL" <c:if test="${allocation == 'ALL'}">selected</c:if>>全部</option>
          <option value="YES" <c:if test="${allocation == 'YES'}">selected</c:if>>已分配</option>
          <option value="NO" <c:if test="${allocation == 'NO'}">selected</c:if>>未分配</option>
        </select>
      </div>
      <div class="large-9 columns">
        <input type="submit" value="搜索" class="button small"/>
      </div>
    </div>
  </form>

  <form name="allocationForm" action="allocate" method="POST">
    <div class="row">
      <div class="large-3 columns">
        <select name="userId" required>
          <option value="">------请选择销售人员------</option>
          <c:forEach items="${users}" var="user">
          <option value="${user['id']}">${user['realName']}</option>
          </c:forEach>
        </select>
      </div>
      <div class="large-9 columns">
        <input id="allocatesales" type="submit" value="分配" class="button small"/>
      </div>
    </div> 
    <div class="row">
      <table width="100%">
        <thead>
          <tr>
            <td>全选</td>
            <td>单位名称</td>
            <td>联系人姓名</td>
            <td>联系电话</td>
            <td>所属销售</td>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${customers}" var="customer">
          <tr>
            <td>
              <input type="checkbox" name="customerId" value="${customer['id']}"/>
            </td>
            <td>${customer['orgName']}</td>
            <td>${customer['contactName']}</td>
            <td>${customer['contactPhone']}</td>
            <td>${customer['userName']}</td>
          </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </form>
<%@include file="../pub/footer.jsp" %>