package com.sist.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/*
NO int 
TITLE text 
POSTER text 
CHEF text 
LINK text 
HIT int
 */
@Entity
@Table(name="recipe")
@Getter
@Setter
public class RecipeEntity {
	@Id
	private int no;
	
	private String title, poster, chef, link;
	private int hit;
}
