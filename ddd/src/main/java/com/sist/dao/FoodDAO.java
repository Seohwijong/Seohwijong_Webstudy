package com.sist.dao;
import java.sql.*;
import java.util.*;
import com.sist.vo.*;
/*
 *   1. 드라이버 등록 
 *      ----- 오라클 연결하는 라이브러리 (ojdbc8.jar)
 *      OracleDriver => 메모리할당
 *   2. 오라클 연결
 *   	Connection
 *   3. SQL 문장을 전송
 *      PreparedStatement
 *   4. SQL문장 실행 요청
 *      = executeUpdate() => INSERT,UPDATE,DELETE 수행할때
 *        --------------- COMMIT (AutoCommit)
 *      = executeQuery() => SELECT
 *        -------------- 결과값을 가지고 온다
 *        				 ----
 *        				 ResultSet
 *        ResultSet
 *        	String sql="SELECT id,name,sex,age "; 보내는거에 따라 메모리 달라짐 
 *        ------------------------------------------
 *            id		name		sex			age
 *        ------------------------------------------
 *           aaa        홍길동       남자          20  | first() => next()
 *           										  위치변경      위치변경후 데이터 읽기
 *           getString(1) getString(2) getString(3) getInt(4) -> 순서로 읽기
 *           getString("id") => mybatis는 컬럼명으로 읽음 
 *        ------------------------------------------
 *           bbb        심청이       여자          23
 *            getString(1) getString(2) getString(3) getInt(4) -> 순서로 읽기
 *        ------------------------------------------
 *          ccc         박문수       남자          27 | last() => previous()
 *          										 위치변경    밑에서 부터 데이터 읽기
 *           getString(1) getString(2) getString(3) getInt(4) -> 순서로 읽기 while문 
 *        ------------------------------------------
 *         | 커서위치
 *   5. 닫기
 *   	생성 반대로 닫는다
 *      rs.close() , ps.close() , conn.close() 
 *      ------------------------------------- 오라클 연결 (Servlet => JSP)
 *      
 */
public class FoodDAO {
 //기능 => INSERT => 데이터수집 (파일)
 private Connection conn; // 오라클 연결 객체(오라클뿐만아니라 모든 데이터베이스연결)
 private PreparedStatement ps; // SQL 문장 전송 / 결과값읽기
 private final String URL="jdbc:oracle:thin:@localhost:1522:XE";
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
  // ========================== jdbc 기본셋팅 (모든 DAO는 동일)
  // 여기부터 기능 FOODDAO의 기능
  //1. 데이터 수집 (INSERT)
  /*
   *  Statement => SQL => 생성과 동시에 데이터 추가
   *  		"'"+name+"','"+sex+"','"+...
   *  PreparedStatement => 미리 sql문장을 만들어놓고 나중에 값을 채워주는 형태
   *   => default 
   *  CallableStatement => procedure 호출(함수호출)
   */
  public void foodCategoryInsert(CategoryVO vo)
  {
	  try
	  {
		  //1. 연결
		  getConnection();
		  //2. SQL문장 생성
		  String sql="INSERT INTO food_category VALUES("
				  +"fc_cno_seq.nextVal,?,?,?,?)"; //? 1 2 3 4 0번없음
		  /*
		   *  "'"+vo.getTitle()+"','"
		   *  
		   *  INSERT ~ VALUES ('홍길동','서울'
		   */
		  //3. SQL문장을 오라클로 전송
		  ps=conn.prepareStatement(sql); // PreparedStatement =>미리 sql문장을 만들어놓고 나중에 값을 채워주는 형태
		  //3-1 => ?에 값 채워주기
		 ps.setString(1, vo.getTitle()); // "'"+vo.getTitle()+"'" 작은따옴표 붙여주는 
		 ps.setString(2, vo.getSubject());
		 ps.setString(3, vo.getPoster());
		 ps.setString(4, vo.getLink());
		  // 단점 => 번호가 잘못되면 오류 발생 번호 1번부터 시작 , 데이터형 틀리면 오류남 
		 // IN,OUT ~오류 : 번호가 틀렸다.
		  //4. SQL문장을 실행 명령 => SQL문장을 작성하고 execute 
		 ps.executeUpdate(); // executeUpdate() => INSERT,UPDATE,DELETE 수행할때  executeQuery() => SELECT
	  }catch(Exception ex) 
	  {
		  ex.printStackTrace();// 에러확인
	  }
	  finally
	  {
		  disConnection(); // 오라클 연결 해제 => 무조건
	  }
  }
  //1-1=> 실제 맛집 정보 저장 
  /*
   * fno NUMBER, 
	cno NUMBER, 
	name VARCHAR2(100) CONSTRAINT fh_name_nn NOT NULL,
	score NUMBER(2,1), --2글자중 한글자를 실수형
	address VARCHAR2(300) CONSTRAINT fh_addr_nn NOT NULL,
	phone VARCHAR2(20) CONSTRAINT fh_phone_nn NOT NULL,
	type VARCHAR2(30) CONSTRAINT fh_type_nn NOT NULL,
	price VARCHAR2(30),
	parking VARCHAR2(30),
	time VARCHAR2(20),
	menu CLOB,
	good NUMBER,
	soso NUMBER,
	bad NUMBER,
	poster VARCHAR2(4000) CONSTRAINT fh_poster_nn NOT NULL,
   */
  public void foodDataInsert(FoodVO vo)
  {
	  try
	  {
		  //1. 오라클 연결
		  getConnection();
		  //2. SQL문장 제작
		  String sql="INSERT INTO cate_test VALUES("
				  +"ct_no_seq.nextval,?,?,?)";
		  //3. 오라클 전송
		  ps=conn.prepareStatement(sql);
		  //4. ?에 값을 채운다.
		  
		  ps.setString(1, vo.getTitle());
		  ps.setString(2, vo.getAddr());
		  ps.setString(3, vo.getPoster());
		  //실행요청
		  ps.executeUpdate(); //commit()
	  }catch(Exception ex)
	  {
		  ex.printStackTrace(); // 오류 확인
	  }
	  finally
	  {
		  disConnection(); // 오라클 닫기
	  }
  }
  //2. SELECT => 전체 데이터 읽기 리턴형있음 검색결과 갖고옴 => 30개 (한개당 => CategoryVO)
  //=> Collection, 배열=> 브라우저로 30개를 전송
  // 브라우저 <==> 오라클 (x)
  // 브라우저 <==> 자바 <==> 오라클
  // Collection, 메소드 제작
  public List<CategoryVO> foodCategoryData()
  {
	  // 데이터는 오라클에 있음 브라우저랑 오라클 자바로 연결
	  List<CategoryVO> list=new ArrayList<CategoryVO>();
	  try
	  {
		  //1. 오라클 연결
		  getConnection();
		  //2. sql문장
		  String sql="SELECT cno,title,subject,poster,link "
				  +"FROM food_category";
		  //3. 오라클 전송
		  ps=conn.prepareStatement(sql);
		  //4. 실행후 결과값 받기
		  ResultSet rs=ps.executeQuery();
		  // rs에 있는 데이터를 list에 저장
		  while(rs.next())
		  {
			  CategoryVO vo=new CategoryVO();
			  vo.setCno(rs.getInt(1));
			  vo.setTitle(rs.getString(2));
			  vo.setSubject(rs.getString(3));
			  String poster=rs.getString(4);
			  poster=poster.replace("#", "& ");
			  vo.setPoster(poster);
			  vo.setLink("https://www.mangoplate.com"+rs.getString(5));
			  
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
  //3. 상세보기 => WHERE 
  
}