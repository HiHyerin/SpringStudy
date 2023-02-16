package com.sist.vo;
// 어노테이션 x

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieVO {
	private int rank;
	private String title, director, genre;
}
