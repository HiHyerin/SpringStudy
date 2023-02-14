package com.sist.spring3;
// Ŭ���� ������(�����̳�) => ���������� �̹� ���۵�
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
