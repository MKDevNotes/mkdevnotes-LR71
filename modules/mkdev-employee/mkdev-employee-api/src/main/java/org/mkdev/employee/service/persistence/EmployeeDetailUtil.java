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

package org.mkdev.employee.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.mkdev.employee.model.EmployeeDetail;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the employee detail service. This utility wraps {@link org.mkdev.employee.service.persistence.impl.EmployeeDetailPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetailPersistence
 * @see org.mkdev.employee.service.persistence.impl.EmployeeDetailPersistenceImpl
 * @generated
 */
@ProviderType
public class EmployeeDetailUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(EmployeeDetail employeeDetail) {
		getPersistence().clearCache(employeeDetail);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeDetail> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeDetail update(EmployeeDetail employeeDetail) {
		return getPersistence().update(employeeDetail);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeDetail update(EmployeeDetail employeeDetail,
		ServiceContext serviceContext) {
		return getPersistence().update(employeeDetail, serviceContext);
	}

	/**
	* Returns all the employee details where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching employee details
	*/
	public static List<EmployeeDetail> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the employee details where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of employee details
	* @param end the upper bound of the range of employee details (not inclusive)
	* @return the range of matching employee details
	*/
	public static List<EmployeeDetail> findByUuid(String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the employee details where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of employee details
	* @param end the upper bound of the range of employee details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching employee details
	*/
	public static List<EmployeeDetail> findByUuid(String uuid, int start,
		int end, OrderByComparator<EmployeeDetail> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the employee details where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of employee details
	* @param end the upper bound of the range of employee details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching employee details
	*/
	public static List<EmployeeDetail> findByUuid(String uuid, int start,
		int end, OrderByComparator<EmployeeDetail> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first employee detail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching employee detail
	* @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	*/
	public static EmployeeDetail findByUuid_First(String uuid,
		OrderByComparator<EmployeeDetail> orderByComparator)
		throws org.mkdev.employee.exception.NoSuchEmployeeDetailException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first employee detail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching employee detail, or <code>null</code> if a matching employee detail could not be found
	*/
	public static EmployeeDetail fetchByUuid_First(String uuid,
		OrderByComparator<EmployeeDetail> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last employee detail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching employee detail
	* @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	*/
	public static EmployeeDetail findByUuid_Last(String uuid,
		OrderByComparator<EmployeeDetail> orderByComparator)
		throws org.mkdev.employee.exception.NoSuchEmployeeDetailException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last employee detail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching employee detail, or <code>null</code> if a matching employee detail could not be found
	*/
	public static EmployeeDetail fetchByUuid_Last(String uuid,
		OrderByComparator<EmployeeDetail> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the employee details before and after the current employee detail in the ordered set where uuid = &#63;.
	*
	* @param empId the primary key of the current employee detail
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next employee detail
	* @throws NoSuchEmployeeDetailException if a employee detail with the primary key could not be found
	*/
	public static EmployeeDetail[] findByUuid_PrevAndNext(long empId,
		String uuid, OrderByComparator<EmployeeDetail> orderByComparator)
		throws org.mkdev.employee.exception.NoSuchEmployeeDetailException {
		return getPersistence()
				   .findByUuid_PrevAndNext(empId, uuid, orderByComparator);
	}

	/**
	* Removes all the employee details where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of employee details where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching employee details
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the employee detail where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchEmployeeDetailException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching employee detail
	* @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	*/
	public static EmployeeDetail findByUUID_G(String uuid, long groupId)
		throws org.mkdev.employee.exception.NoSuchEmployeeDetailException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the employee detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching employee detail, or <code>null</code> if a matching employee detail could not be found
	*/
	public static EmployeeDetail fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the employee detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching employee detail, or <code>null</code> if a matching employee detail could not be found
	*/
	public static EmployeeDetail fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the employee detail where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the employee detail that was removed
	*/
	public static EmployeeDetail removeByUUID_G(String uuid, long groupId)
		throws org.mkdev.employee.exception.NoSuchEmployeeDetailException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of employee details where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching employee details
	*/
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the employee details where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching employee details
	*/
	public static List<EmployeeDetail> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the employee details where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of employee details
	* @param end the upper bound of the range of employee details (not inclusive)
	* @return the range of matching employee details
	*/
	public static List<EmployeeDetail> findByUuid_C(String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the employee details where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of employee details
	* @param end the upper bound of the range of employee details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching employee details
	*/
	public static List<EmployeeDetail> findByUuid_C(String uuid,
		long companyId, int start, int end,
		OrderByComparator<EmployeeDetail> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the employee details where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of employee details
	* @param end the upper bound of the range of employee details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching employee details
	*/
	public static List<EmployeeDetail> findByUuid_C(String uuid,
		long companyId, int start, int end,
		OrderByComparator<EmployeeDetail> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first employee detail in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching employee detail
	* @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	*/
	public static EmployeeDetail findByUuid_C_First(String uuid,
		long companyId, OrderByComparator<EmployeeDetail> orderByComparator)
		throws org.mkdev.employee.exception.NoSuchEmployeeDetailException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first employee detail in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching employee detail, or <code>null</code> if a matching employee detail could not be found
	*/
	public static EmployeeDetail fetchByUuid_C_First(String uuid,
		long companyId, OrderByComparator<EmployeeDetail> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last employee detail in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching employee detail
	* @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	*/
	public static EmployeeDetail findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<EmployeeDetail> orderByComparator)
		throws org.mkdev.employee.exception.NoSuchEmployeeDetailException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last employee detail in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching employee detail, or <code>null</code> if a matching employee detail could not be found
	*/
	public static EmployeeDetail fetchByUuid_C_Last(String uuid,
		long companyId, OrderByComparator<EmployeeDetail> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the employee details before and after the current employee detail in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param empId the primary key of the current employee detail
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next employee detail
	* @throws NoSuchEmployeeDetailException if a employee detail with the primary key could not be found
	*/
	public static EmployeeDetail[] findByUuid_C_PrevAndNext(long empId,
		String uuid, long companyId,
		OrderByComparator<EmployeeDetail> orderByComparator)
		throws org.mkdev.employee.exception.NoSuchEmployeeDetailException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(empId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the employee details where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of employee details where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching employee details
	*/
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns the employee detail where empId = &#63; or throws a {@link NoSuchEmployeeDetailException} if it could not be found.
	*
	* @param empId the emp ID
	* @return the matching employee detail
	* @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	*/
	public static EmployeeDetail findByEmployeeId(long empId)
		throws org.mkdev.employee.exception.NoSuchEmployeeDetailException {
		return getPersistence().findByEmployeeId(empId);
	}

	/**
	* Returns the employee detail where empId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param empId the emp ID
	* @return the matching employee detail, or <code>null</code> if a matching employee detail could not be found
	*/
	public static EmployeeDetail fetchByEmployeeId(long empId) {
		return getPersistence().fetchByEmployeeId(empId);
	}

	/**
	* Returns the employee detail where empId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param empId the emp ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching employee detail, or <code>null</code> if a matching employee detail could not be found
	*/
	public static EmployeeDetail fetchByEmployeeId(long empId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByEmployeeId(empId, retrieveFromCache);
	}

	/**
	* Removes the employee detail where empId = &#63; from the database.
	*
	* @param empId the emp ID
	* @return the employee detail that was removed
	*/
	public static EmployeeDetail removeByEmployeeId(long empId)
		throws org.mkdev.employee.exception.NoSuchEmployeeDetailException {
		return getPersistence().removeByEmployeeId(empId);
	}

	/**
	* Returns the number of employee details where empId = &#63;.
	*
	* @param empId the emp ID
	* @return the number of matching employee details
	*/
	public static int countByEmployeeId(long empId) {
		return getPersistence().countByEmployeeId(empId);
	}

	/**
	* Returns the employee detail where firstName = &#63; and email = &#63; or throws a {@link NoSuchEmployeeDetailException} if it could not be found.
	*
	* @param firstName the first name
	* @param email the email
	* @return the matching employee detail
	* @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	*/
	public static EmployeeDetail findByUserEmail(String firstName, String email)
		throws org.mkdev.employee.exception.NoSuchEmployeeDetailException {
		return getPersistence().findByUserEmail(firstName, email);
	}

	/**
	* Returns the employee detail where firstName = &#63; and email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param firstName the first name
	* @param email the email
	* @return the matching employee detail, or <code>null</code> if a matching employee detail could not be found
	*/
	public static EmployeeDetail fetchByUserEmail(String firstName, String email) {
		return getPersistence().fetchByUserEmail(firstName, email);
	}

	/**
	* Returns the employee detail where firstName = &#63; and email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param firstName the first name
	* @param email the email
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching employee detail, or <code>null</code> if a matching employee detail could not be found
	*/
	public static EmployeeDetail fetchByUserEmail(String firstName,
		String email, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByUserEmail(firstName, email, retrieveFromCache);
	}

	/**
	* Removes the employee detail where firstName = &#63; and email = &#63; from the database.
	*
	* @param firstName the first name
	* @param email the email
	* @return the employee detail that was removed
	*/
	public static EmployeeDetail removeByUserEmail(String firstName,
		String email)
		throws org.mkdev.employee.exception.NoSuchEmployeeDetailException {
		return getPersistence().removeByUserEmail(firstName, email);
	}

	/**
	* Returns the number of employee details where firstName = &#63; and email = &#63;.
	*
	* @param firstName the first name
	* @param email the email
	* @return the number of matching employee details
	*/
	public static int countByUserEmail(String firstName, String email) {
		return getPersistence().countByUserEmail(firstName, email);
	}

	/**
	* Caches the employee detail in the entity cache if it is enabled.
	*
	* @param employeeDetail the employee detail
	*/
	public static void cacheResult(EmployeeDetail employeeDetail) {
		getPersistence().cacheResult(employeeDetail);
	}

	/**
	* Caches the employee details in the entity cache if it is enabled.
	*
	* @param employeeDetails the employee details
	*/
	public static void cacheResult(List<EmployeeDetail> employeeDetails) {
		getPersistence().cacheResult(employeeDetails);
	}

	/**
	* Creates a new employee detail with the primary key. Does not add the employee detail to the database.
	*
	* @param empId the primary key for the new employee detail
	* @return the new employee detail
	*/
	public static EmployeeDetail create(long empId) {
		return getPersistence().create(empId);
	}

	/**
	* Removes the employee detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empId the primary key of the employee detail
	* @return the employee detail that was removed
	* @throws NoSuchEmployeeDetailException if a employee detail with the primary key could not be found
	*/
	public static EmployeeDetail remove(long empId)
		throws org.mkdev.employee.exception.NoSuchEmployeeDetailException {
		return getPersistence().remove(empId);
	}

	public static EmployeeDetail updateImpl(EmployeeDetail employeeDetail) {
		return getPersistence().updateImpl(employeeDetail);
	}

	/**
	* Returns the employee detail with the primary key or throws a {@link NoSuchEmployeeDetailException} if it could not be found.
	*
	* @param empId the primary key of the employee detail
	* @return the employee detail
	* @throws NoSuchEmployeeDetailException if a employee detail with the primary key could not be found
	*/
	public static EmployeeDetail findByPrimaryKey(long empId)
		throws org.mkdev.employee.exception.NoSuchEmployeeDetailException {
		return getPersistence().findByPrimaryKey(empId);
	}

	/**
	* Returns the employee detail with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param empId the primary key of the employee detail
	* @return the employee detail, or <code>null</code> if a employee detail with the primary key could not be found
	*/
	public static EmployeeDetail fetchByPrimaryKey(long empId) {
		return getPersistence().fetchByPrimaryKey(empId);
	}

	public static java.util.Map<java.io.Serializable, EmployeeDetail> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the employee details.
	*
	* @return the employee details
	*/
	public static List<EmployeeDetail> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the employee details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employee details
	* @param end the upper bound of the range of employee details (not inclusive)
	* @return the range of employee details
	*/
	public static List<EmployeeDetail> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the employee details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employee details
	* @param end the upper bound of the range of employee details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of employee details
	*/
	public static List<EmployeeDetail> findAll(int start, int end,
		OrderByComparator<EmployeeDetail> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the employee details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employee details
	* @param end the upper bound of the range of employee details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of employee details
	*/
	public static List<EmployeeDetail> findAll(int start, int end,
		OrderByComparator<EmployeeDetail> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the employee details from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of employee details.
	*
	* @return the number of employee details
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static EmployeeDetailPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EmployeeDetailPersistence, EmployeeDetailPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EmployeeDetailPersistence.class);

		ServiceTracker<EmployeeDetailPersistence, EmployeeDetailPersistence> serviceTracker =
			new ServiceTracker<EmployeeDetailPersistence, EmployeeDetailPersistence>(bundle.getBundleContext(),
				EmployeeDetailPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}