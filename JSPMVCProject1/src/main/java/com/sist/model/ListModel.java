package com.sist.model;

import javax.servlet.http.HttpServletRequest;
/*
 *  사용자 요청 =====> Controller =====> Model을 찾는다
 *  					 |					|
 *  					 |				 요청 처리
 *                       |               ------- 결과를 request, session에 담는다
 *                       |
 *                    reques, session을 전송 받는다
 *                       |
 *                    JSP를 찾는다
 *                    	 |
 *                    JSP에 request, session을 전송
 *
 */
public class ListModel {
	public String execute(HttpServletRequest request)
	{
		request.setAttribute("msg", "목록출력");
		return "list.jsp";
	}
}
