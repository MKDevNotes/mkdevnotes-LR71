<%@ include file="/init.jsp"%>

<portlet:renderURL var="renderUrl">
	<portlet:param name="VIEW_PAGE" value="viewEmployeeList" />
</portlet:renderURL>

<c:choose>
      <c:when test="${not empty employeeDtl.empId}">
      	<portlet:actionURL name="updateEmployee" var="editEmployeeURL" /> edit
      </c:when>
  	  <c:otherwise>
  	  	<portlet:actionURL name="addEmployeeDetail" var="editEmployeeURL" /> add
      </c:otherwise>
</c:choose>
<div align="right">
	<input type="button" value="View EmployeeList"
		onClick="javascript:self.location='${renderUrl}'" />
</div>
<hr>
<div class="mkdev-container">
  <form action="${editEmployeeURL}" method="post">
	<input type="hidden" id="empId" name="<portlet:namespace/>empId" value="${employeeDtl.empId}">  
    <label for="firstName">First Name</label>
    <input type="text" id="firstName" name="<portlet:namespace/>firstName" placeholder="Your name.." value="${employeeDtl.firstName}">

    <label for="lastName">Last Name</label>
    <input type="text" id="lastName" name="<portlet:namespace/>lastName" placeholder="Your last name.." value="${employeeDtl.lastName}">

    <label for="email">Email</label>
    <input type="text" id="email" name="<portlet:namespace/>email" placeholder="Your Email.." value="${employeeDtl.email}">

	<label for="email">Age</label>
    <input type="text" id="age" name="<portlet:namespace/>age" placeholder="Your Age..." value="${employeeDtl.age}">

    <label for="address">Address</label> 	
    <textarea id="address" name="<portlet:namespace/>address" placeholder="Write something.." style="height:200px">${employeeDtl.address}</textarea>

	<label for="mobile">Mobile</label>
    <input type="text" id="mobile" name="<portlet:namespace/>mobile" placeholder="Your mobile..." value="${employeeDtl.mobile}">
    
    <input type="submit" value="Submit"> |  <input type="button" value="Cancel" onClick="javascript:self.location='${renderUrl}'">
  </form>
</div>