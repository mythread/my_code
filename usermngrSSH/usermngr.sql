prompt PL/SQL Developer import file
prompt Created on 2012年03月28日 by zxc
set feedback off
set define off

GRANT CONNECT,RESOURCE,UNLIMITED TABLESPACE TO usermngr IDENTIFIED BY zxc;
ALTER USER usermngr DEFAULT TABLESPACE USERS;
ALTER USER usermngr TEMPORARY TABLESPACE TEMP;
CONNECT usermngr/zxc

prompt Dropping T_STATUS...
drop table T_STATUS cascade constraints;
prompt Dropping T_USER...
drop table T_USER cascade constraints;
prompt Creating T_STATUS...
create table T_STATUS
(
  STATUS_ID   CHAR(1) not null,
  STATUS_NAME VARCHAR2(20) not null
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table T_STATUS
  add constraint PK_STATUS primary key (STATUS_ID)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Creating T_USER...
create table T_USER
(
  USER_ID          CHAR(8) not null,
  USER_NAME        VARCHAR2(20) not null,
  STATUS_ID        CHAR(1),
  USER_PWD         CHAR(32) not null,
  USER_MAILADDRESS VARCHAR2(30)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table T_USER
  add constraint PK_USER primary key (USER_ID)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table T_USER
  add constraint FK_USER_01 foreign key (STATUS_ID)
  references T_STATUS (STATUS_ID) on delete cascade;

prompt Disabling triggers for T_STATUS...
alter table T_STATUS disable all triggers;
prompt Disabling triggers for T_USER...
alter table T_USER disable all triggers;
prompt Disabling foreign key constraints for T_USER...
alter table T_USER disable constraint FK_USER_01;
prompt Loading T_STATUS...
insert into T_STATUS (STATUS_ID, STATUS_NAME)
values ('1', 'online');
insert into T_STATUS (STATUS_ID, STATUS_NAME)
values ('2', 'offline');
commit;
prompt 2 records loaded
prompt Loading T_USER...
insert into T_USER (USER_ID, USER_NAME, STATUS_ID, USER_PWD, USER_MAILADDRESS)
values ('zhangsan', '张三', '2', '123456                          ', 'zhangsan@163.com');
insert into T_USER (USER_ID, USER_NAME, STATUS_ID, USER_PWD, USER_MAILADDRESS)
values ('lisi0000', '李四', '2', '123456                          ', 'lisi@163.com');
commit;
prompt 2 records loaded
prompt Enabling foreign key constraints for T_USER...
alter table T_USER enable constraint FK_USER_01;
prompt Enabling triggers for T_STATUS...
alter table T_STATUS enable all triggers;
prompt Enabling triggers for T_USER...
alter table T_USER enable all triggers;
set feedback on
set define on
prompt Done.
