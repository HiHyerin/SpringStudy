package com.sist.main;
import java.util.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.*;
public class ClassPathXmlApplicationContext implements ApplicationContext{
     private Map clsMap=new HashMap();
     public ClassPathXmlApplicationContext(String path)
     {
    	 try
    	 {
    		 SAXParserFactory spf=SAXParserFactory.newInstance();
    		 SAXParser sp=spf.newSAXParser();
    		 XMLParse xm=new XMLParse();
    		 sp.parse(new File(path), xm);
    		 clsMap=xm.getMap();
    	 }catch(Exception ex) {}
     }
	@Override
	public Object getBean(String key) {
		// TODO Auto-generated method stub
		return clsMap.get(key);
	}
}