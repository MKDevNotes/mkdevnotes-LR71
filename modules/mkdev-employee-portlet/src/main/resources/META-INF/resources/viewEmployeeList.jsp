<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="org.mkdev.employee.model.EmployeeDetail"%>
<%@page import="java.util.List"%>
<%@page import="org.mkdev.employee.service.EmployeeDetailLocalServiceUtil"%>
<%@page import="javax.portlet.WindowState"%>
<%@ include file="/init.jsp"%>

<p>
	<b><liferay-ui:message key="mkdevbasic.caption" /></b>
</p>

 <%  List<EmployeeDetail> employeeDtlList = EmployeeDetailLocalServiceUtil.getEmployeeDetails(-1, -1);  %>
<div align="left">
EmployeeList Page
</div>
<div align="right">
	<input type="button" value="New Employee" onClick="javascript:self.location='<portlet:renderURL><portlet:param name="VIEW_PAGE" value="editEmployee"/></portlet:renderURL>'" />
</div>
<liferay-ui:success key="added-employee" message="Employee Added Successfully"/>
<liferay-ui:success key="deleted-employee" message="Employee Deleted Successfully"/>
<liferay-ui:success key="updated-employee" message="Employee Updated Successfully"/>

<liferay-ui:search-container delta="2" emptyResultsMessage="No Employee Found!!">
    <liferay-ui:search-container-results  results="<%= ListUtil.subList(employeeDtlList, -1, -1) %>" />
    <liferay-ui:search-container-row className="org.mkdev.employee.model.EmployeeDetail" keyProperty="empId" modelVar="employeeDtl">
        <liferay-ui:search-container-column-text name="FirstName" value="${employeeDtl.firstName}" />
        <liferay-ui:search-container-column-text name="LastName" value="${employeeDtl.lastName}" />
        <liferay-ui:search-container-column-text name="Email" value="${employeeDtl.email}" />
        <liferay-ui:search-container-column-text name="Age" value="${employeeDtl.age}" />
        <liferay-ui:search-container-column-text name="Mobile" value="${employeeDtl.mobile}" />
     	<liferay-ui:search-container-column-jsp path="/action.jsp" align="right" /> 
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator />
</liferay-ui:search-container>