drop table if exists t_phonedir;
create table t_phonedir(
                           id int primary key auto_increment,
                           master varchar(255) not null,					--  电话簿主人
                           contact varchar(16) not null, 					--  联系人名字
                           number bigint not null,							--  联系人电话号码
                           homeloc  varchar(255) not null,                  --  号码归属地
                           address varchar(255) 							--  地址备注
);

insert into t_phonedir(master,contact,number,homeloc,address) values('snpyy','遂哥哥','17583105694','四川省遂宁市','四川省遂宁市船山区');
insert into t_phonedir(master,contact,number,homeloc,address) values('snpyy','宁姐姐','15876487545','四川省成都市','四川省成都市双流区');
insert into t_phonedir(master,contact,number,homeloc,address) values('snpyy','彭奶奶','16487545412','四川省绵阳市','四川省绵阳市经开区');
insert into t_phonedir(master,contact,number,homeloc,address) values('snpyy','于叔'  ,'14564875441','四川省南充市','四川省南充市高新区');
insert into t_phonedir(master,contact,number,homeloc,address) values('snpyy','晏殊'  ,'15487856416','四川省遂宁市','四川省遂宁市物流港');


insert into t_phonedir(master,contact,number,homeloc,address) values('liyu55','宁姐姐','15876487545','四川省成都市','四川省成都市双流区');
insert into t_phonedir(master,contact,number,homeloc,address) values('liyu55','吴彦祖','19478994561','安徽省合肥市','安徽省合肥市蜀山区');
insert into t_phonedir(master,contact,number,homeloc,address) values('liyu55','谢霆锋','14874954985','安徽省合肥市','安徽省合肥市肥西县');
insert into t_phonedir(master,contact,number,homeloc,address) values('liyu55','刘德华','18456145614','四川省遂宁市','四川省遂宁市安居区');
insert into t_phonedir(master,contact,number,homeloc,address) values('liyu55','渣渣辉','18789456241','安徽省合肥市','安徽省合肥市包河区');