create table mkdev_EmployeeDetail (
	uuid_ VARCHAR(75) null,
	empId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	email VARCHAR(75) null,
	age INTEGER,
	gender INTEGER,
	address VARCHAR(75) null,
	mobile VARCHAR(75) null
);