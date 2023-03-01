package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class ReplyOrmDAO {
	@Autowired
	private ReplyMapper mapper;
	
//	@Select(value="{CALL replyList(#{pRno,mode=IN,jdbcType=INTEGER},#{pType, mode=IN,jdbcType=INTEGER},#{pResult, mode=OUT,jdbcType=CURSOR})}")
//	@Options(statementType = StatementType.CALLABLE)
	public List<ReplyVO> replyListData(Map map){
		mapper.replyListData(map);
		return (List<ReplyVO>)map.get("pResult");
	}
	
//	@Select(value="{CALL replyInsert(#{pRno, mode=IN, jdbcType=INTEGER},#{pType, mode=IN, jdbcType=INTEGER},#{pId, mode=IN, jdbcType=VARCHAR},"
//			+ "#{pName, mode=IN, jdbcType=VARCHAR},#{pMsg, mode=IN, jdbcType=CLOB})}")
	@Options(statementType = StatementType.CALLABLE)
	public void replyInsert(Map map) {
		mapper.replyInsert(map);
	}
	
//	@Select(value="{CALL replyUpdate(#{pNo, mode=IN, jdbcType=INTEGER},#{pMsg, mode=IN, jdbcType=CLOB})}")
//	@Options(statementType = StatementType.CALLABLE)
	public void replyUpdate(Map map) {
		mapper.replyUpdate(map);
	}
	
//	@Select(value="{CALL replyDelete(#{pNo, mode=IN, jdbcType=INTEGER})}")
//	@Options(statementType = StatementType.CALLABLE)
	public void replyDelete(Map map) {
		mapper.replyDelete(map);
	}
}
