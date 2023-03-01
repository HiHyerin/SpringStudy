package com.sist.vo;
import java.util.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class ReplyVO {
	private int no, rno, type;
	private String id, name, msg, dbday;
	private Date regdate;
}
