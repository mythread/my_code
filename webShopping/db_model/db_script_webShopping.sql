/*==============================================================*/
/* DBMS name:      MySQL 5.1                                    */
/* Created on:     2008-4-7 16:43:38                            */
/*==============================================================*/

drop table if exists category;

drop table if exists orderitem;

drop table if exists product;

drop table if exists salesorder;

drop table if exists users;

/*==============================================================*/
/* Table: category                                              */
/*==============================================================*/
create table category
(
   cid                  int auto_increment not null,
   name                 varchar(50) not null,
   descr                varchar(255),
   parentid             int not null,
   primary key (cid)
);

/*==============================================================*/
/* Table: orderitem                                             */
/*==============================================================*/
create table orderitem
(
   oid                  int auto_increment not null,
   soid                 int not null,
   pid                  int not null,
   name			varchar(255) not null,
   count                int not null,
   unitprice            float not null,
   primary key (oid)
);

/*==============================================================*/
/* Table: product                                               */
/*==============================================================*/
create table product
(
   pid                  int auto_increment not null,
   name                 varchar(255) not null,
   unitprice            float not null,
   discount             float not null,
   -- 1:可见 
   -- 0:不可见
   isvisible            int not null,
   -- 1:热推商品 
   -- 0:一般商品
   status               int not null,
   cid                  int not null,
   picture              varchar(255) not null,
   descr                varchar(255),
   primary key (pid)
);

/*==============================================================*/
/* Table: salesorder                                            */
/*==============================================================*/
create table salesorder
(
   soid                 int auto_increment not null,
   userid               varchar(32) not null,
   buydate              date not null,
   address              varchar(50) not null,
   phone                varchar(13) not null,
   -- 1:没有处理
   -- 0:已经处理
   status               int not null,
   primary key (soid)
);

/*==============================================================*/
/* Table: users                                                 */
/*==============================================================*/
create table users
(
   userid               varchar(32) not null,
   username             varchar(50) not null,
   password             varchar(50) not null,
   email                varchar(50) not null,
   question             varchar(50) not null,
   answer               varchar(50) not null,
   phone                varchar(13),
   address              varchar(50),
   primary key (userid)
);

alter table orderitem add constraint FK_Relationship_4 foreign key (soid)
      references salesorder (soid) on delete restrict on update restrict;

alter table product add constraint FK_Relationship_2 foreign key (cid)
      references category (cid) on delete restrict on update restrict;

alter table salesorder add constraint FK_Relationship_1 foreign key (userid)
      references users (userid) on delete restrict on update restrict;
