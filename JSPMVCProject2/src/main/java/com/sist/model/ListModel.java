package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class ListModel implements Model {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<String> list=
					new ArrayList<String>();
		list.add("홍길동");
		list.add("홍길동");
		list.add("홍길동");
		list.add("홍길동");
		list.add("홍길동");
		request.setAttribute("list", list);
		return "view/list.jsp";
	}

}
