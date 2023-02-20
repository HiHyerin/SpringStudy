package com.sist.proxy;

public class MainClass {

	public static void main(String[] args) {
		MovieDAO dao = new MovieDAO();
		dao.movieListData();
		
		Proxy p = new Proxy(dao);
		p.movieList();

	}

}
