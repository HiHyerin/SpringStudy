package com.sist.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/*
 NO         NUMBER         
TITLE      VARCHAR2(200)  
URL        VARCHAR2(1000) 
POSTER     VARCHAR2(1000) 
IMAGE      CLOB           
ADDR       VARCHAR2(500)  
ADDR2      VARCHAR2(500)  
TEL        VARCHAR2(100)  
TYPE       VARCHAR2(100)  
PARKING    VARCHAR2(100)  
TIME       VARCHAR2(500)  
MENU       VARCHAR2(2000) 
SCORE      VARCHAR2(50)   
HIT        NUMBER 
 */
@Entity
@Table(name="jeju_food")
@Getter
@Setter
public class JejuFoodEntity {
	@Id
	private int no;
	private int hit;
	private String title, url, poster, image, addr, addr2, tel, type, parking,
				time, menu, score;
}
