package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.dao.*;
import java.util.*;

public class FoodListModel implements Model {

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("FoodListModel:"+request);
		FoodDAO dao=FoodDAO.newInstance();
		String cno=request.getParameter("cno");
		CategoryVO cvo=dao.foodCategoryInfoData(Integer.parseInt(cno));
		List<FoodVO> list=dao.foodCategoryListData(Integer.parseInt(cno));
		// request : DispatcherServlet
		request.setAttribute("list", list);
		request.setAttribute("cvo", cvo);
		return "food/food_list.jsp";
	}

}
