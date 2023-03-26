package com.sist.web.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JejuFindVO {
	private int no;
	private String title, poster;
	private int curpage, totalpage;
}
