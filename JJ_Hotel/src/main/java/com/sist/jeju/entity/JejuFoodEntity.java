package com.sist.jeju.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/*
 	Table: jeju_food
Columns:
NO int 
TITLE text 
URL text 
POSTER text 
IMAGE text 
ADDR text 
ADDR2 text 
TEL text 
TYPE text 
PARKING text 
TIME text 
MENU text 
SCORE double 
HIT int
 */
@Entity(name = "jeju_food")
@Getter
@Setter
public class JejuFoodEntity {
	@Id
	private int no;
	private int hit;
	private double score;
	private String title, url, poster, image, addr, addr2, tel, type, parking, time, menu;
}
