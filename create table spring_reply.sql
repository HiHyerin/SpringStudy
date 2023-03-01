create table spring_reply(
    no NUMBER,
    rno NUMBER,
    type NUMBER,
    id VARCHAR2(20),
    name VARCHAR2(34)  CONSTRAINT sr_name_nn NOT NULL,
    msg CLOB CONSTRAINT sr_msg_nn NOT NULL,
    regdate DATE default sysdate,
    CONSTRAINT sr_no_pk PRIMARY KEY(no)
);

create SEQUENCE sr_no_seq
    START with 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;
    
-- procedure-----------------------------------------
-- Ãß°¡
create or replace PROCEDURE replyInsert(
    pRno spring_reply.rno%TYPE,
    pType spring_reply.type%TYPE,
    pId spring_reply.id%TYPE,
    pName spring_reply.name%TYPE,
    pMsg spring_reply.msg%TYPE

)
IS
BEGIN
    INSERT INTO spring_reply VALUES(sr_no_seq.nextval, pRno, pType ,pId ,pName ,pMsg , SYSDATE);
    COMMIT;
END;
/
----------------------------------------------------
CREATE OR REPLACE PROCEDURE replyDelete(
    pNo spring_reply.no%TYPE
)
IS
BEGIN
    DELETE FROM spring_reply
    WHERE no = pNo;
    COMMIT;
END;
/
---------------------------------------------------------
CREATE OR REPLACE PROCEDURE replyUpdate(
    pNo spring_reply.no%TYPE,
    pMsg spring_reply.msg%TYPE
)
IS
BEGIN
    UPDATE spring_reply SET
    msg=pMsg
    where no = pNo;
    COMMIT;
END;
/

---------------------------------------------------------
CREATE OR REPLACE PROCEDURE replyList(
    pRno spring_reply.rno%TYPE,
    pType spring_reply.type%TYPE,
    pResult OUT SYS_REFCURSOR
    
)
IS
BEGIN
    OPEN pResult FOR
        select no, rno, type, id, name, msg, regdate, to_char(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday
        from spring_reply
        where rno=pRno and type=pType
        ORDER BY no desc;
END;
/

commit;



-----------------------------------------------------------------
select * from jejuFood;

select * from spring_reply;