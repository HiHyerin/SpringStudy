package com.sist.vo;
/*

이름                널?       유형             
----------------- -------- -------------- 
NO                NOT NULL NUMBER         
GOODS_NAME        NOT NULL VARCHAR2(1000) 
GOODS_SUB                  VARCHAR2(1000) 
GOODS_PRICE       NOT NULL VARCHAR2(50)   
GOODS_DISCOUNT             NUMBER         
GOODS_FIRST_PRICE          VARCHAR2(20)   
GOODS_DELIVERY    NOT NULL VARCHAR2(20)   
GOODS_POSTER               VARCHAR2(260)  
HIT                        NUMBER         
ACCOUNT                    NUMBER         
 */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoodsVO {
	private int no;
	private String goods_name, goods_price;
}
