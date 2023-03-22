package com.sist.board.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.Getter;
import lombok.Setter;

@Entity(name="board")
@Getter
@Setter
public class BoardEntity {
	@Id // 중복이 없는 속성
	private int no;
	private String name, subject, content, pwd;
	private int hit;
	private LocalDateTime regdate;

	@PrePersist
	public void regdate() {
		this.regdate=LocalDateTime.now();
	}
}
