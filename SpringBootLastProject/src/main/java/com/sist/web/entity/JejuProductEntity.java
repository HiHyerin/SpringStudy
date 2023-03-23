package com.sist.web.entity;
/*
 	PNO int 
DETAIL text 
POSTER text 
TITLE text 
LOCATION text 
CONTENT text 
LIKE_COUNT int
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="jeju_product")
@Getter
@Setter
public class JejuProductEntity {
	@Id
	private int pno;
	private int like_count;
	private String detail, poster, title, location, content;
}
