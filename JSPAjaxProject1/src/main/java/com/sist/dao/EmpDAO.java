package com.sist.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import java.util.List;
public class EmpDAO {
  private static SqlSessionFactory ssf;
  static {
	  try
	  {
		  Reader reader=Resources.getResourceAsReader("Config.xml");
		  ssf= new SqlSessionFactoryBuilder().build(reader);
	  }catch(Exception ex) {}
  }
  public static List<EmpVO> empListData()
  {
	  return ssf.openSession().selectList("empListData");
  }
}