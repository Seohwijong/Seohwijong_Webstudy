package com.sist.food;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.dao.*;
@WebServlet("/FoodCategoryServlet")
public class FoodCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전송 방식
		response.setContentType("text/html;charset=UTF-8");
		// html => text/html , xml => text/xml , json => text/plain
		// HTML을 저장 => 브라우저에 읽어가는 위치에 저장
		PrintWriter out=response.getWriter();
		//				=> 사용자의 브라우저
		// 데이터베이스 연결
		FoodDAO dao=FoodDAO.newInstance();
		List<CategoryVO> list=dao.food_category_list();
		// 카테고리 정보를 오라클로 부터 받는다
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		out.println("<style>");
		out.println("<.container{margin-top:50px}>");
		out.println("<.row{");
		out.println("margin:0px auto");
		out.println("width:1024px}</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=container>");
		out.println("<h1>믿고보는 맛집 리스트</h1>");
		out.println("<div class=row>");
		for(int i=0;i<12;i++)
		{
			CategoryVO vo=list.get(i);
			out.println("<div class=\"col-md-3\">");  // 한줄에 4개 출력  md-4면 3개
			out.println("<div class=\"thumbnail\">");
			out.println("<a href=FoodListServlet?cno="+vo.getCno()+">");
			out.println("<img src=\""+vo.getPoster()+"\" style=\"width:100%\">");
			out.println("<div class=\"caption\">");
			out.println(" <p style=\"font-size:9px\">"+vo.getTitle()+"</p>");
			out.println("</div>");
			out.println("</a>");
			out.println("</div>");
			out.println("</div>");
		}
		out.println("</div>");
		
		out.println("<h1>지역별 맛집 리스트</h1>");
		out.println("<div class=row>");
		for(int i=0;i<12;i++)
		{
			CategoryVO vo=list.get(i);
			out.println("<div class=\"col-md-3\">");  // 한줄에 4개 출력  md-4면 3개
			out.println("<div class=\"thumbnail\">");
			out.println("<a href=\"#\">");
			out.println("<img src=\""+vo.getPoster()+"\" style=\"width:100%\">");
			out.println("<div class=\"caption\">");
			out.println(" <p style=\"font-size:9px\">"+vo.getTitle()+"</p>");
			out.println("</div>");
			out.println("</a>");
			out.println("</div>");
			out.println("</div>");
		}
		out.println("</div>");
		
		out.println("<h1>메뉴별 맛집 리스트</h1>");
		out.println("<div class=row>");
		for(int i=0;i<12;i++)
		{
			CategoryVO vo=list.get(i);
			out.println("<div class=\"col-md-3\">");  // 한줄에 4개 출력  md-4면 3개
			out.println("<div class=\"thumbnail\">");
			out.println("<a href=\"#\">");
			out.println("<img src=\""+vo.getPoster()+"\" style=\"width:100%\">");
			out.println("<div class=\"caption\">");
			out.println(" <p style=\"font-size:9px\">"+vo.getTitle()+"</p>");
			out.println("</div>");
			out.println("</a>");
			out.println("</div>");
			out.println("</div>");
		}
		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

}
