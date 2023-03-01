package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

/*
 	이름      널? 유형
------- -- --------------
NO         NUMBER
TITLE      VARCHAR2(200)
URL        VARCHAR2(1000)
POSTER     VARCHAR2(1000)
IMAGE      CLOB
ADDR       VARCHAR2(500)
ADDR2      VARCHAR2(500)
TEL        VARCHAR2(100)
TYPE       VARCHAR2(100)
PARKING    VARCHAR2(100)
TIME       VARCHAR2(500)
MENU       VARCHAR2(2000)
SCORE      VARCHAR2(50)
HIT        NUMBER
 */
@Getter
@Setter
public class JejuFoodVO {
	private int no, hit;
	private String title, url, poster, image, addr, addr2, tel, type, parking;
	private String time, menu, score;

}
