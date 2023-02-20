package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

/*
	이름     널?       유형             
------ -------- -------------- 
NO     NOT NULL NUMBER         
TITLE  NOT NULL VARCHAR2(1000) 
POSTER NOT NULL VARCHAR2(260)  
CHEF   NOT NULL VARCHAR2(200)  
LINK            VARCHAR2(260)  
HIT             NUMBER         
*/
@Getter
@Setter
public class RecipeVO {
	private int no;
	private String title, chef;
}
