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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.mkdev.employee.exception.NoSuchEmployeeDetailException;
import org.mkdev.employee.model.EmployeeDetail;

/**
 * The persistence interface for the employee detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see org.mkdev.employee.service.persistence.impl.EmployeeDetailPersistenceImpl
 * @see EmployeeDetailUtil
 * @generated
 */
@ProviderType
public interface EmployeeDetailPersistence extends BasePersistence<EmployeeDetail> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeDetailUtil} to access the employee detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the employee details where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching employee details
	*/
	public java.util.List<EmployeeDetail> findByUuid(String uuid);

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
	public java.util.List<EmployeeDetail> findByUuid(String uuid, int start,
		int end);

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
	public java.util.List<EmployeeDetail> findByUuid(String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail> orderByComparator);

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
	public java.util.List<EmployeeDetail> findByUuid(String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first employee detail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching employee detail
	* @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	*/
	public EmployeeDetail findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail> orderByComparator)
		throws NoSuchEmployeeDetailException;

	/**
	* Returns the first employee detail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching employee detail, or <code>null</code> if a matching employee detail could not be found
	*/
	public EmployeeDetail fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail> orderByComparator);

	/**
	* Returns the last employee detail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching employee detail
	* @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	*/
	public EmployeeDetail findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail> orderByComparator)
		throws NoSuchEmployeeDetailException;

	/**
	* Returns the last employee detail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching employee detail, or <code>null</code> if a matching employee detail could not be found
	*/
	public EmployeeDetail fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail> orderByComparator);

	/**
	* Returns the employee details before and after the current employee detail in the ordered set where uuid = &#63;.
	*
	* @param empId the primary key of the current employee detail
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next employee detail
	* @throws NoSuchEmployeeDetailException if a employee detail with the primary key could not be found
	*/
	public EmployeeDetail[] findByUuid_PrevAndNext(long empId, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail> orderByComparator)
		throws NoSuchEmployeeDetailException;

	/**
	* Removes all the employee details where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of employee details where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching employee details
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the employee detail where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchEmployeeDetailException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching employee detail
	* @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	*/
	public EmployeeDetail findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeDetailException;

	/**
	* Returns the employee detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching employee detail, or <code>null</code> if a matching employee detail could not be found
	*/
	public EmployeeDetail fetchByUUID_G(String uuid, long groupId);

	/**
	* Returns the employee detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching employee detail, or <code>null</code> if a matching employee detail could not be found
	*/
	public EmployeeDetail fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the employee detail where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the employee detail that was removed
	*/
	public EmployeeDetail removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeDetailException;

	/**
	* Returns the number of employee details where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching employee details
	*/
	public int countByUUID_G(String uuid, long groupId);

	/**
	* Returns all the employee details where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching employee details
	*/
	public java.util.List<EmployeeDetail> findByUuid_C(String uuid,
		long companyId);

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
	public java.util.List<EmployeeDetail> findByUuid_C(String uuid,
		long companyId, int start, int end);

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
	public java.util.List<EmployeeDetail> findByUuid_C(String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail> orderByComparator);

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
	public java.util.List<EmployeeDetail> findByUuid_C(String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first employee detail in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching employee detail
	* @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	*/
	public EmployeeDetail findByUuid_C_First(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail> orderByComparator)
		throws NoSuchEmployeeDetailException;

	/**
	* Returns the first employee detail in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching employee detail, or <code>null</code> if a matching employee detail could not be found
	*/
	public EmployeeDetail fetchByUuid_C_First(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail> orderByComparator);

	/**
	* Returns the last employee detail in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching employee detail
	* @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	*/
	public EmployeeDetail findByUuid_C_Last(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail> orderByComparator)
		throws NoSuchEmployeeDetailException;

	/**
	* Returns the last employee detail in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching employee detail, or <code>null</code> if a matching employee detail could not be found
	*/
	public EmployeeDetail fetchByUuid_C_Last(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail> orderByComparator);

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
	public EmployeeDetail[] findByUuid_C_PrevAndNext(long empId, String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail> orderByComparator)
		throws NoSuchEmployeeDetailException;

	/**
	* Removes all the employee details where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(String uuid, long companyId);

	/**
	* Returns the number of employee details where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching employee details
	*/
	public int countByUuid_C(String uuid, long companyId);

	/**
	* Returns the employee detail where empId = &#63; or throws a {@link NoSuchEmployeeDetailException} if it could not be found.
	*
	* @param empId the emp ID
	* @return the matching employee detail
	* @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	*/
	public EmployeeDetail findByEmployeeId(long empId)
		throws NoSuchEmployeeDetailException;

	/**
	* Returns the employee detail where empId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param empId the emp ID
	* @return the matching employee detail, or <code>null</code> if a matching employee detail could not be found
	*/
	public EmployeeDetail fetchByEmployeeId(long empId);

	/**
	* Returns the employee detail where empId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param empId the emp ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching employee detail, or <code>null</code> if a matching employee detail could not be found
	*/
	public EmployeeDetail fetchByEmployeeId(long empId,
		boolean retrieveFromCache);

	/**
	* Removes the employee detail where empId = &#63; from the database.
	*
	* @param empId the emp ID
	* @return the employee detail that was removed
	*/
	public EmployeeDetail removeByEmployeeId(long empId)
		throws NoSuchEmployeeDetailException;

	/**
	* Returns the number of employee details where empId = &#63;.
	*
	* @param empId the emp ID
	* @return the number of matching employee details
	*/
	public int countByEmployeeId(long empId);

	/**
	* Returns the employee detail where firstName = &#63; and email = &#63; or throws a {@link NoSuchEmployeeDetailException} if it could not be found.
	*
	* @param firstName the first name
	* @param email the email
	* @return the matching employee detail
	* @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	*/
	public EmployeeDetail findByUserEmail(String firstName, String email)
		throws NoSuchEmployeeDetailException;

	/**
	* Returns the employee detail where firstName = &#63; and email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param firstName the first name
	* @param email the email
	* @return the matching employee detail, or <code>null</code> if a matching employee detail could not be found
	*/
	public EmployeeDetail fetchByUserEmail(String firstName, String email);

	/**
	* Returns the employee detail where firstName = &#63; and email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param firstName the first name
	* @param email the email
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching employee detail, or <code>null</code> if a matching employee detail could not be found
	*/
	public EmployeeDetail fetchByUserEmail(String firstName, String email,
		boolean retrieveFromCache);

	/**
	* Removes the employee detail where firstName = &#63; and email = &#63; from the database.
	*
	* @param firstName the first name
	* @param email the email
	* @return the employee detail that was removed
	*/
	public EmployeeDetail removeByUserEmail(String firstName, String email)
		throws NoSuchEmployeeDetailException;

	/**
	* Returns the number of employee details where firstName = &#63; and email = &#63;.
	*
	* @param firstName the first name
	* @param email the email
	* @return the number of matching employee details
	*/
	public int countByUserEmail(String firstName, String email);

	/**
	* Caches the employee detail in the entity cache if it is enabled.
	*
	* @param employeeDetail the employee detail
	*/
	public void cacheResult(EmployeeDetail employeeDetail);

	/**
	* Caches the employee details in the entity cache if it is enabled.
	*
	* @param employeeDetails the employee details
	*/
	public void cacheResult(java.util.List<EmployeeDetail> employeeDetails);

	/**
	* Creates a new employee detail with the primary key. Does not add the employee detail to the database.
	*
	* @param empId the primary key for the new employee detail
	* @return the new employee detail
	*/
	public EmployeeDetail create(long empId);

	/**
	* Removes the employee detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empId the primary key of the employee detail
	* @return the employee detail that was removed
	* @throws NoSuchEmployeeDetailException if a employee detail with the primary key could not be found
	*/
	public EmployeeDetail remove(long empId)
		throws NoSuchEmployeeDetailException;

	public EmployeeDetail updateImpl(EmployeeDetail employeeDetail);

	/**
	* Returns the employee detail with the primary key or throws a {@link NoSuchEmployeeDetailException} if it could not be found.
	*
	* @param empId the primary key of the employee detail
	* @return the employee detail
	* @throws NoSuchEmployeeDetailException if a employee detail with the primary key could not be found
	*/
	public EmployeeDetail findByPrimaryKey(long empId)
		throws NoSuchEmployeeDetailException;

	/**
	* Returns the employee detail with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param empId the primary key of the employee detail
	* @return the employee detail, or <code>null</code> if a employee detail with the primary key could not be found
	*/
	public EmployeeDetail fetchByPrimaryKey(long empId);

	@Override
	public java.util.Map<java.io.Serializable, EmployeeDetail> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the employee details.
	*
	* @return the employee details
	*/
	public java.util.List<EmployeeDetail> findAll();

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
	public java.util.List<EmployeeDetail> findAll(int start, int end);

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
	public java.util.List<EmployeeDetail> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail> orderByComparator);

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
	public java.util.List<EmployeeDetail> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetail> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the employee details from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of employee details.
	*
	* @return the number of employee details
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}