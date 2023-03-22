package com.sist.mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.MemberVO;

public interface MemberMapper {
	// 로그인 처리
	@Select("select count(*) from spring_join "
			+ "where id=#{id}")
	public int memberIdCheck(String id);

	@Select("select id, pwd, name, admin from spring_join "
			+ "where id=#{id}")
	public MemberVO memberLogin(String id);
	
	// JOIN
	@Insert("insert into spring_join values("
			+ "#{id}, #{pwd}, #{name}, 'n')")
	public void memberInsert(MemberVO vo);
}
