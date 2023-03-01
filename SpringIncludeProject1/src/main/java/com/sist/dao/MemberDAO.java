package com.sist.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.vo.*;
import com.sist.dao.*;
import com.sist.mapper.MemberMapper;
@Repository
public class MemberDAO {
	@Autowired
	private MemberMapper mapper;
	
//	@Insert("insert into spring_member values(#{id},#{pwd},#{name}")
	public void memberInsert(MemberVO vo) {
		mapper.memberInsert(vo);
	}
	
	// 로그인 처리
//	@Select("select count(*) from spring_member "
//			+ "where id=#{id}")
	public int memberIdCheck(String id) {
		return mapper.memberIdCheck(id);
	}
	
	
//	@Select("select id,pwd,name from spring_member "
//			+ "where id=#{id}")
	public MemberVO memberPwdCheck(String id) {
		return mapper.memberPwdCheck(id);
	}
}
