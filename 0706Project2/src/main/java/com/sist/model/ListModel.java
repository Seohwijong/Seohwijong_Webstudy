package com.sist.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;
import com.sist.dao.RecipeDAO;
import com.sist.vo.RecipeVO;

public class ListModel {

	@RequestMapping("list/recipeList.do") //URL 뒤에 붙는 페이지 설계
public String recilpeList_page(HttpServletRequest request,HttpServletResponse response)
 {
	 RecipeDAO dao=RecipeDAO.newInstance();
	 String page = request.getParameter("page");
	 String type = request.getParameter("type");
	 final int BLOCK=10;
	 if(page==null)
		 page="1";
	 
	 if(type==null)
		 type="all";
	 int curpage=Integer.parseInt(page);
	 int startpage=((curpage-1)/BLOCK*BLOCK)+1;
	 int endpage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	 int totalpage=dao.recipeTotalPage(type);
	 if(endpage>totalpage)
			endpage=totalpage; 
	 List<RecipeVO> rlist=dao.recipeCategoryDataList(type,curpage);
	 request.setAttribute("curpage", curpage);
	 request.setAttribute("totalpage", totalpage);
	 request.setAttribute("startpage", startpage);
	 request.setAttribute("endpage", endpage);
	 request.setAttribute("rlist", rlist);
	 request.setAttribute("type", type);
	 request.setAttribute("main_jsp", "../list/recipeList.jsp");
	 return "../jsp/main.jsp";
 }
	@RequestMapping("list/recipeDetail.do") //URL 뒤에 붙는 페이지 설계
	public String recilpeDetail_page(HttpServletRequest request,HttpServletResponse response)
	 {
		 RecipeDAO dao=RecipeDAO.newInstance();
		 String rdno=request.getParameter("rdno");
		 RecipeVO rvo=dao.recipeDetailData(Integer.parseInt(rdno));
		 request.setAttribute("rvo", rvo);
		 List<String> step_post= new ArrayList<String>();
		 List<String> step_text= new ArrayList<String>();
		 StringTokenizer st=new StringTokenizer(rvo.getStep_pos(),"^");
		 StringTokenizer st1=new StringTokenizer(rvo.getStep_text(),"^");
		 while(st.hasMoreTokens())
		 {
			 step_post.add(st.nextToken());
			 
		 }
		 while(st1.hasMoreTokens())
		 {
			 step_text.add(st1.nextToken());
			 
		 }
		 if(step_post.size()== step_text.size())
		 {
		 request.setAttribute("step_post", step_post);
		 request.setAttribute("step_text", step_text);
		 }
		 else if(step_post.size()> step_text.size())
		 {
			int minus = step_post.size()-step_text.size();
			for(int i=0; i<minus;i++)
			{
				step_text.add(" ");
			}
			 request.setAttribute("step_post", step_post);
			 request.setAttribute("step_text", step_text);
		 }
		 else
		 {
			 int minus = step_text.size()-step_post.size();
			 for(int i=0; i<minus;i++)
				{
					step_post.add(" ");
				}
				 request.setAttribute("step_post", step_post);
				 request.setAttribute("step_text", step_text);
		 }
		 request.setAttribute("main_jsp", "../list/recipeDetail.jsp");
		 return "../jsp/main.jsp";
	 }
}
