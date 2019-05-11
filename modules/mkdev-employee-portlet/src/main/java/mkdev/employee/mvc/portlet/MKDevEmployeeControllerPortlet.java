package mkdev.employee.mvc.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.mkdev.employee.model.EmployeeDetail;
import org.mkdev.employee.service.EmployeeDetailLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

import mkdev.employee.mvc.constants.MKDevEmployeeControllerPortletKeys;
import mkdev.employee.mvc.util.MKDevEmployeeUtil;

/**
 * @author Muthukumar
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=MKDevNotes",
		"com.liferay.portlet.instanceable=true", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + MKDevEmployeeControllerPortletKeys.MKDevEmployeeController,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class MKDevEmployeeControllerPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
	 	String pageName = (String) renderRequest.getAttribute("VIEW_PAGE")== null ? (String) renderRequest.getParameter("VIEW_PAGE") : (String) renderRequest.getAttribute("VIEW_PAGE") ;
		System.out.println("Page Name " + pageName);

		if (Validator.isNotNull(pageName)) {
			if (pageName.equalsIgnoreCase("viewEmployeeList")) {
				include("/viewEmployeeList.jsp", renderRequest, renderResponse);
			} else if (pageName.equalsIgnoreCase("editEmployee")) {
				include("/editEmployeeDetail.jsp", renderRequest, renderResponse);
			}
		} else {
			include("/viewEmployeeList.jsp", renderRequest, renderResponse);
		}

	}

	@ProcessAction(name = "addEmployeeDetail")
	public void addEmployeeDetail(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException {
		System.out.println("Hello AddEmployeeDetail");
		EmployeeDetail employeeDetail = MKDevEmployeeUtil.employeeFormRequest(actionRequest);

		System.out.println("Firstr Name " + employeeDetail.getFirstName());
		System.out.println("Last Name " + employeeDetail.getLastName());
		System.out.println("Age " + employeeDetail.getAge());
		System.out.println("Email " + employeeDetail.getEmail());
		System.out.println("Address " + employeeDetail.getFirstName());

		EmployeeDetailLocalServiceUtil.addEmployeeDetail(employeeDetail);
		SessionMessages.add(actionRequest, "added-book");
		_log.info("#################Added Book Successfully#########################");
	}

	@ProcessAction(name = "viewEditEmployee")
	public void editEmployeeDetail(ActionRequest actionRequest, ActionResponse actionResponse)
			throws SystemException, IOException, PortletException, PortalException {

		Long empId = ParamUtil.getLong(actionRequest, MKDevEmployeeControllerPortletKeys.EMPLOYEE_ID);

		EmployeeDetail employeeDetail = EmployeeDetailLocalServiceUtil.getEmployeeDetail(empId);
		
		actionRequest.setAttribute("employeeDtl", employeeDetail);
		
		actionResponse.setRenderParameter("VIEW_PAGE", "editEmployee");

	}
	
	
	@ProcessAction(name = "updateEmployee")
	public void updateEmployeeDetail(ActionRequest actionRequest, ActionResponse actionResponse)
			throws SystemException, IOException, PortletException, PortalException {

		EmployeeDetail employeeDetail = MKDevEmployeeUtil.employeeFormRequest(actionRequest);
		EmployeeDetailLocalServiceUtil.updateEmployeeDetail(employeeDetail);
		SessionMessages.add(actionRequest, "updated-employee");
		_log.info("#################Updated Employee Successfully#########################");
	}
	
	@ProcessAction(name = "deleteEmployee")
	public void deleteEmployeeDetail(ActionRequest actionRequest, ActionResponse actionResponse)
			throws SystemException, IOException, PortalException {
		
		Long empId = ParamUtil.getLong(actionRequest, MKDevEmployeeControllerPortletKeys.EMPLOYEE_ID);
		
		if(Validator.isNotNull(empId) && empId > 0) {
			EmployeeDetailLocalServiceUtil.deleteEmployeeDetail(empId);
		} 
	
		System.out.println("-------------deleteEmployee ------------------------>>>>>>");
	}
	private Log _log = LogFactoryUtil.getLog(MKDevEmployeeControllerPortlet.class);

}