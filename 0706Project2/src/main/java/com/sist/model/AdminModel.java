package com.sist.model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.vo.FreeBoardVO;
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
	 	case 5:
	 		jspp="board_manager.jsp";
	 		break;
	 	}
	 	
	 	try
		{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex) {}
	 	System.out.println(jspp);
	 	
	 	
	 	
	 	
	 	
	 	
	 	// 유저 정보
	 	
		AdminDAO dao=AdminDAO.newInstance();
		List<MemberVO> ulist=dao.userInfo();
		request.setAttribute("ulist", ulist);
		
	 	
	 	// 상품 정보
	 	
	 	String page=request.getParameter("page");
		if(page==null)
			page="1";
	 	final int BLOCK=5;
	 	List<ProductVO> plist=dao.ProductListManager(Integer.parseInt(page));
		int pcurpage=Integer.parseInt(page);
		int pstartpage=((pcurpage-1)/BLOCK*BLOCK)+1;
		int pendpage=((pcurpage-1)/BLOCK*BLOCK)+BLOCK;
		int ptotalpage=dao.adminProductTotalPage();
		if(pendpage>ptotalpage)
			pendpage=ptotalpage;
		
		request.setAttribute("plist", plist);
		request.setAttribute("ptotalpage", ptotalpage);
		request.setAttribute("pcurpage", pcurpage);
		request.setAttribute("pstartpage", pstartpage);
		request.setAttribute("pendpage", pendpage);

		
		
		
		// 게시판 관리
		
		final int bBLOCK=8;
		if(page==null)
			page="1";
		int bcurpage = Integer.parseInt(page);
		int bstartpage = ((bcurpage-1)/BLOCK*BLOCK)+1;
		int bendpage=((bcurpage-1)/BLOCK*BLOCK)+BLOCK;
		int btotalpage = dao.boardManagerTotalPage();
		if(bendpage>btotalpage)
			bendpage=btotalpage;
		List<FreeBoardVO> blist = dao.boardManagerListData(bcurpage);
		request.setAttribute("blist", blist);
		request.setAttribute("btotalpage", btotalpage);
		request.setAttribute("bcurpage", bcurpage);
		request.setAttribute("bstartpage", bstartpage);
		request.setAttribute("bendpage", bendpage);
		
		
	 	request.setAttribute("jspp", jspp);
		request.setAttribute("main_jsp", "../admin/adminpage.jsp");
		 return "../jsp/main.jsp";
	}
	@RequestMapping("admin/product_manager.do")
	public String product_manager(HttpServletRequest request,HttpServletResponse response)
	{
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		final int BLOCK=5;
		AdminDAO dao=AdminDAO.newInstance();
		List<ProductVO> plist=dao.ProductListManager(Integer.parseInt(page));
		int curpage=Integer.parseInt(page);
		 int startpage=((curpage-1)/BLOCK*BLOCK)+1;
		 int endpage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		 int totalpage=dao.adminProductTotalPage();
		 if(endpage>totalpage)
				endpage=totalpage;
		
		request.setAttribute("plist", plist);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("curpage", curpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		
		request.setAttribute("main_jsp", "../admin/productmanager.jsp");
		return "../jsp/main.jsp";
	}
	@RequestMapping("admin/board_manager.do")
	public String board_list(HttpServletRequest request, HttpServletResponse response) {
		
		FreeBoardDAO dao = FreeBoardDAO.newInstance();
		
		String page = request.getParameter("page");
		final int BLOCK=8;
		if(page==null)
			page="1";
		int curpage = Integer.parseInt(page);
		int startpage = ((curpage-1)/BLOCK*BLOCK)+1;
		int endpage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		int totalpage = dao.freeboardTotalPage();
		if(endpage>totalpage)
			endpage=totalpage;
		List<FreeBoardVO> list = dao.freeboardListData(curpage);
		
		
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("list", list);
		
		request.setAttribute("main_jsp", "../board/list.jsp");
		return "../jsp/main.jsp";
		
	}
}
