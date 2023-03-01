create table spring_member(
    id varchar2(20),
    pwd VARCHAR2(2000) CONSTRAINT sm_pwd_nn NOT NULL,
    name VARCHAR2(34) CONSTRAINT sm_name_nn NOT NULL,
    CONSTRAINT sm_id_pk PRIMARY KEY(id)
);

commit;
select * from spring_member;