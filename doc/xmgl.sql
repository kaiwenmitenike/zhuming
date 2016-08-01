提示 PL/SQL Developer 导入表
提示被创建于 2016年6月13日星期一 由 Administrator
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

提示载入 XMGL_CUSTOMER...
insert into XMGL_CUSTOMER (CUSTOMERID, CUSTOMERNAME)
values (10, '哈尔滨市政府');
insert into XMGL_CUSTOMER (CUSTOMERID, CUSTOMERNAME)
values (11, '哈尔滨统战部');
insert into XMGL_CUSTOMER (CUSTOMERID, CUSTOMERNAME)
values (12, '哈尔滨人事局');
insert into XMGL_CUSTOMER (CUSTOMERID, CUSTOMERNAME)
values (13, '哈尔滨制药六厂');
commit;
提示 4 条记录被装载
提示载入 XMGL_EMP...
insert into XMGL_EMP (EMPID, EMPNAME, JOBID)
values (1, '孙永亮', 1);
insert into XMGL_EMP (EMPID, EMPNAME, JOBID)
values (2, '王宏宇', 2);
insert into XMGL_EMP (EMPID, EMPNAME, JOBID)
values (3, '翟云鹏', 1);
insert into XMGL_EMP (EMPID, EMPNAME, JOBID)
values (4, '梁铁鑫', 2);
insert into XMGL_EMP (EMPID, EMPNAME, JOBID)
values (5, '李思琪', 2);
commit;
提示 5 条记录被装载
提示载入 XMGL_LEVEL...
insert into XMGL_LEVEL (LEVELID, LEVELNAME)
values (1, '暂不');
insert into XMGL_LEVEL (LEVELID, LEVELNAME)
values (2, '一般');
insert into XMGL_LEVEL (LEVELID, LEVELNAME)
values (3, '需要');
insert into XMGL_LEVEL (LEVELID, LEVELNAME)
values (4, '急');
insert into XMGL_LEVEL (LEVELID, LEVELNAME)
values (5, '很急');
commit;
提示 5 条记录被装载
提示载入 XMGL_STATE...
insert into XMGL_STATE (STATEID, STATENAME)
values (1, '计划');
insert into XMGL_STATE (STATEID, STATENAME)
values (2, '开发');
insert into XMGL_STATE (STATEID, STATENAME)
values (3, '开发完成');
insert into XMGL_STATE (STATEID, STATENAME)
values (4, '测试');
insert into XMGL_STATE (STATEID, STATENAME)
values (5, '完成');
commit;
提示 5 条记录被装载
提示载入 XMGL_PROJECT...
insert into XMGL_PROJECT (PROJECTID, CUSTOMERID, MANAGERID, LEVELID, STATEID, PROJECTNAME, WORKERCOUNT, BUILDDATE, UPDATEDATE, CREATEDATE, AMT)
values (21, 13, 5, 5, 1, '哈尔滨市政府OA二期', 30, to_date('05-05-2016', 'dd-mm-yyyy'), to_date('13-06-2016', 'dd-mm-yyyy'), to_date('08-06-2016', 'dd-mm-yyyy'), 55000000);
insert into XMGL_PROJECT (PROJECTID, CUSTOMERID, MANAGERID, LEVELID, STATEID, PROJECTNAME, WORKERCOUNT, BUILDDATE, UPDATEDATE, CREATEDATE, AMT)
values (22, 13, 4, 4, 2, '制药六厂ERP项目', 25, to_date('01-03-2016', 'dd-mm-yyyy'), to_date('08-06-2016', 'dd-mm-yyyy'), to_date('08-06-2016', 'dd-mm-yyyy'), 20000000);
commit;
提示 2 条记录被装载
set feedback on
set define on
提示完成。
