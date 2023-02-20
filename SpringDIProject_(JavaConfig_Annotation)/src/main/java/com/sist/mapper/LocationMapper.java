package com.sist.mapper;
	//private String title, addr, price;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface LocationMapper {
	@Select("select title, addr, price FROM jejuLocation")
	public List<JejuLocationVO> locationListData();
}
