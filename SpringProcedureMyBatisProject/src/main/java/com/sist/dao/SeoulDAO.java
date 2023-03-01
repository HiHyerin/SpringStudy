package com.sist.dao;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
@Repository
public class SeoulDAO {
	@Autowired
	private SeoulMapper mapper;
//	@Select("{CALL seoulLocationListData(#{pStart,mode=IN,javaType=java.lang.Integer},#{pEnd,mode=IN,javaType=java.lang.Integer},#{pResult, mode=OUT, jdbcType=CURSOR,resultMap=seoulMap})}")
//	@Options(statementType = StatementType.CALLABLE)
	public List<SeoulVO> seoulListData(Map map){
		mapper.seoulListData(map);
		return (List<SeoulVO>)map.get("pResult");
	}
	
//	@Select("{CALL seoulLocationDetailData(#{pNo,mode=IN,javaType=java.lang.Integer},#{pResult,mode=OUT, jdbcType=CURSOR,resultMap=seoulMap})}")
//	@Options(statementType = StatementType.CALLABLE)
	public SeoulVO seoulDetailData(Map map) {
		mapper.seoulDetailData(map);
		return (SeoulVO)map.get("pResult");
	}
	
//	@Select("{CALL seoulLocationTotalPage(pTotal,mode=OUT,javaType=java.lang.Integer)}")
//	@Options(statementType = StatementType.CALLABLE) // preparedStatement(sql문장 전송), callable(프로시저 호출)
	public int seoulTotalPage(Map map) {
		
		return mapper.seoulTotalPage();
	}
}
