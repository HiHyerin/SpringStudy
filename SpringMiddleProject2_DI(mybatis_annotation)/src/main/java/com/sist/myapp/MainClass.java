package com.sist.myapp;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;

import lombok.Setter;
public class MainClass {
	@Setter
	private SeoulDAO dao;
	public static void main(String[] args) {
		String[] table = {"","seoul_location","seoul_nature","seoul_shop"};
		Scanner scan = new Scanner(System.in);
		System.out.print("테이블 선택: ");
		int no = scan.nextInt();
		//스프링 연결
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		
		// 스프링에 들어있는 메인클래스 객체에만 정보가 들어있음
		MainClass mc = (MainClass)app.getBean("mc"); // 스프링에서 생성된 객체를 읽어서 사용(세팅이 완료된 상태)
		// MainClass mc = new MainClass(); 새로운 객체생성 안됨 => 결합성이 높아져서 다른 클래스에 영향을 준다
		// 싱글턴 메모리 1개 사용, 모든 클래스에서 재사용이 가능, 다른 클래스에 영향력이 없다(스프링 => 독립적인 클래스)
		// 결합성이 낮은 프로그램 (유지보수가 편리하게, 분업일 경우..) , 형식이 동일(구조)
		
		Map map = new HashMap();
		map.put("seoul_tbl", table[no]);
		List<SeoulVO> list =  mc.dao.seoulListData(map);
		for(SeoulVO vo:list) {
			System.out.println(vo.getNo()+"."+vo.getTitle());
		}
		
		System.out.println("-=====================");
		System.out.print("상세로 볼 번호 입력: ");
		int i = scan.nextInt();
		map.put("seoul_tbl", table[no]);
		map.put("no", i);
		SeoulVO vo = mc.dao.seoulDetailData(map);
		System.out.println("번호: "+vo.getNo());
		System.out.println("제목: "+vo.getTitle());
		System.out.println("주소: "+vo.getAddress());
		System.out.println("상세: "+vo.getMsg());
	}
}
