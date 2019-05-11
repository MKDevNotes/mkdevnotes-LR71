/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.mkdev.employee.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmployeeDetailLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetailLocalService
 * @generated
 */
@ProviderType
public class EmployeeDetailLocalServiceWrapper
	implements EmployeeDetailLocalService,
		ServiceWrapper<EmployeeDetailLocalService> {
	public EmployeeDetailLocalServiceWrapper(
		EmployeeDetailLocalService employeeDetailLocalService) {
		_employeeDetailLocalService = employeeDetailLocalService;
	}

	/**
	* Adds the employee detail to the database. Also notifies the appropriate model listeners.
	*
	* @param employeeDetail the employee detail
	* @return the employee detail that was added
	*/
	@Override
	public org.mkdev.employee.model.EmployeeDetail addEmployeeDetail(
		org.mkdev.employee.model.EmployeeDetail employeeDetail) {
		return _employeeDetailLocalService.addEmployeeDetail(employeeDetail);
	}

	/**
	* Creates a new employee detail with the primary key. Does not add the employee detail to the database.
	*
	* @param empId the primary key for the new employee detail
	* @return the new employee detail
	*/
	@Override
	public org.mkdev.employee.model.EmployeeDetail createEmployeeDetail(
		long empId) {
		return _employeeDetailLocalService.createEmployeeDetail(empId);
	}

	/**
	* Deletes the employee detail from the database. Also notifies the appropriate model listeners.
	*
	* @param employeeDetail the employee detail
	* @return the employee detail that was removed
	*/
	@Override
	public org.mkdev.employee.model.EmployeeDetail deleteEmployeeDetail(
		org.mkdev.employee.model.EmployeeDetail employeeDetail) {
		return _employeeDetailLocalService.deleteEmployeeDetail(employeeDetail);
	}

	/**
	* Deletes the employee detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empId the primary key of the employee detail
	* @return the employee detail that was removed
	* @throws PortalException if a employee detail with the primary key could not be found
	*/
	@Override
	public org.mkdev.employee.model.EmployeeDetail deleteEmployeeDetail(
		long empId) throws com.liferay.portal.kernel.exception.PortalException {
		return _employeeDetailLocalService.deleteEmployeeDetail(empId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _employeeDetailLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeDetailLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _employeeDetailLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.mkdev.employee.model.impl.EmployeeDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _employeeDetailLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.mkdev.employee.model.impl.EmployeeDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _employeeDetailLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _employeeDetailLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _employeeDetailLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.mkdev.employee.model.EmployeeDetail fetchEmployeeDetail(
		long empId) {
		return _employeeDetailLocalService.fetchEmployeeDetail(empId);
	}

	/**
	* Returns the employee detail matching the UUID and group.
	*
	* @param uuid the employee detail's UUID
	* @param groupId the primary key of the group
	* @return the matching employee detail, or <code>null</code> if a matching employee detail could not be found
	*/
	@Override
	public org.mkdev.employee.model.EmployeeDetail fetchEmployeeDetailByUuidAndGroupId(
		String uuid, long groupId) {
		return _employeeDetailLocalService.fetchEmployeeDetailByUuidAndGroupId(uuid,
			groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _employeeDetailLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the employee detail with the primary key.
	*
	* @param empId the primary key of the employee detail
	* @return the employee detail
	* @throws PortalException if a employee detail with the primary key could not be found
	*/
	@Override
	public org.mkdev.employee.model.EmployeeDetail getEmployeeDetail(long empId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _employeeDetailLocalService.getEmployeeDetail(empId);
	}

	/**
	* Returns the employee detail matching the UUID and group.
	*
	* @param uuid the employee detail's UUID
	* @param groupId the primary key of the group
	* @return the matching employee detail
	* @throws PortalException if a matching employee detail could not be found
	*/
	@Override
	public org.mkdev.employee.model.EmployeeDetail getEmployeeDetailByUuidAndGroupId(
		String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _employeeDetailLocalService.getEmployeeDetailByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the employee details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.mkdev.employee.model.impl.EmployeeDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employee details
	* @param end the upper bound of the range of employee details (not inclusive)
	* @return the range of employee details
	*/
	@Override
	public java.util.List<org.mkdev.employee.model.EmployeeDetail> getEmployeeDetails(
		int start, int end) {
		return _employeeDetailLocalService.getEmployeeDetails(start, end);
	}

	/**
	* Returns all the employee details matching the UUID and company.
	*
	* @param uuid the UUID of the employee details
	* @param companyId the primary key of the company
	* @return the matching employee details, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<org.mkdev.employee.model.EmployeeDetail> getEmployeeDetailsByUuidAndCompanyId(
		String uuid, long companyId) {
		return _employeeDetailLocalService.getEmployeeDetailsByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of employee details matching the UUID and company.
	*
	* @param uuid the UUID of the employee details
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of employee details
	* @param end the upper bound of the range of employee details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching employee details, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<org.mkdev.employee.model.EmployeeDetail> getEmployeeDetailsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<org.mkdev.employee.model.EmployeeDetail> orderByComparator) {
		return _employeeDetailLocalService.getEmployeeDetailsByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of employee details.
	*
	* @return the number of employee details
	*/
	@Override
	public int getEmployeeDetailsCount() {
		return _employeeDetailLocalService.getEmployeeDetailsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _employeeDetailLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _employeeDetailLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeDetailLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _employeeDetailLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the employee detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param employeeDetail the employee detail
	* @return the employee detail that was updated
	*/
	@Override
	public org.mkdev.employee.model.EmployeeDetail updateEmployeeDetail(
		org.mkdev.employee.model.EmployeeDetail employeeDetail) {
		return _employeeDetailLocalService.updateEmployeeDetail(employeeDetail);
	}

	@Override
	public EmployeeDetailLocalService getWrappedService() {
		return _employeeDetailLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeDetailLocalService employeeDetailLocalService) {
		_employeeDetailLocalService = employeeDetailLocalService;
	}

	private EmployeeDetailLocalService _employeeDetailLocalService;
}