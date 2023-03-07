create table chat_member(
    id varchar2(20) primary key,
    name varchar2(34) not null,
    pwd varchar2(10) not null
);

insert into chat_member values('kang', '강동원', '1234');
insert into chat_member values('song', '송혜교', '1234');
insert into chat_member values('seo', '서강준', '1234');
insert into chat_member values('choi', '최우식', '1234');
insert into chat_member values('park', '박서준', '1234');

commit;

select * from chat_member;