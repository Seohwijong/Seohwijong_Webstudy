package com.sist.dao;
import java.util.*;
import java.sql.*;

import com.sist.common.CreateDataBase;
import com.sist.dao.*;
import javax.sql.*;
import javax.naming.*;
import com.sist.vo.*;
public class RecipeDAO {
	private Connection conn;
	private PreparedStatement ps;
	private CreateDataBase db=new CreateDataBase();
	private static RecipeDAO dao;
	
	// 연결

	/* 페이지 나누기
	 *  1. listData -> inline view
	 *   -> 페이지 번호랑 , 페이징 -> total page  count; 
	 */
	public static RecipeDAO newInstance()
	{
		if(dao==null)
			dao=new RecipeDAO();
		return dao;
	}
	public List<RecipeVO> recipeListData(int page)
	{
		List<RecipeVO> list=new ArrayList<RecipeVO>();
		try
		{
			conn=db.getConnection();
			String sql="SELECT rdno,poster,title,chef,chef_pos,num "
					+ "FROM (SELECT rdno,poster,title,chef,chef_pos,rownum as num "
					+ "FROM (SELECT /*+INDEX_ASC(recipe_d rd_rdno_pk)*/rdno,poster,title,chef,chef_pos "
					+ "FROM recipe_d))"
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
					RecipeVO vo=new RecipeVO();
					vo.setRdno(rs.getInt(1));
					vo.setPoster(rs.getString(2));
					vo.setTitle(rs.getString(3));
					vo.setChef(rs.getString(4));
					vo.setChef_pos(rs.getString(5));
					list.add(vo);
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
		return list;
	}
	public int recipeTotalPage(String type)
	{
		int totalpage=0;
		try
		{
			conn=db.getConnection();
			String sql="SELECT CEIL((SELECT COUNT(*) FROM recipe_d WHERE rdno BETWEEN ? AND ?)/12.0) FROM recipe_d";
			ps=conn.prepareStatement(sql);
			if(type.equals("soup"))
			{
				ps.setInt(1, 1);
				ps.setInt(2, 10000);
			}
			else if(type.equals("maindish"))
			{
				ps.setInt(1, 10001);
				ps.setInt(2, 20000);
			}
			else if(type.equals("sidedish"))
			{
				ps.setInt(1,20001 );
				ps.setInt(2,29998 );
			}
			else if(type.equals("all"))
			{
				ps.setInt(1,1 );
				ps.setInt(2,29998 );
			}
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
	// random page
	public List<RecipeVO> randomRecipeList()
	{
		List<RecipeVO> rlist=new ArrayList<RecipeVO>();
		try
		{
			conn=db.getConnection();
			// 메인페이지 더보기 거기에 랜덤하게 출력해주기
			String sql="SELECT poster,title,chef,chef_pos,rdno "
					+ "FROM (SELECT poster,title,chef,chef_pos,rdno FROM recipe_d "
					+ "ORDER BY DBMS_RANDOM.RANDOM)"
					+ "WHERE rownum <=4 ";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				RecipeVO vo=new RecipeVO();
				vo.setPoster(rs.getString(1));
				vo.setTitle(rs.getString(2));
				vo.setChef(rs.getString(3));
				vo.setChef_pos(rs.getString(4));
				vo.setRdno(rs.getInt(5));
				rlist.add(vo);
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
	
		return rlist;
	}
	public RecipeVO recipeDetailData(int rdno)
	{
		RecipeVO vo=new RecipeVO();
		try
		{
			/*
			 *    rdno      number        NOT NULL,
				  title     varchar2(200) NOT NULL,
				  poster     VARCHAR2(260) NOT NULL,
				  chef      varchar2(100) NOT NULL,
				  chef_pos  varchar2(260) ,
				  content   clob, --content
				  info_1    varchar2(50)  , --
				  info_2    varchar2(50)  , --
				  info_3    varchar2(50)  , --
				  chef_info varchar2(500),
				  step_pos clob ,
				  step_text clob ,
			 */
			conn=db.getConnection();
			String sql="SELECT * from recipe_d "
					+ "WHERE rdno=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, rdno);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setRdno(rs.getInt(1));
			vo.setTitle(rs.getString(2));
			vo.setPoster(rs.getString(3));
			vo.setChef(rs.getString(4));
			vo.setChef_pos(rs.getString(5));
			vo.setContent(rs.getString(6));
			vo.setInfo_1(rs.getString(7));
			vo.setInfo_2(rs.getString(8));
			vo.setInfo_3(rs.getString(9));
			vo.setChef_info(rs.getString(10));
			String step_pos=rs.getString(11);
			if(rs.getString(11)==null)
			{
				vo.setStep_pos(" ");
			}
			else
			{
				vo.setStep_pos(step_pos);
			}
			
			vo.setStep_text(rs.getString(12));
			rs.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			db.disConnection(conn, ps);
		}
		return vo;
		
	}
	public List<RecipeVO> recipeCategoryDataList(String type,int page)
	{
		List<RecipeVO> list=new ArrayList<RecipeVO>();
		// 1~ 10000 국.탕
		// 10001 ~ 20000 메인반찬
		// 20001~ 마지막 사이드반찬
		try
		{
			conn=db.getConnection();
			String sql="SELECT rdno,poster,title,chef,chef_pos,num "
					+ "FROM (SELECT rdno,poster,title,chef,chef_pos,rownum as num "
					+ "FROM (SELECT /*+INDEX_ASC(recipe_d rd_rdno_pk)*/rdno,poster,title,chef,chef_pos "
					+ "FROM recipe_d WHERE rdno BETWEEN ? AND ?))"
					+ "WHERE num BETWEEN ? AND ?";
				ps=conn.prepareStatement(sql);
				int rowSize=12;
				int start=(rowSize*page)-(rowSize-1);
				int end=rowSize*page;
				if(type.equals("soup"))
				{
					ps.setInt(1, 1);
					ps.setInt(2, 10000);
				}
				else if(type.equals("maindish"))
				{
					ps.setInt(1, 10001);
					ps.setInt(2, 20000);
				}
				else if(type.equals("sidedish"))
				{
					ps.setInt(1,20001 );
					ps.setInt(2,29998 );
				}
				else if(type.equals("all"))
				{
					ps.setInt(1,1 );
					ps.setInt(2,29998 );
				}
				ps.setInt(3, start);
				ps.setInt(4, end);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					RecipeVO vo=new RecipeVO();
					vo.setRdno(rs.getInt(1));
					vo.setPoster(rs.getString(2));
					vo.setTitle(rs.getString(3));
					vo.setChef(rs.getString(4));
					vo.setChef_pos(rs.getString(5));
					list.add(vo);
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
		
		return list;
	}
}
