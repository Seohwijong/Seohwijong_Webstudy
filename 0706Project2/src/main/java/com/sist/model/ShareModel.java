package com.sist.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;
import com.sist.dao.ShareDAO;
import com.sist.vo.RecipeVO;
import com.sist.vo.ShareVO;

public class ShareModel {
	@RequestMapping("share/shareList.do")
	public String share_main(HttpServletRequest request,HttpServletResponse response)
  {
		String page = request.getParameter("page");
		
		 final int BLOCK=5;
		 if(page==null)
			 page="1";
		 
		 ShareDAO sdao=ShareDAO.newInstance();
		 int curpage=Integer.parseInt(page);
		 int startpage=((curpage-1)/BLOCK*BLOCK)+1;
		 int endpage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		 int totalpage=sdao.shareTotalPage();
		 if(endpage>totalpage)
				endpage=totalpage; 
		 List<ShareVO> slist=sdao.shareListData(curpage);
		 request.setAttribute("curpage", curpage);
		 request.setAttribute("totalpage", totalpage);
		 request.setAttribute("startpage", startpage);
		 request.setAttribute("endpage", endpage);
		 request.setAttribute("slist", slist);
	    request.setAttribute("main_jsp", "../share/shareList.jsp");
	  return "../jsp/main.jsp";
  }
	@RequestMapping("share/shareDetail.do")
	public String share_Detail(HttpServletRequest request,HttpServletResponse response)
	{
		  String skdno=request.getParameter("skdno");
		  ShareDAO sdao=ShareDAO.newInstance();
		  ShareVO svo=sdao.shareDetailData(Integer.parseInt(skdno));
		  
		  request.setAttribute("svo", svo);
		request.setAttribute("main_jsp", "../share/shareDetail.jsp");
		  return "../jsp/main.jsp";
	}
}
