package com.sist.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/*
	Table: food_location
Columns:
FNO int 
NAME text 
SCORE double 
ADDRESS text 
TEL text 
TYPE text 
PRICE text 
TIME text 
PARKING text 
MENU text 
HIT int 
POSTER text
 */
@Entity
@Table(name="food_location")
@Getter
@Setter
public class FoodLocationEntity {
	@Id
	private int fno;
	
	private int hit;
	private String poster, name, address, type, tel, price, parking, time, menu;
	private double score;
}
