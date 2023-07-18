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
			String sql="SELECT id,name,nickname,sex,birthday,email,post,addr1 "
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
//			vo.setAddr2(rs.getString(9));
//			vo.setPhone(rs.getString(10));
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
}	
