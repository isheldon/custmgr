<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
  <c:if test="${loginUser.role == 'ADMIN'}">  
  location.href = "<%= request.getContextPath()%>/customer/customers";
  </c:if>

  <c:if test="${loginUser.role == 'MANAGER'}">  
  location.href = "<%= request.getContextPath()%>/customer/selfcustomers";
  </c:if>

  <c:if test="${loginUser.role == 'SALES'}">  
  location.href = "<%= request.getContextPath()%>/customer/selfcustomers";
  </c:if>
</script>