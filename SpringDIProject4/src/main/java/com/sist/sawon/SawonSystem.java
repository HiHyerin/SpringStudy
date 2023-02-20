package com.sist.sawon;
import java.util.*;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class SawonSystem {
	private List<Sawon> list = new ArrayList<Sawon>();
	public void print() {
		for(Sawon s:list) {
			System.out.println(s.getSabun()+" "+s.getName()+" "
					+ s.getDept() + " "+ s.getJob() + " "+s.getLoc());
		}
	}
}
