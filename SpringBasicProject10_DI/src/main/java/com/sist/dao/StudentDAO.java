package com.sist.dao;
import java.util.*;

import org.mybatis.spring.support.SqlSessionDaoSupport;
public class StudentDAO extends SqlSessionDaoSupport {
	// 1. 데이터 추가
	/*
	  	 <insert id="studentInsert" parameterType="StudentVO">
 	
			 	<selectKey keyProperty="hakbun" resultType="int" order="BEFORE"> <!-- 시퀀스 --> 
			 		SELECT NVL(MAX(hakbun)+1,1) as hakbun FROM student 
			 	</selectKey>
			 	INSERT INTO student VALUES(#{hakbun},#{name},#{kor},#{eng},#{math}) <!-- #{keyProperty} -->
			 	
 		</insert>
	 
	 */
	public void studentInsert(StudentVO vo) {
		getSqlSession().insert("studentInsert",vo);
	}
	
	
	/*
	 	<select id="studentlistData" resultType="StudentVO">
		  	<include refid="select-data" />
		 </select>
	 */
	public List<StudentVO> studentListData(){
		return getSqlSession().selectList("studentListData");
	}
	
	
	
	/*
	 	<!-- 데이터 검색 -->
		 <select id="studentDetailData" resultType="StudentVO" parameterType="int"></select>
		 SELECT hakbun, name, kor, eng, math, (kor+eng+math) as total, ROUND((kor+eng+math)/3.0,2) as avg
		 FROM student
		 WHERE hakbun=#{hakbun}
	 */
	public StudentVO studentDetailData(int hakbun) {
		return getSqlSession().selectOne("studentDetailData",hakbun);
	}
	
	
	/*
 	 <!-- 데이터 수정 -->
		 <update id="studentUpdate" parameterType="StudentVO">
		 	UPDATE student SET
		 	kor=#{kor}, eng=#{eng}, math=#{math}
		 	where hakbun=#{hakbun}
		 </update>
	 */
	public void studentUpdate(StudentVO vo) {
		getSqlSession().update("studentUpdate",vo);
	}
	
	
	
	/*
 	 <!-- 데이터 삭제 -->
		 <delete id="studentDelete" parameterType="int">
		 	DELETE FROM student
		 	WHERE hakbun = #{hakbun}
		 </delete>
	 */
	public void studentDelete(int hakbun) {
		getSqlSession().delete("studentDelete",hakbun);
	}
}
