package com.sist.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.*;

import org.springframework.security.access.vote.RoleVoter;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;

import oracle.jdbc.internal.OracleTypes;
@Repository
public class ReplyDAO {

	
//	create or replace NONEDITIONABLE PROCEDURE replyInsert(
//		    pRno spring_reply.rno%TYPE,
//		    pType spring_reply.type%TYPE,
//		    pId spring_reply.id%TYPE,
//		    pName spring_reply.name%TYPE,
//		    pMsg spring_reply.msg%TYPE
//
//		)
//		IS
//		BEGIN
//		    INSERT INTO spring_reply VALUES(sr_no_seq.nextval, pRno, pType ,pId ,pName ,pMsg , SYSDATE);
//		    COMMIT;
//		END;

	
//	create or replace NONEDITIONABLE PROCEDURE replyList(
//		    pRno spring_reply.rno%TYPE,
//		    pType spring_reply.type%TYPE,
//		    pResult OUT SYS_REFCURSOR
//		    
//		)
//		IS
//		BEGIN
//		    OPEN pResult FOR
//		        select no, rno, type, id, name, msg, regdate, to_char(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday
//		        from spring_reply
//		        where rno=pRno and type=pType
//		        ORDER BY no desc;
//		END;


	
	
	private Connection conn;
	private CallableStatement cs;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	public ReplyDAO() {
		try {
			getClass().forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {}
	}
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL,"hr","happy");
		} catch (Exception e) {}
	}
	public void disConnection() {
		try {
			if(cs!=null) cs.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {}
	}
	
	// crud(select, insert, update, delete)
	
	public List<ReplyVO> replyListData(ReplyVO vo){
		List<ReplyVO> list = new ArrayList<ReplyVO>();
		try {
			getConnection();
			String sql = "{CALL replyList(?,?,?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1, vo.getType()); // 카테고리(맛집, 레시피)
			cs.setInt(2, vo.getNo());// 맛집, 번호(고유번호)
			cs.registerOutParameter(3, OracleTypes.CURSOR);
			cs.executeQuery();
			ResultSet rs = (ResultSet)cs.getObject(3);
			 // CURSO = resultSet
			while(rs.next()) {
				ReplyVO rvo = new ReplyVO();
				rvo.setNo(rs.getInt(1));
				rvo.setRno(rs.getInt(2));
				rvo.setType(rs.getInt(3));
				rvo.setId(rs.getString(4));
				rvo.setName(rs.getString(5));
				rvo.setMsg(rs.getString(6));
				rvo.setRegdate(rs.getDate(7));
				rvo.setDbday(rs.getString(8));
				list.add(rvo);
				
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void replyInsert(ReplyVO vo) {
		try {
			getConnection();
			String sql="{CALL replyInsert(?,?,?,?,?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1, vo.getRno());
			cs.setInt(2, vo.getType());
			cs.setString(3, vo.getId());
			cs.setString(4, vo.getName());
			cs.setString(5, vo.getMsg());
			cs.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
//	create or replace NONEDITIONABLE PROCEDURE replyUpdate(
//    pNo spring_reply.no%TYPE,
//    pMsg spring_reply.msg%TYPE
//)
//IS
//BEGIN
//    UPDATE spring_reply SET
//    msg=pMsg
//    where no = pNo;
//    COMMIT;
//END;
	
	public void replyUpdate(int no, String msg) {
		try {
			getConnection();
			String sql = "{Call replyUpdate(?, ?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1, no);
			cs.setString(2, msg);
			cs.executeQuery();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
	}
	
//	create or replace NONEDITIONABLE PROCEDURE replyDelete(
//    pNo spring_reply.no%TYPE
//)
//IS
//BEGIN
//    DELETE FROM spring_reply
//    WHERE no = pNo;
//    COMMIT;
//END;
	public void replyDelete(int no) {
		try {
			getConnection();
			String sql = "{Call replyDelete(?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1, no);
			cs.executeQuery();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
	}
}
