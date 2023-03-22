package com.sist.vo;
/*
 	이름      널?       유형           
------- -------- ------------ 
RNO     NOT NULL NUMBER       
CATE_NO          NUMBER       
NO               NUMBER       
ID               VARCHAR2(20) 
NAME    NOT NULL VARCHAR2(34) 
MSG     NOT NULL CLOB         
REGDATE          DATE
 */

import java.util.Date;
import java.util.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ReplyVO {
	private int rno, type, no;
	private String id, name, msg, dbday;
	private Date regdate;
}
