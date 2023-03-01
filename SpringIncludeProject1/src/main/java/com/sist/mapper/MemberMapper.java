package com.sist.mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface MemberMapper {
	@Insert("insert into spring_member values(#{id},#{pwd},#{name})")
	public void memberInsert(MemberVO vo);
	
	// 로그인 처리
	@Select("select count(*) from spring_member "
			+ "where id=#{id}")
	public int memberIdCheck(String id); 
	
	
	@Select("select id,pwd,name from spring_member "
			+ "where id=#{id}")
	public MemberVO memberPwdCheck(String id);
	
}
