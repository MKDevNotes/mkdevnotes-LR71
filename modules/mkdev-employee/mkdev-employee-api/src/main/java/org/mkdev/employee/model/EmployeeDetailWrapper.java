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

package org.mkdev.employee.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link EmployeeDetail}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetail
 * @generated
 */
@ProviderType
public class EmployeeDetailWrapper implements EmployeeDetail,
	ModelWrapper<EmployeeDetail> {
	public EmployeeDetailWrapper(EmployeeDetail employeeDetail) {
		_employeeDetail = employeeDetail;
	}

	@Override
	public Class<?> getModelClass() {
		return EmployeeDetail.class;
	}

	@Override
	public String getModelClassName() {
		return EmployeeDetail.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("empId", getEmpId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("email", getEmail());
		attributes.put("age", getAge());
		attributes.put("gender", getGender());
		attributes.put("address", getAddress());
		attributes.put("mobile", getMobile());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long empId = (Long)attributes.get("empId");

		if (empId != null) {
			setEmpId(empId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Integer age = (Integer)attributes.get("age");

		if (age != null) {
			setAge(age);
		}

		Integer gender = (Integer)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String mobile = (String)attributes.get("mobile");

		if (mobile != null) {
			setMobile(mobile);
		}
	}

	@Override
	public Object clone() {
		return new EmployeeDetailWrapper((EmployeeDetail)_employeeDetail.clone());
	}

	@Override
	public int compareTo(EmployeeDetail employeeDetail) {
		return _employeeDetail.compareTo(employeeDetail);
	}

	/**
	* Returns the address of this employee detail.
	*
	* @return the address of this employee detail
	*/
	@Override
	public String getAddress() {
		return _employeeDetail.getAddress();
	}

	/**
	* Returns the age of this employee detail.
	*
	* @return the age of this employee detail
	*/
	@Override
	public int getAge() {
		return _employeeDetail.getAge();
	}

	/**
	* Returns the company ID of this employee detail.
	*
	* @return the company ID of this employee detail
	*/
	@Override
	public long getCompanyId() {
		return _employeeDetail.getCompanyId();
	}

	/**
	* Returns the create date of this employee detail.
	*
	* @return the create date of this employee detail
	*/
	@Override
	public Date getCreateDate() {
		return _employeeDetail.getCreateDate();
	}

	/**
	* Returns the email of this employee detail.
	*
	* @return the email of this employee detail
	*/
	@Override
	public String getEmail() {
		return _employeeDetail.getEmail();
	}

	/**
	* Returns the emp ID of this employee detail.
	*
	* @return the emp ID of this employee detail
	*/
	@Override
	public long getEmpId() {
		return _employeeDetail.getEmpId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _employeeDetail.getExpandoBridge();
	}

	/**
	* Returns the first name of this employee detail.
	*
	* @return the first name of this employee detail
	*/
	@Override
	public String getFirstName() {
		return _employeeDetail.getFirstName();
	}

	/**
	* Returns the gender of this employee detail.
	*
	* @return the gender of this employee detail
	*/
	@Override
	public int getGender() {
		return _employeeDetail.getGender();
	}

	/**
	* Returns the group ID of this employee detail.
	*
	* @return the group ID of this employee detail
	*/
	@Override
	public long getGroupId() {
		return _employeeDetail.getGroupId();
	}

	/**
	* Returns the last name of this employee detail.
	*
	* @return the last name of this employee detail
	*/
	@Override
	public String getLastName() {
		return _employeeDetail.getLastName();
	}

	/**
	* Returns the mobile of this employee detail.
	*
	* @return the mobile of this employee detail
	*/
	@Override
	public String getMobile() {
		return _employeeDetail.getMobile();
	}

	/**
	* Returns the modified date of this employee detail.
	*
	* @return the modified date of this employee detail
	*/
	@Override
	public Date getModifiedDate() {
		return _employeeDetail.getModifiedDate();
	}

	/**
	* Returns the primary key of this employee detail.
	*
	* @return the primary key of this employee detail
	*/
	@Override
	public long getPrimaryKey() {
		return _employeeDetail.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _employeeDetail.getPrimaryKeyObj();
	}

	/**
	* Returns the user ID of this employee detail.
	*
	* @return the user ID of this employee detail
	*/
	@Override
	public long getUserId() {
		return _employeeDetail.getUserId();
	}

	/**
	* Returns the user uuid of this employee detail.
	*
	* @return the user uuid of this employee detail
	*/
	@Override
	public String getUserUuid() {
		return _employeeDetail.getUserUuid();
	}

	/**
	* Returns the uuid of this employee detail.
	*
	* @return the uuid of this employee detail
	*/
	@Override
	public String getUuid() {
		return _employeeDetail.getUuid();
	}

	@Override
	public int hashCode() {
		return _employeeDetail.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _employeeDetail.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _employeeDetail.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _employeeDetail.isNew();
	}

	@Override
	public void persist() {
		_employeeDetail.persist();
	}

	/**
	* Sets the address of this employee detail.
	*
	* @param address the address of this employee detail
	*/
	@Override
	public void setAddress(String address) {
		_employeeDetail.setAddress(address);
	}

	/**
	* Sets the age of this employee detail.
	*
	* @param age the age of this employee detail
	*/
	@Override
	public void setAge(int age) {
		_employeeDetail.setAge(age);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_employeeDetail.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this employee detail.
	*
	* @param companyId the company ID of this employee detail
	*/
	@Override
	public void setCompanyId(long companyId) {
		_employeeDetail.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this employee detail.
	*
	* @param createDate the create date of this employee detail
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_employeeDetail.setCreateDate(createDate);
	}

	/**
	* Sets the email of this employee detail.
	*
	* @param email the email of this employee detail
	*/
	@Override
	public void setEmail(String email) {
		_employeeDetail.setEmail(email);
	}

	/**
	* Sets the emp ID of this employee detail.
	*
	* @param empId the emp ID of this employee detail
	*/
	@Override
	public void setEmpId(long empId) {
		_employeeDetail.setEmpId(empId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_employeeDetail.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_employeeDetail.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_employeeDetail.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the first name of this employee detail.
	*
	* @param firstName the first name of this employee detail
	*/
	@Override
	public void setFirstName(String firstName) {
		_employeeDetail.setFirstName(firstName);
	}

	/**
	* Sets the gender of this employee detail.
	*
	* @param gender the gender of this employee detail
	*/
	@Override
	public void setGender(int gender) {
		_employeeDetail.setGender(gender);
	}

	/**
	* Sets the group ID of this employee detail.
	*
	* @param groupId the group ID of this employee detail
	*/
	@Override
	public void setGroupId(long groupId) {
		_employeeDetail.setGroupId(groupId);
	}

	/**
	* Sets the last name of this employee detail.
	*
	* @param lastName the last name of this employee detail
	*/
	@Override
	public void setLastName(String lastName) {
		_employeeDetail.setLastName(lastName);
	}

	/**
	* Sets the mobile of this employee detail.
	*
	* @param mobile the mobile of this employee detail
	*/
	@Override
	public void setMobile(String mobile) {
		_employeeDetail.setMobile(mobile);
	}

	/**
	* Sets the modified date of this employee detail.
	*
	* @param modifiedDate the modified date of this employee detail
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_employeeDetail.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_employeeDetail.setNew(n);
	}

	/**
	* Sets the primary key of this employee detail.
	*
	* @param primaryKey the primary key of this employee detail
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_employeeDetail.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_employeeDetail.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this employee detail.
	*
	* @param userId the user ID of this employee detail
	*/
	@Override
	public void setUserId(long userId) {
		_employeeDetail.setUserId(userId);
	}

	/**
	* Sets the user uuid of this employee detail.
	*
	* @param userUuid the user uuid of this employee detail
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_employeeDetail.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this employee detail.
	*
	* @param uuid the uuid of this employee detail
	*/
	@Override
	public void setUuid(String uuid) {
		_employeeDetail.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<EmployeeDetail> toCacheModel() {
		return _employeeDetail.toCacheModel();
	}

	@Override
	public EmployeeDetail toEscapedModel() {
		return new EmployeeDetailWrapper(_employeeDetail.toEscapedModel());
	}

	@Override
	public String toString() {
		return _employeeDetail.toString();
	}

	@Override
	public EmployeeDetail toUnescapedModel() {
		return new EmployeeDetailWrapper(_employeeDetail.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _employeeDetail.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmployeeDetailWrapper)) {
			return false;
		}

		EmployeeDetailWrapper employeeDetailWrapper = (EmployeeDetailWrapper)obj;

		if (Objects.equals(_employeeDetail,
					employeeDetailWrapper._employeeDetail)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _employeeDetail.getStagedModelType();
	}

	@Override
	public EmployeeDetail getWrappedModel() {
		return _employeeDetail;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _employeeDetail.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _employeeDetail.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_employeeDetail.resetOriginalValues();
	}

	private final EmployeeDetail _employeeDetail;
}