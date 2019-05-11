create index IX_11365BAE on mkdev_EmployeeDetail (firstName[$COLUMN_LENGTH:75$], email[$COLUMN_LENGTH:75$]);
create index IX_816B301 on mkdev_EmployeeDetail (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_BA0205C3 on mkdev_EmployeeDetail (uuid_[$COLUMN_LENGTH:75$], groupId);