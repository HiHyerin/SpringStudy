package com.sist.spring3;
// 클래스 관리자(컨테이너) => 스프링에서 이미 제작됨
import java.util.*;
public class ApplicationContext {
	private Map clsMap = new HashMap();
	public ApplicationContext() {
		clsMap.put("amodel", new AModel());
		clsMap.put("bmodel", new BModel());
		clsMap.put("cmodel", new CModel());
	}
	public Object getBean(String key) {
		return clsMap.get(key);
	}
}
