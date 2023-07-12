package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sist.common.CreateDataBase;
import com.sist.vo.*;

public class FoodDAO {
	private Connection conn;
	private PreparedStatement ps;
	private CreateDataBase db=new CreateDataBase();
	private static FoodDAO dao;
	public static FoodDAO newInstance()
	{
		if(dao==null)
			dao=new FoodDAO();
		return dao;
	}
	
	// random page
	public List<FoodVO> randomFoodList()
	{
		List<FoodVO> flist=new ArrayList<FoodVO>();
		try
		{
			conn=db.getConnection();
			// 메인페이지 더보기 거기에 랜덤하게 출력해주기
			String sql="SELECT poster,title,score,price,fdno "
					+ "FROM (SELECT poster,title,score,price,fdno FROM food_detail "
					+ "ORDER BY DBMS_RANDOM.RANDOM)"
					+ "WHERE rownum <=4 ";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				FoodVO vo=new FoodVO();
				String poster= rs.getString(1);
				poster=poster.substring(0,poster.indexOf("^"));
				poster=poster.replace("#", "&");
				vo.setPoster(poster);
				vo.setTitle(rs.getString(2));
				vo.setScore(rs.getDouble(3));
				vo.setPrice(rs.getString(4));
				vo.setFdno(rs.getInt(5));
				flist.add(vo);
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
	
		return flist;
	}
	public List<FoodVO> foodListData(int page)
	{
		List<FoodVO> flist=new ArrayList<FoodVO>();
		try
		{
			conn=db.getConnection();
			String sql="SELECT poster,title,score,price,fdno,num "
					+ "FROM (SELECT poster,title,score,price,fdno,rownum as num "
					+ "FROM (SELECT /*+INDEX_ASC(food_detail fd_fdno_pk)*/poster,title,score,price,fdno "
					+ "FROM food_detail))"
					+ "WHERE num BETWEEN ? AND ?";
				ps=conn.prepareStatement(sql);
				int rowSize=12;
				int start=(rowSize*page)-(rowSize-1);
				int end=rowSize*page;
				ps.setInt(1, start);
				ps.setInt(2, end);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					FoodVO vo=new FoodVO();
					String poster= rs.getString(1);
					poster=poster.substring(0,poster.indexOf("^"));
					poster=poster.replace("#", "&");
					vo.setPoster(poster);
					vo.setTitle(rs.getString(2));
					vo.setScore(rs.getDouble(3));
					vo.setPrice(rs.getString(4));
					vo.setFdno(rs.getInt(5));
					flist.add(vo);
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
		return flist;
	}
	public int shareTotalPage()
	{
		int totalpage=0;
		try
		{
			conn=db.getConnection();
			String sql="SELECT CEIL(COUNT(*)/12.0) FROM food_detail";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next(); 
			totalpage=rs.getInt(1);
			rs.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			db.disConnection(conn, ps);
		}
		return totalpage;
	}
	
}
