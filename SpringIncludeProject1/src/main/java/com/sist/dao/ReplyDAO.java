package com.sist.dao;

import org.springframework.stereotype.Repository;

import com.sist.vo.ReplyVO;

import oracle.jdbc.OracleTypes;

import java.util.*;
import java.sql.*;
@Repository
public class ReplyDAO {
	private Connection conn;
	private CallableStatement cs; // 프로시저 호출 시 사용 일반은 preparedStatement ps
		// <select id="" resultType="" parameterType="" statement="callable">
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	// MyBatis
	public ReplyDAO() {
		try {
			getClass().forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {}
	}
	
	// 연결
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL,"hr","happy");
		}catch(Exception e) {}
	}
	// 해제
	public void disConnection() {
		try {
			if(cs!=null) cs.close();
			if(conn!=null) conn.close();
		}catch(Exception e) {}
	}
	
	// 기능
	// 1. 추가
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
	
	
	public void replyInsert(ReplyVO vo) {
		try {
			getConnection();
			String sql = "{CALL replyInsert(?,?,?,?,?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1, vo.getRno());
			cs.setInt(2, vo.getType());
			cs.setString(3, vo.getId());
			cs.setString(4, vo.getName());
			cs.setString(5, vo.getMsg());
			cs.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
	}
	
	// 2. 목록
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
		        where rno=pRno and type=pType;
		    
		END;
		/
	 */
	public List<ReplyVO> replyListData(int rno, int type){
		// type (1:맛집, 2:제주, 3: 서울)
		List<ReplyVO> list = new ArrayList<ReplyVO>();
		try {
				getConnection();
				String sql = "{CALL replyList(?,?,?)}";
				cs = conn.prepareCall(sql);
				cs.setInt(1, rno);
				cs.setInt(2, type);
				cs.registerOutParameter(3, OracleTypes.CURSOR); //  pResult OUT SYS_REFCURSOR
				// 실행
				cs.executeQuery();
				ResultSet rs = (ResultSet)cs.getObject(3);
				while(rs.next()) {
					ReplyVO vo = new ReplyVO();
					vo.setNo(rs.getInt(1));
					vo.setRno(rs.getInt(2));
					vo.setType(rs.getInt(3));
					vo.setId(rs.getString(4));
					vo.setName(rs.getString(5));
					vo.setMsg(rs.getString(6));
					vo.setRegdate(rs.getDate(7));
					vo.setDbday(rs.getString(8));
					list.add(vo);
				}
				rs.close();
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
				disConnection();
		}
		
		return list;
	}
//	try {
//	getConnection();
//	} catch (Exception e) {
//	e.printStackTrace();
//	}finally {
//	disConnection();
//	}
	
	// 3. 수정
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
	public void replyUpdate(int no, String msg) {
		try {
				getConnection();
				String sql = "{CALL replyUpdate(?,?)}";
				cs = conn.prepareCall(sql);
				cs.setInt(1, no);
				cs.setString(2, msg);
				cs.executeQuery();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				disConnection();
			}
	}
	
	
	
	// 4. 삭제
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
	
	public void replyDelete(int no) {
		try {
			getConnection();
			String sql = "{CALL ReplyDelete(?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1, no);
			cs.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
	}
}
