package com.sist.jeju.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name="jj_hotel")
/*
 HNO	int	YES		
ALL_CATE_NO	int	YES		
H_CRAWL_NO	int	YES		
GRADE	text	YES		
NAME	text	YES		
ADDR	text	YES		
INTRO	text	YES		
TIME	text	YES		
STAR	double	YES		
ACCOUNT	text	YES		
HOTEL_IMAGE	text	YES		
LIKE_COUNT	int	YES		
JJIM_COUNT	int	YES		
 */
@Getter
@Setter
public class JejuEntity {
	@Id
	private int hno;
	private int all_cate_no, h_crawl_no, like_count, jjim_count;
	private double star;
	private String grade, name, addr, intro, time, account, hotel_image;
}
