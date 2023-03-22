package com.sist.vo;
//름     널?       유형
//------ -------- --------------
//NO     NOT NULL NUMBER
//POSTER          VARCHAR2(1000)
//TITLE           VARCHAR2(200)
//SINGER          VARCHAR2(100)
//ALBUM           VARCHAR2(200)
//OK              VARCHAR2(10)
//KEY             VARCHAR2(100)

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MusicVO {
	private int no;
	private String poster, title, singer, album, ok, key;
}
