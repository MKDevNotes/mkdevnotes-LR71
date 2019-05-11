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

package org.mkdev.employee.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import org.mkdev.employee.model.EmployeeDetail;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeDetail in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetail
 * @generated
 */
@ProviderType
public class EmployeeDetailCacheModel implements CacheModel<EmployeeDetail>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmployeeDetailCacheModel)) {
			return false;
		}

		EmployeeDetailCacheModel employeeDetailCacheModel = (EmployeeDetailCacheModel)obj;

		if (empId == employeeDetailCacheModel.empId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, empId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", empId=");
		sb.append(empId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", email=");
		sb.append(email);
		sb.append(", age=");
		sb.append(age);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", address=");
		sb.append(address);
		sb.append(", mobile=");
		sb.append(mobile);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeDetail toEntityModel() {
		EmployeeDetailImpl employeeDetailImpl = new EmployeeDetailImpl();

		if (uuid == null) {
			employeeDetailImpl.setUuid("");
		}
		else {
			employeeDetailImpl.setUuid(uuid);
		}

		employeeDetailImpl.setEmpId(empId);
		employeeDetailImpl.setGroupId(groupId);
		employeeDetailImpl.setCompanyId(companyId);
		employeeDetailImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			employeeDetailImpl.setCreateDate(null);
		}
		else {
			employeeDetailImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeDetailImpl.setModifiedDate(null);
		}
		else {
			employeeDetailImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (firstName == null) {
			employeeDetailImpl.setFirstName("");
		}
		else {
			employeeDetailImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			employeeDetailImpl.setLastName("");
		}
		else {
			employeeDetailImpl.setLastName(lastName);
		}

		if (email == null) {
			employeeDetailImpl.setEmail("");
		}
		else {
			employeeDetailImpl.setEmail(email);
		}

		employeeDetailImpl.setAge(age);
		employeeDetailImpl.setGender(gender);

		if (address == null) {
			employeeDetailImpl.setAddress("");
		}
		else {
			employeeDetailImpl.setAddress(address);
		}

		if (mobile == null) {
			employeeDetailImpl.setMobile("");
		}
		else {
			employeeDetailImpl.setMobile(mobile);
		}

		employeeDetailImpl.resetOriginalValues();

		return employeeDetailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		empId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		email = objectInput.readUTF();

		age = objectInput.readInt();

		gender = objectInput.readInt();
		address = objectInput.readUTF();
		mobile = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(empId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		objectOutput.writeInt(age);

		objectOutput.writeInt(gender);

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (mobile == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobile);
		}
	}

	public String uuid;
	public long empId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String firstName;
	public String lastName;
	public String email;
	public int age;
	public int gender;
	public String address;
	public String mobile;
}