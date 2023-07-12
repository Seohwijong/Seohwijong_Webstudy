package com.sist.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.vo.FoodVO;
import com.sist.vo.ShareVO;

public class FoodModel {
	@RequestMapping("food/foodList.do")
	public String share_main(HttpServletRequest request,HttpServletResponse response)
  {
		String page = request.getParameter("page");
		
		 final int BLOCK=5;
		 if(page==null)
			 page="1";
		 
		 FoodDAO fdao=FoodDAO.newInstance();
		 int curpage=Integer.parseInt(page);
		 int startpage=((curpage-1)/BLOCK*BLOCK)+1;
		 int endpage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		 int totalpage=fdao.shareTotalPage();
		 if(endpage>totalpage)
				endpage=totalpage; 
		 List<FoodVO> flist=fdao.foodListData(curpage);
		 request.setAttribute("curpage", curpage);
		 request.setAttribute("totalpage", totalpage);
		 request.setAttribute("startpage", startpage);
		 request.setAttribute("endpage", endpage);
		 request.setAttribute("flist", flist);
	    request.setAttribute("main_jsp", "../food/foodList.jsp");
	  return "../jsp/main.jsp";
  }
	
}
