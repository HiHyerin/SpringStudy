package com.sist.food.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity(name="project_category")
@Getter
@Setter
public class CategoryEntity {
	@Id
	private int cno;
	
	private String title;
	private String subject;
	private String poster;
	private String link;
	
}
