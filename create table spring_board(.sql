
create table spring_board(
    no number,
    name varchar2(34) constraint sb_name_nn not null,
    subject varchar2(2000) constraint sb_sub_nn not null,
    content clob constraint sb_cont_nn not null,
    pwd varchar2(10) constraint sb_pwd_nn not null,
    regdate date default sysdate,
    hit number default 0,
    constraint sb_no_pk primary key(no)
);

create SEQUENCE sb_no_seq
    start with 1
    increment by 1
    nocycle
    nocache;