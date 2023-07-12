package com.sist.model;

import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.vo.*;

public class FreeBoardModel {
	
	@RequestMapping("board/list.do")
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
