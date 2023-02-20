package com.sist.vo;
/*
이름          널?       유형             
----------- -------- -------------- 
FNO         NOT NULL NUMBER         
NAME        NOT NULL VARCHAR2(1000) 
SCORE       NOT NULL NUMBER(2,1)    
ADDRESS     NOT NULL VARCHAR2(1000) 
TEL         NOT NULL VARCHAR2(20)   
TYPE        NOT NULL VARCHAR2(50)   
PRICE                VARCHAR2(60)   
TIME                 VARCHAR2(60)   
PARKING              VARCHAR2(60)   
MENU                 VARCHAR2(1000) 
HIT                  NUMBER         
POSTER               VARCHAR2(2000) 
RESERVE_DAY          VARCHAR2(100)  
*/

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodVO {
	private int fno;
	private String name, price, type;
}
