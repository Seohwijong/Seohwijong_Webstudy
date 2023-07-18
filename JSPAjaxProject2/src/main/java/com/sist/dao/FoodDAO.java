package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class FoodDAO {
	//기능 => INSERT => 데이터수집 (파일)
	 private Connection conn; // 오라클 연결 객체(오라클뿐만아니라 모든 데이터베이스연결)
	 private PreparedStatement ps; // SQL 문장 전송 / 결과값읽기
	 private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	 // mySQL => jdbc:mysql://localhost/mydb
	 private static FoodDAO dao; // 싱글턴 패턴 스태틱없이 생성하면 계속 생성됨 느려짐.
	 // DAO객체를 한사람당 한개만 사용이 가능하게 만든다.
	 //드라이버 설정 => 소프트웨어 (메모리 할당 요청) Class.forName()
	 // 클래스의 정보를 전송
	 // 드라이버 설치는 1번만수행*
	 public FoodDAO() // 생성자 안에다가
	 {
		 try
		 {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
		 }catch(Exception ex) {}
	 }
	  // 오라클 연결
	  public void getConnection()
	  {
		  try
		  {
			  conn=DriverManager.getConnection(URL,"hr","happy");
			   //=> 오라클 전송 :conn hr/happy
		  }catch(Exception ex) {}
	  }
	  // 오라클 연결 종료
	  public void disConnection()
	  {
		  try
		  {
			  if(ps!=null) ps.close(); // 연결 되어있으면
			  if(conn!=null)conn.close();
			  //=> 오라클 전송 : exit
		  }catch(Exception ex) {}
	  }
	  //DAO객체를 1개만 생성해서 사용 => 메모리 누수 현상 방지 (싱글톤 패턴)
	  // 싱글톤/팩토리 => 면접 (스프링:패턴 8개)
	  public static FoodDAO newInstance()
	  {
		  //newInstance() , getInstance() 나오면 => 싱글턴 패턴
		  if(dao==null)
			  dao=new FoodDAO();
		  return dao;
	  }
	  public List<FoodVO> foodListData()
	  {
		  List<FoodVO> list=new ArrayList<FoodVO>();
		  try
		  {
			  getConnection();
			  String sql="SELECT fno,poster,name,rownum "
			  		+ "FROM food_location "
			  		+ "WHERE rownum<=20";
			  ps=conn.prepareStatement(sql);
			  ResultSet rs=ps.executeQuery();
			  while(rs.next())
			  {
				  FoodVO vo=new FoodVO();
				  vo.setFno(rs.getInt(1));
				  String poster=rs.getString(2);
				  poster=poster.substring(0,poster.indexOf("^"));
				  poster=poster.replace("#", "&");
				  vo.setPoster(poster);
				  vo.setName(rs.getString(3));
				  list.add(vo);
			  }
			  rs.close();
		  }catch(Exception ex)
		  {
			  ex.printStackTrace();
		  }
		  finally
		  {
			  disConnection();
		  }
		  return list;
	  }
	  public FoodVO foodDetailData(int fno)
	  {
		  FoodVO vo=new FoodVO();
		  try
		  {
			  getConnection();
			  String sql="SELECT fno,cno,name,score,poster,address,"
			  			+ "type,parking,time,menu,phone,price "
			  			+ "FROM food_house "
			  			+ "WHERE fno=?";
			  ps=conn.prepareStatement(sql);
			  ps.setInt(1, fno);
			  ResultSet rs=ps.executeQuery();
			  rs.next();
			  vo.setFno(rs.getInt(1));
			  vo.setCno(rs.getInt(2));
			  vo.setName(rs.getString(3));
			  vo.setScore(rs.getDouble(4));
			  vo.setPoster(rs.getString(5));
			  vo.setAddress(rs.getString(6));
			  vo.setType(rs.getString(7));
			  vo.setParking(rs.getString(8));
			  vo.setTime(rs.getString(9));
			  vo.setMenu(rs.getString(10));
			  vo.setPhone(rs.getString(11));
			  vo.setPrice(rs.getString(12));
			  rs.close();
		  }catch(Exception ex)
		  {
			  ex.printStackTrace();
		  }
		  finally
		  {
			  disConnection();
		  }
		  return vo;
	  }
}