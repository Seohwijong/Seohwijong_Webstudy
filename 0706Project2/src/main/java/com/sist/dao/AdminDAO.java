package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sist.common.CreateDataBase;
import com.sist.vo.FreeBoardVO;
import com.sist.vo.MemberVO;
import com.sist.vo.ProductVO;

import java.util.*;

public class AdminDAO {
	private Connection conn;
	private PreparedStatement ps;
	private CreateDataBase db=new CreateDataBase();
	private static AdminDAO dao;
	public static AdminDAO newInstance()
	{
		if(dao==null)
			dao=new AdminDAO();
		return dao;
	}
	public List<MemberVO> userInfo()
	{
		List<MemberVO> list=new ArrayList<MemberVO>();
		try
		{
			conn=db.getConnection();
			String sql="SELECT id,name,nickname,sex,birthday,email,post,addr1 "
					+ "FROM project_member";
			ps=conn.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				MemberVO vo=new MemberVO();
				vo.setId(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setNickname(rs.getString(3));
				vo.setSex(rs.getString(4));
				vo.setBirthday(rs.getString(5));
				vo.setEmail(rs.getString(6));
				vo.setPost(rs.getString(7));
				vo.setAddr1(rs.getString(8));
	//			vo.setAddr2(rs.getString(9));
	//			vo.setPhone(rs.getString(10));
				list.add(vo);
			}
			rs.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			db.disConnection(conn, ps);
		}
		return list;
	}
	
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	public List<ProductVO> ProductListManager(int page)
	{
		List<ProductVO> plist=new ArrayList<ProductVO>();
		try
		{
			conn=db.getConnection();
			// 메인페이지 더보기 거기에 랜덤하게 출력해주기
			String sql="SELECT pdno,title,poster,subject,sale,priced_sale,original_pri,first_pri,score,delivery_pri,goods_count "
					+ "FROM product_detail WHERE pdno BETWEEN ? AND ?";
			ps=conn.prepareStatement(sql);
			int rowSize=20;
			int startPage=(rowSize*page)-(rowSize-1);
			int endPage=rowSize*page;
			ps.setInt(1, startPage);
			ps.setInt(2, endPage);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ProductVO vo=new ProductVO();
				vo.setPdno(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setPoster(rs.getString(3));
				vo.setSubject(rs.getString(4));
				vo.setSale(rs.getString(5));
				vo.setPriced_sale(rs.getString(6));
				vo.setOriginal_pri(rs.getString(7));
				vo.setFirst_pri(rs.getString(8));
				vo.setScore(rs.getDouble(9));
				vo.setDelivery_pri(rs.getString(10));
				vo.setGoods_count(rs.getInt(11));
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
	public int adminProductTotalPage()
	{
		int totalpage=0;
		try
		{
			conn=db.getConnection();
			
			String sql="SELECT CEIL(COUNT(*)/20.0) FROM product_detail";	
			
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
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public List<FreeBoardVO> boardManagerListData(int page) {
		List<FreeBoardVO> list = new ArrayList<FreeBoardVO>();
		
		try {
			conn=db.getConnection();
			String sql = "SELECT bno,name,subject,content,TO_CHAR(regdate,'yyyy-mm-dd'),hit,suggest,rownum "
					+ "FROM (SELECT bno,name,subject,content,regdate,hit,suggest,rownum as num "
					+ "FROM (SELECT /*+ INDEX_DESC(yori_freeboard yf_bno_pk)*/bno,name,subject,content,regdate,hit,suggest "
					+ "FROM yori_freeboard)) "
					+ "WHERE num BETWEEN ? AND ?";
			ps = conn.prepareStatement(sql);
			
			int rowSize = 20;
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
				vo.setContent(rs.getString(4));
				vo.setDbday(rs.getString(5));
				vo.setHit(rs.getInt(6));
				vo.setSuggest(rs.getInt(7));
				vo.setRownum(rs.getInt(8));
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
	public int boardManagerTotalPage() {
		int total=0;
		try {
			conn=db.getConnection();
			String sql = "SELECT CEIL(COUNT(*)/20.0) FROM yori_freeboard";
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
