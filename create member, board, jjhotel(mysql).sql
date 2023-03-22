create database mydb character set utf8 collate utf8_general_ci;
use mydb;
create table mytable(
  no int primary key auto_increment,
  name varchar(100),
  content text
);

show databases;
create database mydb character set utf8 collate utf8_general_ci;

/*
	number			= 	int, double
    varchar2		= 	varchar
    clob			= 	text
    date			= 	datetime
    
    NVL				= 	ifnull
    TO_CHAR			= 	date_format
    '%'||A||'%' 	= 	CONCAT('%',값,'%')
*/
use mydb;
---------------------------------------------
create table member(
	no int auto_increment, 
    name varchar(34) not null,
    addr varchar(200),
    regdate datetime default now(),
    primary key(no)
);
insert into member(name,addr) values('홍길동','서울');
insert into member(name,addr) values('심청이','경기');
insert into member(name,addr) values('박문수',null);
commit;

select * from member;

select no, name, date_format(regdate,'%Y-%m-%d'), ifnull(addr,'없음')
from member;

select no, name, date_format(regdate,'%Y-%m-%d'), ifnull(addr,'없음')
from member limit 0,10; -- 페이지 나누기(limit)

select count(*) from member;

/*
이름      널?       유형            
------- -------- ------------- 
CNO     NOT NULL NUMBER        
TITLE   NOT NULL VARCHAR2(100) 
SUBJECT NOT NULL VARCHAR2(200) 
POSTER  NOT NULL VARCHAR2(300) 
LINK    NOT NULL VARCHAR2(200)
*/
----------------------------------------------------
create table project_category(
	cno int auto_increment,
    title varchar(1000) not null,
    subject varchar(1000) not null,
    poster varchar(500) not null,
    link varchar(200) not null,
    primary key(cno)
);

desc project_category;

select * from member;
select * from project_category;
-------------------------------------------------------
create table board(
	no int auto_increment,
    name varchar(34) not null,
    subject varchar(1000) not null,
    content text not null,
    pwd varchar(10) not null,
    regdate datetime default now(),
    hit int default 0,
    primary key(no)
);



insert into board(name,subject,content,pwd)
values('세훈','jpa를 이용한 게시판','jpa를 이용한 게시판','1234');
commit;
select * from board;

select count(*) from board;
select ceil(count(*)/10.0) from board;



--------------------------------------------------------
--  DDL for Table JJ_HOTEL_1
--------------------------------------------------------
drop table JJ_HOTEL_1;
use mydb;
  CREATE TABLE JJ_HOTEL_1 
   (
    HNO int auto_increment, 
	ALL_CATE_NO int, 
	H_CRAWL_NO int, 
	GRADE VARCHAR(20), 
	NAME VARCHAR(200), 
	ADDR VARCHAR(200), 
	INTRO text, 
	TIME VARCHAR(100), 
	STAR double, 
	ACCOUNT int, 
	HOTEL_IMAGE VARCHAR(260), 
	LIKE_COUNT int DEFAULT 0, 
	JJIM_COUNT int DEFAULT 0,
    primary key(hno)
   );
   show databases;

select * from jj_hotel;
desc jj_hotel;
commit;

