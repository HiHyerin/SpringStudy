package com.sist.web.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/*
 	Table: board
Columns:
no int AI PK 
name varchar(34) 
subject varchar(1000) 
content text 
pwd varchar(10) 
regdate datetime 
hit int
 */
@Entity
@Table(name="board")
@Getter
@Setter
public class BoardEntity {
	@Id // id를 주면 자동 번호 증가
	private int no;
	private String name, subject, content, pwd, regdate;
	private int hit;
	
	@PrePersist
	public void regdate() {
		this.regdate=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
	}
	
}
