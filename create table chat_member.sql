create table chat_member(
    id varchar2(20) primary key,
    name varchar2(34) not null,
    pwd varchar2(10) not null
);

insert into chat_member values('kang', '������', '1234');
insert into chat_member values('song', '������', '1234');
insert into chat_member values('seo', '������', '1234');
insert into chat_member values('choi', '�ֿ��', '1234');
insert into chat_member values('park', '�ڼ���', '1234');

commit;

select * from chat_member;