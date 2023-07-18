package com.sist.model;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;
import com.sist.vo.*;
import com.sist.dao.*;
import java.util.*;
public class MainModel {
	@RequestMapping("jsp/main.do")
	public String main_page(HttpServletRequest request,HttpServletResponse response)
	{
		// 구현 ~ random 출력 레시피
		RecipeDAO rdao=RecipeDAO.newInstance();
		List<RecipeVO> rlist=rdao.randomRecipeList();
		request.setAttribute("rlist", rlist);
		
		
		// 공유주방 랜텀 출력
		ShareDAO sdao=ShareDAO.newInstance();
		List<ShareVO> slist=sdao.randomShareList();
		
		request.setAttribute("slist", slist);
		
		
		//맛집 랜덤 출력
		FoodDAO fdao=FoodDAO.newInstance();
		List<FoodVO> flist=fdao.randomFoodList();
		request.setAttribute("flist", flist);
		// 상점 랜덤 출력
		ProductDAO pdao=ProductDAO.newInstance();
		List<ProductVO> plist=pdao.randomProductList();
		request.setAttribute("plist", plist);
		request.setAttribute("main_jsp", "../jsp/home.jsp");
		return "../jsp/main.jsp";
	}
	
}
