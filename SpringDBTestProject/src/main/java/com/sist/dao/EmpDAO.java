package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
@Repository //DAO��� �ǹ� => Spring(�޸��Ҵ�)
public class EmpDAO {
	// Mapper = interface => ������ Ŭ������ �޴´�
	
	@Autowired //�ڵ����� Ŭ����? 
	private EmpMapper mapper;
	
	public List<EmpVO> empListData(){
		return mapper.empListData();
	}
}
