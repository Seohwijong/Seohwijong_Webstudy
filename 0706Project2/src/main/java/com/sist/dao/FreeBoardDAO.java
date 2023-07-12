package com.sist.dao;

import java.util.*;
import java.sql.*;
import com.sist.vo.*;
import com.sist.common.*;

public class FreeBoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	private CreateDataBase db = new CreateDataBase();
	private static FreeBoardDAO dao;
	
	//싱글턴
	public static FreeBoardDAO newInstance() {
		if(dao==null) {
			dao = new FreeBoardDAO();
		}
		return dao;
	}
	
	//기능
	//1. 목록 출력
	public List<FreeBoardVO> freeboardListData(int page) {
		List<FreeBoardVO> list = new ArrayList<FreeBoardVO>();
		
		try {
			conn=db.getConnection();
			String sql = "SELECT bno,name,subject,TO_CHAR(regdate,'yyyy-mm-dd'),hit,suggest,rownum "
					+ "FROM (SELECT bno,name,subject,regdate,hit,suggest,rownum as num "
					+ "FROM (SELECT /*+ INDEX_DESC(yori_freeboard yf_bno_pk)*/bno,name,subject,regdate,hit,suggest "
					+ "FROM yori_freeboard)) "
					+ "WHERE num BETWEEN ? AND ?";
			ps = conn.prepareStatement(sql);
			
			int rowSize = 8;
			int start = (rowSize*page)-(rowSize-1);
			int end = rowSize*page;
			
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				FreeBoardVO vo = new FreeBoardVO();
				vo.setBno(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setSubject(rs.getString(3));
				vo.setDbday(rs.getString(4));
				vo.setHit(rs.getInt(5));
				vo.setSuggest(rs.getInt(6));
				vo.setRownum(rs.getInt(7));
				list.add(vo);
			}
			rs.close();		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.disConnection(conn, ps);
		}
		return list;
	}
	
	//1.1 총페이지
	public int freeboardTotalPage() {
		int total=0;
		try {
			conn=db.getConnection();
			String sql = "SELECT CEIL(COUNT(*)/8.0) FROM yori_freeboard";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			total = rs.getInt(1);
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.disConnection(conn, ps);
		}
		return total;
	}
}
