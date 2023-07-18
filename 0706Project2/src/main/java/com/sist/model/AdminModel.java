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
		AdminDAO dao=AdminDAO.newInstance();
//		String page=request.getParameter("page");
//		List<MemberVO> ulist=dao.userInfo(Integer.parseInt(page));
		List<MemberVO> ulist=dao.userInfo();
		request.setAttribute("ulist", ulist);
		request.setAttribute("jspp", "../admin/userinfo.jsp");
		request.setAttribute("main_jsp", "../admin/adminpage.jsp");
		 return "../jsp/main.jsp";
	}
	@RequestMapping("admin/userinfo.do")
	public String user_info(HttpServletRequest request,HttpServletResponse response)
	{
		AdminDAO dao=AdminDAO.newInstance();
//		String page=request.getParameter("page");
//		List<MemberVO> ulist=dao.userInfo(Integer.parseInt(page));
		List<MemberVO> ulist=dao.userInfo();
		request.setAttribute("ulist", ulist);
		request.setAttribute("jspp", "../admin/userinfo.jsp");
		request.setAttribute("main_jsp", "../admin/adminpage.jsp");
		return "../jsp/main.jsp";
	}
	@RequestMapping("admin/userupdate_ok.do")
	public String user_update_ok(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
		}
		catch(Exception ex) {}
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String nickname=request.getParameter("nickname");
		String birthday=request.getParameter("birthday");
		String email=request.getParameter("email");
		String sex=request.getParameter("sex");
		String post=request.getParameter("post");
		String addr1=request.getParameter("addr1");
		String addr2=request.getParameter("addr2");
		String phone=request.getParameter("phone");
		MemberVO vo=new MemberVO();
		vo.setId(id);
		vo.setName(name);
		vo.setNickname(nickname);
		vo.setBirthday(birthday);
		vo.setEmail(email);
		vo.setSex(sex);
		vo.setPost(post);
		vo.setAddr1(addr1);
		vo.setAddr2(addr2);
		vo.setPhone(phone);
		
		AdminDAO dao=AdminDAO.newInstance();
		dao.userinfoUpdate(vo);

		return "redirect: ../admin/userinfo.do";
	}
	@RequestMapping("admin/user_delete_ok.do")
	public String user_delete(HttpServletRequest request,HttpServletResponse response)
	{
		String id=request.getParameter("id");
		AdminDAO dao=AdminDAO.newInstance();
		dao.userinfoDelete(id);
		System.out.println(id);
		return "redirect: ../admin/userinfo.do";
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@RequestMapping("admin/product_manager.do")
	public String product_manager(HttpServletRequest request,HttpServletResponse response)
	{
		String page=request.getParameter("page");
		if(page==null)
			page="1";
	 	final int BLOCK=5;
	 	AdminDAO dao=AdminDAO.newInstance();
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
		
		request.setAttribute("jspp", "../admin/product_manager.jsp");
		request.setAttribute("main_jsp", "../admin/adminpage.jsp");
		return "../jsp/main.jsp";
	}
	@RequestMapping("admin/product_update_ok.do")
	public String product_update(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
		}
		catch(Exception ex) {}
		//title=?,subject=?,sale=?,priced_sale=?,original_pri=?,first_pri=?,delivery_pri=?,goods_count=?
		String pdno=request.getParameter("pdno");
		String title=request.getParameter("title");
		String subject=request.getParameter("subject");
		String sale=request.getParameter("sale");
		String price_sale=request.getParameter("price_sale");
		String original_pri=request.getParameter("original_pri");
		String first_pri=request.getParameter("first_pri");
		String delivery_pri=request.getParameter("delivery_pri");
		String goods_count=request.getParameter("goods_count");
		ProductVO vo=new ProductVO();
		vo.setPdno(Integer.parseInt(pdno));
		vo.setTitle(title);
		vo.setSubject(subject);
		vo.setSale(sale);
		vo.setPriced_sale(price_sale);
		vo.setOriginal_pri(original_pri);
		vo.setFirst_pri(first_pri);
		vo.setDelivery_pri(delivery_pri);
		vo.setGoods_count(Integer.parseInt(goods_count));
		
		AdminDAO dao=AdminDAO.newInstance();
		dao.product_update(vo);
		
		return "redirect: ../admin/product_manager.do";
	}
	
	@RequestMapping("admin/product_delete_ok.do")
	public String product_delete(HttpServletRequest request,HttpServletResponse response)
	{
		String pdno=request.getParameter("pdno");
		AdminDAO dao=AdminDAO.newInstance();
		dao.productDelete(Integer.parseInt(pdno));
		
		return "redirect: ../admin/product_manager.do";
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping("admin/board_manager.do")
	public String board_list(HttpServletRequest request, HttpServletResponse response) {
		
		AdminDAO dao = AdminDAO.newInstance();
		String page=request.getParameter("page");
		final int bBLOCK=8;
		if(page==null)
			page="1";
		int bcurpage = Integer.parseInt(page);
		int bstartpage = ((bcurpage-1)/bBLOCK*bBLOCK)+1;
		int bendpage=((bcurpage-1)/bBLOCK*bBLOCK)+bBLOCK;
		int btotalpage = dao.boardManagerTotalPage();
		if(bendpage>btotalpage)
			bendpage=btotalpage;
		List<FreeBoardVO> blist = dao.boardManagerListData(bcurpage);
		request.setAttribute("blist", blist);
		request.setAttribute("btotalpage", btotalpage);
		request.setAttribute("bcurpage", bcurpage);
		request.setAttribute("bstartpage", bstartpage);
		request.setAttribute("bendpage", bendpage);
		
		request.setAttribute("jspp", "../admin/board_manager.jsp");
		request.setAttribute("main_jsp", "../admin/adminpage.jsp");
		return "../jsp/main.jsp";
	}
	
	@RequestMapping("admin/board_update_ok.do")
	public String admin_board_update(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
		}
		catch(Exception ex) {}

		String bno=request.getParameter("bno");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		FreeBoardVO vo=new FreeBoardVO();
		vo.setBno(Integer.parseInt(bno));
		vo.setSubject(subject);
		vo.setContent(content);
		AdminDAO dao=AdminDAO.newInstance();
		dao.adminBoardUpdate(vo);
	
		return "redirect: ../admin/board_manager.do";
	}
	@RequestMapping("admin/admin_board_delete_ok.do")
	public String admin_board_delete(HttpServletRequest request,HttpServletResponse response)
	{
		String bno=request.getParameter("bno");
		AdminDAO dao=AdminDAO.newInstance();
		dao.adminBoardDelete(Integer.parseInt(bno));
		
		return "redirect: ../admin/board_manager.do";
	}
}
