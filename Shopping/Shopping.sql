-------------------------------------------
-- Export file for user DBOS             --
-- Created by zxc on 2012-4-19, 16:29:59 --
-------------------------------------------

Rem Copyright (c) 2012 by zxc
SET TERMOUT OFF
SET ECHO OFF

GRANT CONNECT,RESOURCE,UNLIMITED TABLESPACE TO shopping IDENTIFIED BY zxc;
ALTER USER shopping DEFAULT TABLESPACE USERS;
ALTER USER shopping TEMPORARY TABLESPACE TEMP;
CONNECT shopping/zxc


create table users 
(
id number CONSTRAINT PK_users PRIMARY KEY,
username varchar2(40),
password varchar2(16),
phone varchar2(40),
addr varchar2(255),
rdate date
);


create table category
(
id number CONSTRAINT PK_category PRIMARY KEY,
pid number,
name varchar2(255), 
descr varchar2(255),
cno number, 
grade number 
);

create table product
(
id number CONSTRAINT PK_product PRIMARY KEY,
name varchar2(255),
descr varchar2(255),
normalprice number,
memberprice number,
pdate date
);



create table salesorder
(
id number CONSTRAINT PK_salesorder PRIMARY KEY,
userid number,
addr varchar2(255),
odate date,
status number
);


create table salesitem 
(
id number CONSTRAINT PK_salesitem  PRIMARY KEY,
productid number, 
unitprice number, 
pcount number,
orderid number
);

commit;
SET TERMOUT ON
SET ECHO ON
