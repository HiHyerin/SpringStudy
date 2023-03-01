package com.sist.mapper;
import java.util.*;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.sist.vo.*;
public interface ReplyMapper {
	/*
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
	 */
	// 목록
	@Select(value="{CALL replyList(#{pRno,mode=IN,javaType=java.lang.Integer},#{pType, mode=IN,javaType=java.lang.Integer},#{pResult, mode=OUT,jdbcType=CURSOR, resultMap=replyMap})}")
	@Options(statementType = StatementType.CALLABLE)
	public List<ReplyVO> replyListData(Map map);
	
	
	
	
	/*
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
	 */
	
	@Select(value="{CALL replyInsert(#{pRno, mode=IN, javaType=java.lang.Integer},#{pType, mode=IN, javaType=java.lang.Integer},#{pId, mode=IN, javaType=java.lang.String},"
			+ "#{pName, mode=IN, jdbcType=VARCHAR},#{pMsg, mode=IN, javaType=java.lang.String})}")
	@Options(statementType = StatementType.CALLABLE)
	public void replyInsert(Map map);
	
	
	
	
	
	/*
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
	 */
	@Select(value="{CALL replyUpdate(#{pNo, mode=IN, javaType=java.lang.Integer},#{pMsg, mode=IN, javaType=java.lang.Integer,resultMap=replyMap})}")
	@Options(statementType = StatementType.CALLABLE)
	public void replyUpdate(Map map);
	
	
	
	
	
	/*
 	
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

	 */
	@Select(value="{CALL replyDelete(#{pNo, mode=IN, jdbcType=INTEGER})}")
	@Options(statementType = StatementType.CALLABLE)
	public void replyDelete(Map map);

}
