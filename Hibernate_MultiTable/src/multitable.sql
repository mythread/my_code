prompt PL/SQL Developer import file
prompt Created on 2012年4月5日 by zxc
set feedback off
set define off
prompt Dropping GOODSTYPE...
drop table GOODSTYPE cascade constraints;
prompt Dropping GOODSINFO...
drop table GOODSINFO cascade constraints;
prompt Dropping ORDERTYPE...
drop table ORDERTYPE cascade constraints;
prompt Dropping USERROLE...
drop table USERROLE cascade constraints;
prompt Dropping USERINFO...
drop table USERINFO cascade constraints;
prompt Dropping ORDERINFO...
drop table ORDERINFO cascade constraints;
prompt Dropping ORDERGOODS...
drop table ORDERGOODS cascade constraints;
prompt Creating GOODSTYPE...
create table GOODSTYPE
(
  GOODSTYPENO   NUMBER(8) not null,
  GOODSTYPENAME VARCHAR2(20)
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
alter table GOODSTYPE
  add constraint PK_GOODSTYPE primary key (GOODSTYPENO)
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

prompt Creating GOODSINFO...
create table GOODSINFO
(
  GOODSNO   NUMBER(8) not null,
  GOODSNAME VARCHAR2(20),
  GOODSTYPE NUMBER(8),
  GOODSDESC VARCHAR2(20)
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
alter table GOODSINFO
  add constraint PK_GOODS primary key (GOODSNO)
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
alter table GOODSINFO
  add constraint FK_GOODS foreign key (GOODSTYPE)
  references GOODSTYPE (GOODSTYPENO);

prompt Creating ORDERTYPE...
create table ORDERTYPE
(
  TYPENO   NUMBER(8) not null,
  TYPENAME VARCHAR2(20)
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
alter table ORDERTYPE
  add constraint PK_ORDERTYPE primary key (TYPENO)
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

prompt Creating USERROLE...
create table USERROLE
(
  ROLENO   NUMBER(8) not null,
  ROLENAME VARCHAR2(20)
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
alter table USERROLE
  add constraint PK_ROLE primary key (ROLENO)
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

prompt Creating USERINFO...
create table USERINFO
(
  UNO    NUMBER(8) not null,
  UNAME  VARCHAR2(20),
  AGE    NUMBER(8),
  ROLENO NUMBER(8)
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
alter table USERINFO
  add constraint PK_USER primary key (UNO)
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
alter table USERINFO
  add constraint FK_USER_01 foreign key (ROLENO)
  references USERROLE (ROLENO);

prompt Creating ORDERINFO...
create table ORDERINFO
(
  ORDERNO   NUMBER(8) not null,
  ORDERTYPE NUMBER(8),
  ORDERDATE DATE,
  USERNO    NUMBER(8)
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
alter table ORDERINFO
  add constraint PK_ORDER primary key (ORDERNO)
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
alter table ORDERINFO
  add constraint FK_ORDER_01 foreign key (USERNO)
  references USERINFO (UNO);
alter table ORDERINFO
  add constraint FK_ORDER_02 foreign key (ORDERTYPE)
  references ORDERTYPE (TYPENO);

prompt Creating ORDERGOODS...
create table ORDERGOODS
(
  ORDERGOODSNO NUMBER(8) not null,
  ORDERNO      NUMBER(8),
  GOODSNO      NUMBER(8),
  PRICE        NUMBER(8,2),
  AMOUNT       NUMBER(8)
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
alter table ORDERGOODS
  add constraint PK_ORDERGOODS primary key (ORDERGOODSNO)
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
alter table ORDERGOODS
  add constraint FK_ORDERGOODS_01 foreign key (ORDERNO)
  references ORDERINFO (ORDERNO);
alter table ORDERGOODS
  add constraint FK_ORDERGOODS_02 foreign key (GOODSNO)
  references GOODSINFO (GOODSNO);

prompt Disabling triggers for GOODSTYPE...
alter table GOODSTYPE disable all triggers;
prompt Disabling triggers for GOODSINFO...
alter table GOODSINFO disable all triggers;
prompt Disabling triggers for ORDERTYPE...
alter table ORDERTYPE disable all triggers;
prompt Disabling triggers for USERROLE...
alter table USERROLE disable all triggers;
prompt Disabling triggers for USERINFO...
alter table USERINFO disable all triggers;
prompt Disabling triggers for ORDERINFO...
alter table ORDERINFO disable all triggers;
prompt Disabling triggers for ORDERGOODS...
alter table ORDERGOODS disable all triggers;
prompt Disabling foreign key constraints for GOODSINFO...
alter table GOODSINFO disable constraint FK_GOODS;
prompt Disabling foreign key constraints for USERINFO...
alter table USERINFO disable constraint FK_USER_01;
prompt Disabling foreign key constraints for ORDERINFO...
alter table ORDERINFO disable constraint FK_ORDER_01;
alter table ORDERINFO disable constraint FK_ORDER_02;
prompt Disabling foreign key constraints for ORDERGOODS...
alter table ORDERGOODS disable constraint FK_ORDERGOODS_01;
alter table ORDERGOODS disable constraint FK_ORDERGOODS_02;
prompt Loading GOODSTYPE...
insert into GOODSTYPE (GOODSTYPENO, GOODSTYPENAME)
values (1, '电脑配件');
insert into GOODSTYPE (GOODSTYPENO, GOODSTYPENAME)
values (2, '家电');
commit;
prompt 2 records loaded
prompt Loading GOODSINFO...
insert into GOODSINFO (GOODSNO, GOODSNAME, GOODSTYPE, GOODSDESC)
values (1, '主板', 1, 'fsafdsafsa');
insert into GOODSINFO (GOODSNO, GOODSNAME, GOODSTYPE, GOODSDESC)
values (2, 'CPU', 1, 'fsfafdsfdsa');
insert into GOODSINFO (GOODSNO, GOODSNAME, GOODSTYPE, GOODSDESC)
values (3, '空调', 2, 'fdsfadsf');
insert into GOODSINFO (GOODSNO, GOODSNAME, GOODSTYPE, GOODSDESC)
values (4, '洗衣机', 2, 'fdsfsa');
commit;
prompt 4 records loaded
prompt Loading ORDERTYPE...
insert into ORDERTYPE (TYPENO, TYPENAME)
values (1, '发货单');
insert into ORDERTYPE (TYPENO, TYPENAME)
values (2, '出库单');
commit;
prompt 2 records loaded
prompt Loading USERROLE...
insert into USERROLE (ROLENO, ROLENAME)
values (1, '管理员');
insert into USERROLE (ROLENO, ROLENAME)
values (2, '普通用户');
commit;
prompt 2 records loaded
prompt Loading USERINFO...
insert into USERINFO (UNO, UNAME, AGE, ROLENO)
values (1, '张三', 34, 2);
insert into USERINFO (UNO, UNAME, AGE, ROLENO)
values (2, 'lisi', 32, 2);
insert into USERINFO (UNO, UNAME, AGE, ROLENO)
values (3, 'wanger', 21, 1);
commit;
prompt 3 records loaded
prompt Loading ORDERINFO...
insert into ORDERINFO (ORDERNO, ORDERTYPE, ORDERDATE, USERNO)
values (1, 1, to_date('29-08-2011', 'dd-mm-yyyy'), 1);
insert into ORDERINFO (ORDERNO, ORDERTYPE, ORDERDATE, USERNO)
values (2, 2, to_date('22-08-2011', 'dd-mm-yyyy'), 1);
commit;
prompt 2 records loaded
prompt Loading ORDERGOODS...
insert into ORDERGOODS (ORDERGOODSNO, ORDERNO, GOODSNO, PRICE, AMOUNT)
values (1, 1, 1, 42134, 4321);
insert into ORDERGOODS (ORDERGOODSNO, ORDERNO, GOODSNO, PRICE, AMOUNT)
values (2, 1, 3, 34, 432);
insert into ORDERGOODS (ORDERGOODSNO, ORDERNO, GOODSNO, PRICE, AMOUNT)
values (3, 1, 2, 43, 2432);
insert into ORDERGOODS (ORDERGOODSNO, ORDERNO, GOODSNO, PRICE, AMOUNT)
values (4, 2, 1, 432, 432);
insert into ORDERGOODS (ORDERGOODSNO, ORDERNO, GOODSNO, PRICE, AMOUNT)
values (5, 2, 2, 43241, 432);
commit;
prompt 5 records loaded
prompt Enabling foreign key constraints for GOODSINFO...
alter table GOODSINFO enable constraint FK_GOODS;
prompt Enabling foreign key constraints for USERINFO...
alter table USERINFO enable constraint FK_USER_01;
prompt Enabling foreign key constraints for ORDERINFO...
alter table ORDERINFO enable constraint FK_ORDER_01;
alter table ORDERINFO enable constraint FK_ORDER_02;
prompt Enabling foreign key constraints for ORDERGOODS...
alter table ORDERGOODS enable constraint FK_ORDERGOODS_01;
alter table ORDERGOODS enable constraint FK_ORDERGOODS_02;
prompt Enabling triggers for GOODSTYPE...
alter table GOODSTYPE enable all triggers;
prompt Enabling triggers for GOODSINFO...
alter table GOODSINFO enable all triggers;
prompt Enabling triggers for ORDERTYPE...
alter table ORDERTYPE enable all triggers;
prompt Enabling triggers for USERROLE...
alter table USERROLE enable all triggers;
prompt Enabling triggers for USERINFO...
alter table USERINFO enable all triggers;
prompt Enabling triggers for ORDERINFO...
alter table ORDERINFO enable all triggers;
prompt Enabling triggers for ORDERGOODS...
alter table ORDERGOODS enable all triggers;
set feedback on
set define on
prompt Done.
