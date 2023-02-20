package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.dao.StudentVO;
public interface StudentMapper {
	@Select("select hakbun, name, kor, eng, math from student")
	public List<StudentVO> studentListData();
	
	@Insert("insert into student values(#{hakbun},#{name},#{kor},#{eng},#{math})")
	public void studentInsert(StudentVO vo);
}


