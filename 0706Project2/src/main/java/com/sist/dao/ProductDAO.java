package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sist.common.CreateDataBase;

import com.sist.vo.*;

public class ProductDAO {
	private Connection conn;
	private PreparedStatement ps;
	private CreateDataBase db=new CreateDataBase();
	private static ProductDAO dao;
	public static ProductDAO newInstance()
	{
		if(dao==null)
			dao=new ProductDAO();
		return dao;
	}
	
	// random page
	public List<ProductVO> randomProductList()
	{
		List<ProductVO> plist=new ArrayList<ProductVO>();
		try
		{
			conn=db.getConnection();
			// 메인페이지 더보기 거기에 랜덤하게 출력해주기
			String sql="SELECT poster,title,score,first_pri,pdno "
					+ "FROM (SELECT poster,title,score,first_pri,pdno FROM product_detail "
					+ "ORDER BY DBMS_RANDOM.RANDOM)"
					+ "WHERE rownum <=4 ";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ProductVO vo=new ProductVO();
				
				
				vo.setPoster(rs.getString(1));
				vo.setTitle(rs.getString(2));
				vo.setScore(rs.getDouble(3));
				vo.setFirst_pri(rs.getString(4));
				vo.setPdno(rs.getInt(5));
				plist.add(vo);
			}
			rs.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			db.disConnection(conn, ps);
		}
	
		return plist;
	}
}
