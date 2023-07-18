package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sist.common.CreateDataBase;
import com.sist.vo.MemberVO;

public class MyDAO {
	private Connection conn;
	private PreparedStatement ps;
	private CreateDataBase db=new CreateDataBase();
	private static MyDAO dao;
	public static MyDAO newInstance()
	{
		if(dao==null)
			dao=new MyDAO();
		return dao;
	}
	public MemberVO myInfo(String id)
	{
		MemberVO vo=new MemberVO();
		try
		{
			conn=db.getConnection();
			String sql="SELECT id,name,nickname,sex,birthday,email,post,addr1,addr2,phone "
					+ "FROM project_member "
					+ "WHERE id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setId(rs.getString(1));
			vo.setName(rs.getString(2));
			vo.setNickname(rs.getString(3));
			vo.setSex(rs.getString(4));
			vo.setBirthday(rs.getString(5));
			vo.setEmail(rs.getString(6));
			vo.setPost(rs.getString(7));
			vo.setAddr1(rs.getString(8));
			String addr2=rs.getString(9);
			if(addr2==null)
			 addr2="없음";
			vo.setAddr2(addr2);
			String phone=rs.getString(10);
			if(phone==null)
			 phone="없음";
			vo.setPhone(phone);
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
		return vo;
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////
	
	public void myinfoUpdate(MemberVO vo)
	{
		try
		{
			conn=db.getConnection();
			String sql="UPDATE project_member SET "
					+  "nickname=?,email=?,post=?,addr1=?,addr2=?,phone=? "
					+ "WHERE id=?";
			ps=conn.prepareStatement(sql);
//			ps.setString(1, vo.getName());
			ps.setString(1, vo.getNickname());
//			ps.setString(3, vo.getBirthday());
			ps.setString(2, vo.getEmail());
//			ps.setString(5, vo.getSex());
			ps.setString(3, vo.getPost());
			ps.setString(4, vo.getAddr1());
			ps.setString(5, vo.getAddr2());
			ps.setString(6, vo.getPhone());
			
			ps.setString(7, vo.getId());
			
			ps.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			db.disConnection(conn, ps);
		}
	}
	
	
	
	
	public void myinfoDelete(String id)
	{
		try
		{
			conn=db.getConnection();
			String sql="DELETE FROM project_member "
					+ "WHERE id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			
			
			ps.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			db.disConnection(conn, ps);
		}
	}
}	
