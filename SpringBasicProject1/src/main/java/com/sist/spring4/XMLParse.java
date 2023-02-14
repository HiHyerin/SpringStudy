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
			// <bean id="a" class="com.sist.spring4.AModel"/> : ������������ ����
			if(qName.equals("bean")) {
				String id = attributes.getValue("id");
				String cls=attributes.getValue("class");
				Class className = Class.forName(cls);
				Object obj = className.getDeclaredConstructor().newInstance(); // ��ü ����
				
				map.put(id, obj); // �޸� �Ҵ� ��
				// �츮�� �ڵ��ϴ� ������ �ƴϰ� ������ ���۰����� �����ϱ� ���� ���°ž�
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}
