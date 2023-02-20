package com.sist.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import com.sist.dao.*;
@Component
public class MainClass {
   @Autowired
   private MyDAO dao;
   
   public static void main(String[] args) {
      ApplicationContext app=
            new ClassPathXmlApplicationContext("app.xml");
      MainClass mc=(MainClass)app.getBean("mainClass");
      mc.dao.select();
      mc.dao.delete();
      String msg=mc.dao.find("홍길동");
      System.out.println(msg);

   }

}