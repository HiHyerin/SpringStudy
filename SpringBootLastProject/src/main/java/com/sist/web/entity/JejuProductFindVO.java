package com.sist.web.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JejuProductFindVO {
	private int pno;
	private int like_count;
	private String detail, poster, title, location, content;
	private int curpage, totalpage;
}
