package com.sist.mapper;
import java.util.*;

import com.sist.dao.EmpVO;
public interface EmpMapper {
	
	/*
 	<select id="empNameListData" resultType="string">
 				---------------		---------------
 				Method명(id)				리턴형
		select distinct ename from emp
	</select>
	=>
	@Select("select distinct ename from emp")
	 */
	
	public List<String> empNameListData(); // 메소드 명과 id가 같아야한다.
	
	/*
	 	 <select id="empInfoData" resultType="EmpVO" parameterType="hashmap">
	 	select * from emp
	 */
	public List<EmpVO> empInfoData(Map map);
	
	/* @Welect({"<script>"
	 	+"<trim prefix="where ename IN(\" suffix= \")" suffixOverrides=\")\" prefixOverrides=\"(\">"
	 		+" <foreach collection=\"names\" item=\"name\" close=\")\" separator=\",\">
	 		+"	#{name}
	 		+" </foreach>
	 	+" </trim>
	 	+"</script>
	 	=> 동적쿼리 사용할 때에는 이렇게 쓰는것보다 xml파일로 쓰는게 더 편하다.
	 			trim, foreach, if, choose, when
	 */
}
