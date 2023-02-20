package com.sist.model;
import java.util.*;
import java.sql.*;
public class EmpDAO {
	private Connection conn;
	private PreparedStatement ps;
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	public EmpDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
		}
		
	}
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url,"hr","happy");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void disConnection() {
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List<EmpVO> empListData(){
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			// getConnection 들어가는 자리 => before
			String sql = "select empno, ename, job, sal, hiredate "
					+"from emp";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getNString(3));
				vo.setSal(rs.getInt(4));
				vo.setHiredate(rs.getDate(5));
				list.add(vo);
			}
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// disConnection() 들어가는 자리 => after
		
		return list;
	}
}
