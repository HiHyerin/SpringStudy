create table spring_databoard(
    no NUMBER,
    name varchar2(34) constraint sd_name_nn not null,
    subject varchar2(1000) constraint sd_sub_nn not null,
    content clob constraint sd_cont_nn not null,
    pwd varchar2(10) constraint sd_pwd_nn not null,
    regdate date default sysdate,
    hit number default 0,
    filename varchar2(4000),
    filesize varchar2(4000),
    filecount number default 0,
    constraint sd_no_pk primary key(no)
);

desc spring_databoard;

commit;

drop table recipe;

CREATE TABLE recipe(
    no NUMBER,
    title VARCHAR2(1000) CONSTRAINT recipe_title_nn NOT NULL,
    poster VARCHAR2(260) CONSTRAINT recipe_poster_nn NOT NULL,
    chef VARCHAR2(200) CONSTRAINT recipe_chef_nn NOT NULL,
    link VARCHAR2(260),
    hit NUMBER DEFAULT 0,
    CONSTRAINT recipe_no_pk PRIMARY KEY(no)
);