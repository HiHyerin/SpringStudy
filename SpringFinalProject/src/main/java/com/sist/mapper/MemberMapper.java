package com.sist.mapper;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.MemberVO;

public interface MemberMapper {
	@Select("select count(*) from chat_member "
			+ "where id=#{id}")
	public int memberIdCheck(String id);

	@Select("select id, pwd, name from chat_member "
			+ "where id=#{id}")
	public MemberVO memberLogin(String id);
}
