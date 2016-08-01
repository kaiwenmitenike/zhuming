��ʾ PL/SQL Developer �����
��ʾ�������� 2016��6��13������һ �� Administrator
set feedback off
set define off
prompt Dropping XMGL_CUSTOMER...
drop table XMGL_CUSTOMER cascade constraints;
prompt Dropping XMGL_EMP...
drop table XMGL_EMP cascade constraints;
prompt Dropping XMGL_LEVEL...
drop table XMGL_LEVEL cascade constraints;
prompt Dropping XMGL_STATE...
drop table XMGL_STATE cascade constraints;
prompt Dropping XMGL_PROJECT...
drop table XMGL_PROJECT cascade constraints;
prompt Creating XMGL_CUSTOMER...
create table XMGL_CUSTOMER
(
  CUSTOMERID   NUMBER(4) not null,
  CUSTOMERNAME VARCHAR2(32)
)
;
alter table XMGL_CUSTOMER
  add constraint PK_XMGL_CUSTOMER primary key (CUSTOMERID);

prompt Creating XMGL_EMP...
create table XMGL_EMP
(
  EMPID   NUMBER(4) not null,
  EMPNAME VARCHAR2(32),
  JOBID   NUMBER(4)
)
;
alter table XMGL_EMP
  add constraint PK_XMGL_EMP primary key (EMPID);

prompt Creating XMGL_LEVEL...
create table XMGL_LEVEL
(
  LEVELID   NUMBER(4) not null,
  LEVELNAME VARCHAR2(32)
)
;
alter table XMGL_LEVEL
  add constraint PK_XMGL_LEVEL primary key (LEVELID);

prompt Creating XMGL_STATE...
create table XMGL_STATE
(
  STATEID   NUMBER(2) not null,
  STATENAME VARCHAR2(32)
)
;
alter table XMGL_STATE
  add constraint PK_XMGL_STATE primary key (STATEID);

prompt Creating XMGL_PROJECT...
create table XMGL_PROJECT
(
  PROJECTID   NUMBER(4) not null,
  CUSTOMERID  NUMBER(4),
  MANAGERID   NUMBER(4),
  LEVELID     NUMBER(4),
  STATEID     NUMBER(2),
  PROJECTNAME VARCHAR2(32),
  WORKERCOUNT NUMBER(4),
  BUILDDATE   DATE,
  UPDATEDATE  DATE,
  CREATEDATE  DATE,
  AMT         NUMBER(9)
)
;
alter table XMGL_PROJECT
  add constraint PK_XMGL_PROJECT primary key (PROJECTID);
alter table XMGL_PROJECT
  add constraint FK_XMGL_PRO_REFERENCE_XMGL_CUS foreign key (CUSTOMERID)
  references XMGL_CUSTOMER (CUSTOMERID);
alter table XMGL_PROJECT
  add constraint FK_XMGL_PRO_REFERENCE_XMGL_EMP foreign key (MANAGERID)
  references XMGL_EMP (EMPID);
alter table XMGL_PROJECT
  add constraint FK_XMGL_PRO_REFERENCE_XMGL_LEV foreign key (LEVELID)
  references XMGL_LEVEL (LEVELID);
alter table XMGL_PROJECT
  add constraint FK_XMGL_PRO_REFERENCE_XMGL_STA foreign key (STATEID)
  references XMGL_STATE (STATEID);

��ʾ���� XMGL_CUSTOMER...
insert into XMGL_CUSTOMER (CUSTOMERID, CUSTOMERNAME)
values (10, '������������');
insert into XMGL_CUSTOMER (CUSTOMERID, CUSTOMERNAME)
values (11, '������ͳս��');
insert into XMGL_CUSTOMER (CUSTOMERID, CUSTOMERNAME)
values (12, '���������¾�');
insert into XMGL_CUSTOMER (CUSTOMERID, CUSTOMERNAME)
values (13, '��������ҩ����');
commit;
��ʾ 4 ����¼��װ��
��ʾ���� XMGL_EMP...
insert into XMGL_EMP (EMPID, EMPNAME, JOBID)
values (1, '������', 1);
insert into XMGL_EMP (EMPID, EMPNAME, JOBID)
values (2, '������', 2);
insert into XMGL_EMP (EMPID, EMPNAME, JOBID)
values (3, '������', 1);
insert into XMGL_EMP (EMPID, EMPNAME, JOBID)
values (4, '������', 2);
insert into XMGL_EMP (EMPID, EMPNAME, JOBID)
values (5, '��˼��', 2);
commit;
��ʾ 5 ����¼��װ��
��ʾ���� XMGL_LEVEL...
insert into XMGL_LEVEL (LEVELID, LEVELNAME)
values (1, '�ݲ�');
insert into XMGL_LEVEL (LEVELID, LEVELNAME)
values (2, 'һ��');
insert into XMGL_LEVEL (LEVELID, LEVELNAME)
values (3, '��Ҫ');
insert into XMGL_LEVEL (LEVELID, LEVELNAME)
values (4, '��');
insert into XMGL_LEVEL (LEVELID, LEVELNAME)
values (5, '�ܼ�');
commit;
��ʾ 5 ����¼��װ��
��ʾ���� XMGL_STATE...
insert into XMGL_STATE (STATEID, STATENAME)
values (1, '�ƻ�');
insert into XMGL_STATE (STATEID, STATENAME)
values (2, '����');
insert into XMGL_STATE (STATEID, STATENAME)
values (3, '�������');
insert into XMGL_STATE (STATEID, STATENAME)
values (4, '����');
insert into XMGL_STATE (STATEID, STATENAME)
values (5, '���');
commit;
��ʾ 5 ����¼��װ��
��ʾ���� XMGL_PROJECT...
insert into XMGL_PROJECT (PROJECTID, CUSTOMERID, MANAGERID, LEVELID, STATEID, PROJECTNAME, WORKERCOUNT, BUILDDATE, UPDATEDATE, CREATEDATE, AMT)
values (21, 13, 5, 5, 1, '������������OA����', 30, to_date('05-05-2016', 'dd-mm-yyyy'), to_date('13-06-2016', 'dd-mm-yyyy'), to_date('08-06-2016', 'dd-mm-yyyy'), 55000000);
insert into XMGL_PROJECT (PROJECTID, CUSTOMERID, MANAGERID, LEVELID, STATEID, PROJECTNAME, WORKERCOUNT, BUILDDATE, UPDATEDATE, CREATEDATE, AMT)
values (22, 13, 4, 4, 2, '��ҩ����ERP��Ŀ', 25, to_date('01-03-2016', 'dd-mm-yyyy'), to_date('08-06-2016', 'dd-mm-yyyy'), to_date('08-06-2016', 'dd-mm-yyyy'), 20000000);
commit;
��ʾ 2 ����¼��װ��
set feedback on
set define on
��ʾ��ɡ�
