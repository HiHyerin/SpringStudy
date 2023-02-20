package com.sist.aop;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
/*
 	AOP의 적용 부분
 	@Transactional()
 	public List<MovieVO> movieListData(){
 		List<MovieVO> list = new ArrayList<MovieVO>();
 		try{
 			getConnection() => Before
 			----------------------
 				around	=> setAutoCommit(false)
 				오라클 처리
 				around => commit()
 			----------------------
 		}catch(){
 			오류처리 => rollback()
 			ex.printStackTrace() => afterThrowing
 		}finally{
 			오라클 닫기
 			disConnection()	=> after
 		}
 		return	=> afterReturning
 	}
 */
import com.sist.model.*;

import lombok.Setter;
public class ModelAspect {
	@Setter
	private EmpDAO dao;
	
	public void before() {
		System.out.println("before Call..:시작 전");
		dao.getConnection();
	}
	
	public void after() {
		System.out.println("after Call..:finally");
		dao.disConnection();
	}
	/*
	 	@before 위치
	 	try{
	 		================= around시작
	 		소스코딩
	 		================= around 끝
	 	}catch(exception ex){
	 		@afterThrowing : 오류 발생 시 처리
	 	}finally{
	 		@after
	 	}
	 	
	 	return afterReturning : 정상 수행 시 처리
	 */
	
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("around Call..:try위 ~try종료 전");
		Object obj = null;
		// 수행시간 계산
		long start = 0;
		long end = 0;
		try {
			start = System.currentTimeMillis();
			System.out.println("Client 요청 메소드"+jp.getSignature().getName());
			obj = jp.proceed(); //메소드 호출
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			end = System.currentTimeMillis();
			System.out.println("수행시간 : "+(end-start)); // 통계
		}
		return obj;
	}
	
	public void afterReturning(Object obj) throws Throwable{
		// 결과값을 받아서 출력	=> web에서 return값을 먼저 처리 => 자동 로그인, id저장..., 권한
		System.out.println("afterReturning Call..");
		List<EmpVO> list = (List<EmpVO>)obj;
		for(EmpVO vo:list) {
			System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getJob());
		}
		
	}
	
	public void afterThrowing(Throwable ex) throws Throwable{
		System.out.println("afterThrowing Call..");
		// catch수행
		System.out.println(ex.getMessage()); // web => alert
	}
}
