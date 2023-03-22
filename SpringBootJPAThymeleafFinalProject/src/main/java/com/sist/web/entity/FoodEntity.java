package com.sist.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/*
 	Table: project_food
Columns:
FNO int 
CNO int 
POSTER text 
NAME text 
SCORE double 
ADDRESS text 
TEL text 
TYPE text 
PRICE text 
PARKING text 
TIME text 
MENU text 
JJIM_COUNT int 
LIKE_COUNT int 
HIT int 
GOOD int 
SOSO int 
BAD int
 */
@Entity
@Table(name="project_food") // 테이블 이름
@Getter
@Setter
public class FoodEntity {
	@Id
	private int fno;
	
	private int cno, jjim_count, like_count, hit, good, soso, bad;
	private String poster, name, address, type, tel, price, parking, time, menu;
	private double score;
}
