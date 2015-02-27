<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../pub/header.jsp" %>
<%@include file="../pub/top-menu.jsp" %>

<div class="row">
  <div class="large-12 columns">
    <h3>添加备注</h3>
  </div>
  <hr/>
</div>

<div class="row">
  <div class="large-6 columns">
    <form action="../createMemo" method="POST">
      <input type="hidden" name="customerId" value="${customer.id}"/>
      联系状态:
      <select name="contacted">
        <option value="0" <c:if test="${customer.contacted == 0}">selected</c:if>>未联系</option>
        <option value="1" <c:if test="${customer.contacted == 1}">selected</c:if>>已联系</option>
        <option value="2" <c:if test="${customer.contacted == 2}">selected</c:if>>未接通</option>
      </select>
      <br/>
      文字描述:
      <textarea name="memo" rows="5" cols="20"></textarea>
      <br/>
  
      <input type="submit" value="保存" class="button"/>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <a href="../selfcustomers" class="button">返回</a>
    </form>
  </div>

  <div class="large-6 columns">
    <span>历史备注:</span>
    <table width="100%">
      <thead>
        <tr>
          <td>日期</td>
          <td>备注内容</td>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${memos}" var="memo">
        <tr>
          <td>${memo['memoTime']}</td>
          <td>${memo['memo']}</td>
        </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>

</div>

<%@include file="../pub/footer.jsp" %>