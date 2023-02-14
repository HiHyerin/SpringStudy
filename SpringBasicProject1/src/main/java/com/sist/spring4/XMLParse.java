package com.sist.spring4;

import org.apache.commons.collections.map.HashedMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;
public class XMLParse extends DefaultHandler{
	private Map map = new HashMap();

	public Map getMap() {
		return map;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		try {
			// <bean id="a" class="com.sist.spring4.AModel"/> : 스프링에서는 제작
			if(qName.equals("bean")) {
				String id = attributes.getValue("id");
				String cls=attributes.getValue("class");
				Class className = Class.forName(cls);
				Object obj = className.getDeclaredConstructor().newInstance(); // 객체 생성
				
				map.put(id, obj); // 메모리 할당 끝
				// 우리가 코딩하는 영역은 아니고 스프링 동작과정을 설명하기 위해 쓰는거야
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}
