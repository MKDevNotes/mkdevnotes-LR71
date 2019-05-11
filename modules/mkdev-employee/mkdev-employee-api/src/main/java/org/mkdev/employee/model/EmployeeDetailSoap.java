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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class EmployeeDetailSoap implements Serializable {
	public static EmployeeDetailSoap toSoapModel(EmployeeDetail model) {
		EmployeeDetailSoap soapModel = new EmployeeDetailSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEmpId(model.getEmpId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setEmail(model.getEmail());
		soapModel.setAge(model.getAge());
		soapModel.setGender(model.getGender());
		soapModel.setAddress(model.getAddress());
		soapModel.setMobile(model.getMobile());

		return soapModel;
	}

	public static EmployeeDetailSoap[] toSoapModels(EmployeeDetail[] models) {
		EmployeeDetailSoap[] soapModels = new EmployeeDetailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeDetailSoap[][] toSoapModels(EmployeeDetail[][] models) {
		EmployeeDetailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmployeeDetailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeDetailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeDetailSoap[] toSoapModels(List<EmployeeDetail> models) {
		List<EmployeeDetailSoap> soapModels = new ArrayList<EmployeeDetailSoap>(models.size());

		for (EmployeeDetail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmployeeDetailSoap[soapModels.size()]);
	}

	public EmployeeDetailSoap() {
	}

	public long getPrimaryKey() {
		return _empId;
	}

	public void setPrimaryKey(long pk) {
		setEmpId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEmpId() {
		return _empId;
	}

	public void setEmpId(long empId) {
		_empId = empId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public int getAge() {
		return _age;
	}

	public void setAge(int age) {
		_age = age;
	}

	public int getGender() {
		return _gender;
	}

	public void setGender(int gender) {
		_gender = gender;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getMobile() {
		return _mobile;
	}

	public void setMobile(String mobile) {
		_mobile = mobile;
	}

	private String _uuid;
	private long _empId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _firstName;
	private String _lastName;
	private String _email;
	private int _age;
	private int _gender;
	private String _address;
	private String _mobile;
}