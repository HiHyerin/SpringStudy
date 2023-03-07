package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodVO {
	private int fno, cno, good, soso, bad, count, jjim_count, like_count, hit;
	private double score;
	private String poster,name,address,tel,type,price,parking,menu,time;
}
