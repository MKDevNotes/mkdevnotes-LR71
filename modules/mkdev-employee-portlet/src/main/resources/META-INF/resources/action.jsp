<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="mkdev.employee.mvc.constants.MKDevEmployeeControllerPortletKeys"%>
<%@ include file="/init.jsp"%>
<%@page import="org.mkdev.employee.model.EmployeeDetail"%>

<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<%
	ResultRow row = (ResultRow) request
			.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

EmployeeDetail employeeDtl = (EmployeeDetail) row.getObject();
%>

<liferay-ui:icon-menu>
	<portlet:actionURL name="deleteEmployee" var="deleteURL">
		<portlet:param name="empId"
			value="<%=String.valueOf(employeeDtl.getEmpId())%>" />
	</portlet:actionURL>
	<portlet:actionURL name="viewEditEmployee" var="viewEmployeeURL">
		<portlet:param name="empId"
			value="<%=String.valueOf(employeeDtl.getEmpId())%>" />
	</portlet:actionURL>
	<portlet:actionURL name="viewEditEmployee" var="editEmployeeURL">
		<portlet:param name="empId"	value="<%=String.valueOf(employeeDtl.getEmpId())%>" />
	</portlet:actionURL>
	<liferay-ui:icon image="view" message="View" url="<%=viewEmployeeURL.toString()%>" />
	<liferay-ui:icon image="view" message="Edit" url="<%=editEmployeeURL.toString()%>" />
	<liferay-ui:icon-delete image="delete" message="Delete" url="<%=deleteURL.toString()%>" />

</liferay-ui:icon-menu>
