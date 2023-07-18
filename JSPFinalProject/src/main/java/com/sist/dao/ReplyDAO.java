package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.common.*;
import com.sist.vo.*;

import oracle.jdbc.OracleTypes;

/*
 * try
 * {
 * 	getConnection();
 *  insert => commit() => 에러 발생 (X)
 *  update => commit()
 *  insert => commit()
 * }
 * catch(exception ex)
 * {
 *  rollback();
 * 	ex.printStackTrace();
 * }
 * finally
 * {
 * 	disConnection();
 * }
 * 
 */
public class ReplyDAO {
	private Connection conn;
	private CallableStatement cs;
	private CreateDataBase db=new CreateDataBase();
	private static ReplyDAO dao;
	
	public static ReplyDAO newInstance()
	{
		if(dao==null)
			dao=new ReplyDAO();
		return dao;
	}
	// 데이터 읽기
	/*
		 CREATE OR REPLACE PROCEDURE replyListData(
	    pNo NUMBER,
	    pType NUMBER,
	    pResult OUT SYS_REFCURSOR
		)
		IS
		BEGIN
		    OPEN pResult FOR
		        SELECT no,type,cno,id,name,msg,regdate
		        FROM reply_all
		        WHERE type=pType AND cno=pNo;
		        ORDER BY DESC
		END;
		/
	*/
	public List<ReplyVO> replyListData(int type, int cno)
	{
		List<ReplyVO> list=new ArrayList<ReplyVO>();
		try
		{
			conn=db.getConnection();
			String sql="{CALL replyListData(?,?,?)}";
			cs=conn.prepareCall(sql);
			cs.setInt(1, cno);
			cs.setInt(2, type);
			cs.registerOutParameter(3, OracleTypes.CURSOR);
			// 실행
			cs.executeQuery();
			ResultSet rs=(ResultSet)cs.getObject(3);
			while(rs.next())
			{
				ReplyVO vo=new ReplyVO();
				vo.setNo(rs.getInt(1));
				vo.setType(rs.getInt(2));
				vo.setCno(rs.getInt(3));
				vo.setId(rs.getString(4));
				vo.setName(rs.getString(5));
				vo.setMsg(rs.getString(6));
				vo.setDbday(rs.getString(7));
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
			db.disConnection(conn, cs);
		}
		
		return list;
	}
	public void replyInsert(ReplyVO vo)
	{
		try
		{
			conn=db.getConnection();
			String sql="{CALL replyInsert(?,?,?,?,?)}";
			cs=conn.prepareCall(sql);
			cs.setInt(1, vo.getType());
			cs.setInt(2, vo.getCno());
			cs.setString(3, vo.getId());
			cs.setString(4, vo.getName());
			cs.setString(5, vo.getMsg());
			cs.executeQuery();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			db.disConnection(conn, cs);
		}
	}
	// 수정
	public void replyUpdate(int no,String msg)
	{
		try
		{
			conn=db.getConnection();
			String sql="{CALL replyUpdate(?,?)}";
			cs=conn.prepareCall(sql);
			cs.setInt(1, no);
			cs.setString(2, msg);
			cs.executeQuery();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			db.disConnection(conn, cs);
		}
	}
	// 삭제
	public void replyDelete(int no)
	{
		try
		{
			conn=db.getConnection();
			String sql="{CALL replyDelete(?)}";
			cs=conn.prepareCall(sql);
			cs.setInt(1, no);
			cs.executeQuery();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			db.disConnection(conn, cs);
		}
	}
}
