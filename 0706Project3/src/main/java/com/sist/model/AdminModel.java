package com.sist.model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.vo.MemberVO;
import com.sist.vo.ProductVO;

import java.util.*;
public class AdminModel {
	@RequestMapping("admin/adminpage.do")
	public String admin_page(HttpServletRequest request, HttpServletResponse response) {
		String mode=request.getParameter("mode");
	 	if(mode==null)
	 		mode="1";
	 	String jspp="";
	 	int index=Integer.parseInt(mode);
	 	switch(index)
	 	{
	 	case 1:
	 		jspp="userinfo.jsp";
	 		break;
	 	case 2:
	 		jspp="product_manager.jsp";
	 		break;
	 	}
	 	
	 	try
		{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex) {}
		
		AdminDAO dao=AdminDAO.newInstance();
		
		List<MemberVO> list=dao.userInfo();
	 	System.out.println(jspp);
	 	List<ProductVO> plist=dao.ProductListManager();
	 	request.setAttribute("jspp", jspp);
	 	request.setAttribute("list", list);
	 	request.setAttribute("plist", plist);
		request.setAttribute("main_jsp", "../admin/adminpage.jsp");
		 return "../jsp/main.jsp";
	}
}
