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

AUI Tag...
<hr>
<div class="mkdev-container">
		<aui:form name="fm" action="${editEmployeeURL}" method="post">
		<input type="hidden" id="empId" name="<portlet:namespace/>empId" value="${employeeDtl.empId}"> 
			<aui:fieldset-group markupView="lexicon">
				<aui:fieldset cssClass="mkdev-fieldset"  label="Personal Information">
					<aui:row>
						<aui:col width="50">
						 <aui:input name="firstName" type="text" value="${employeeDtl.firstName}" />
						</aui:col>
						<aui:col width="50">
						 <aui:input name="lastName" type="text" value="${employeeDtl.lastName}" />
						</aui:col>
					</aui:row>
						<aui:row>
						<aui:col width="50">
						 <aui:input name="gender" type="text" value="${employeeDtl.gender}" />
						</aui:col>
						<aui:col width="50">
						 <aui:input name="age" type="text" value="${employeeDtl.age}" />
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col width="50">
						<aui:input name="email" type="text" value="${employeeDtl.email}" />
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col width="100">
						<b>Gender</b>
						 <aui:input label="Male" name="gender" type="radio" value="0"/>
						 <aui:input label="Female" name="gender" type="radio" value="1"/>
						</aui:col>
					</aui:row>
				</aui:fieldset>
			</aui:fieldset-group>
			<aui:fieldset-group markupView="lexicon">
				<aui:fieldset cssClass="mkdev-fieldset"  label="Miscellaneous">
					<aui:input label="Hobbies" name="hobbies" type="textarea" />
					<aui:input label="Mobile number" name="mobile"	type="text" />
				</aui:fieldset>
			</aui:fieldset-group>
			<aui:button-row>
				<aui:row>
					<aui:col width="10">
						<aui:button name="submitButton" type="submit" value="Submit" />
					</aui:col>
					<aui:col width="10">
						<aui:button name="submitButton" type="button" value="Cancel" onClick="javascript:self.location='${renderUrl}'" />
					</aui:col>
				</aui:row>
			</aui:button-row>
		</aui:form>
</div>