package com.sist.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class NoticeVO {
	private int no, hit;
	private String name, subject, dbday;
	private Date regdate;
}
