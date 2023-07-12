package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.vo.MemberVO;
public class MyPageModel {
	@RequestMapping("my/mypage.do")
	public String my_page(HttpServletRequest request, HttpServletResponse response) {
		String mode=request.getParameter("mode");
	 	if(mode==null)
	 		mode="1";
	 	String jsp="";
	 	int index=Integer.parseInt(mode);
	 	switch(index)
	 	{
	 	case 1:
	 		jsp="myinfo.jsp";
	 		break;
	 	case 2:
	 		jsp="myinfo2.jsp";
	 		break;
	 	}
	 	
	 	try
		{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex) {}
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		
		System.out.println(id+"1111");
		MyDAO dao=MyDAO.newInstance();
		
		MemberVO vo=dao.myInfo(id);
	 	System.out.println(jsp);
	 	
	 	request.setAttribute("jsp", jsp);
	 	request.setAttribute("vo", vo);
		request.setAttribute("main_jsp", "../my/mypage.jsp");
		 return "../jsp/main.jsp";
	}
//	@RequestMapping("my/myinfo.do")
//	public String my_page_info(HttpServletRequest request, HttpServletResponse response) {
//		try
//		{
//			request.setCharacterEncoding("UTF-8");
//		}catch(Exception ex) {}
//		String mode=request.getParameter("mode");
//		HttpSession session=request.getSession();
//		String id=(String)session.getAttribute("id");
//		
//		System.out.println(id+"11121");
//		MemberDAO dao=MemberDAO.newInstance();
//		
//		MemberVO vo=dao.myInfo(id);
//		
//		request.setAttribute("vo", vo);
//		
//		
//		request.setAttribute("jsp", "../my/myinfo.jsp");
//		 return "../my/mypage.jsp";
//	}
}
