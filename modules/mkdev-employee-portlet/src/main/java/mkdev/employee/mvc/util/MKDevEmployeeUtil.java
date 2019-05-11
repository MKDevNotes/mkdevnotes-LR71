package mkdev.employee.mvc.util;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;

import javax.portlet.ActionRequest;

import org.mkdev.employee.model.EmployeeDetail;
import org.mkdev.employee.service.EmployeeDetailLocalServiceUtil;

import mkdev.employee.mvc.constants.MKDevEmployeeControllerPortletKeys;

public class MKDevEmployeeUtil {

	public static EmployeeDetail employeeFormRequest(ActionRequest actionRequest) throws PortalException {

		Long empId = ParamUtil.getLong(actionRequest, MKDevEmployeeControllerPortletKeys.EMPLOYEE_ID, 0l);
		EmployeeDetail employeeDtl;

		if (Validator.isNotNull(empId) && empId > 0) {
			employeeDtl = EmployeeDetailLocalServiceUtil.getEmployeeDetail(empId);

		} else {
			employeeDtl = EmployeeDetailLocalServiceUtil
					.createEmployeeDetail(CounterLocalServiceUtil.increment(EmployeeDetail.class.getName()));
			employeeDtl.setCompanyId(PortalUtil.getCompanyId(actionRequest));
			try {
				employeeDtl.setGroupId(
						GroupLocalServiceUtil.getCompanyGroup(PortalUtil.getDefaultCompanyId()).getGroupId());
			} catch (PortalException e) {
				e.printStackTrace();
			}
			employeeDtl.setUserId(PortalUtil.getUserId(actionRequest));
			employeeDtl.setCreateDate(new Date());
		}

		employeeDtl.setModifiedDate(new Date());
		employeeDtl.setFirstName(ParamUtil.getString(actionRequest, MKDevEmployeeControllerPortletKeys.FIRST_NAME));
		employeeDtl.setLastName(ParamUtil.getString(actionRequest, MKDevEmployeeControllerPortletKeys.LAST_NAME));
		employeeDtl.setAge(ParamUtil.getInteger(actionRequest, MKDevEmployeeControllerPortletKeys.AGE));
		employeeDtl.setGender(ParamUtil.getInteger(actionRequest, MKDevEmployeeControllerPortletKeys.GENDER,0));
		employeeDtl.setEmail(ParamUtil.getString(actionRequest, MKDevEmployeeControllerPortletKeys.EMAIL));
		employeeDtl.setAddress(ParamUtil.getString(actionRequest, MKDevEmployeeControllerPortletKeys.ADDRESS));
		employeeDtl.setMobile(ParamUtil.getString(actionRequest, MKDevEmployeeControllerPortletKeys.MOBILE));

		return employeeDtl;
	}
}
