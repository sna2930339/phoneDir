drop database if exists JspShiXun;

create database JspShiXun;

use JspShiXun;

drop table if exists t_snpyy;
create table t_snpyy(
                        idcard bigint ,
                        author varchar
);
insert into t_snpyy values('2040102155','20软工一班李瑜');


drop table if exists t_user;
create table t_user(
                       id int primary key auto_increment,
                       username varchar(16) not null,
                       password varchar(16) not null
);

insert into t_user(username,password) values('snpyy','123456');
insert into t_user(username,password) values('liyu55','123456');

