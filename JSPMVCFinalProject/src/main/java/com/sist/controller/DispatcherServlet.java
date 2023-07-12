package com.sist.controller;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.sist.model.RequestMapping;

/*
 * 	MVC 동작 과정
 * ------------
 * 1. 요청				===> DispatcherServlet을 찾는다
 * 	  list.do                          |
 * 	  insert.do                        |
 *                               서버에서 받을 수 있는 부분 URI , URL
 *                               URI => Model을 찾는다
 * 2. DispatcherServlet(Controller)
 *    => Front Controller : 요청 => Model 연결 => request를 전송
 *                                 ---------
 *                                       요청 처리 기능을 가지고 있다
 *    a.do?aa=1
 *    a.do?aa1&bb=2
 *    
 * 
 */
import java.net.*;
import java.util.*;
import java.lang.*;
import java.lang.reflect.Method;
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<String> clsList=new ArrayList<String>();
	// 초기화 => XML에 등록된 클래스 읽기 (메뉴)
	public void init(ServletConfig config) throws ServletException {
		try
		{
			URL url=this.getClass().getClassLoader().getResource(".");
			File file=new File(url.toURI());
			System.out.println(file.getPath());
			String path=file.getPath();
			path=path.replace("\\", File.separator);
			// window
			path=path.substring(0,path.lastIndexOf(File.separator));
			System.out.println(path);
			path=path+File.separator+"application.xml";
			//XML 파싱
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			// 파서기 (XML => DocumentBuilder , HTML => Jsoup
			DocumentBuilder db=dbf.newDocumentBuilder();
			Document doc=db.parse(new File(path));
			Element beans=doc.getDocumentElement();
			System.out.println(beans.getTagName());
			// 같은 태그를 묶어서 사용
			NodeList list=beans.getElementsByTagName("bean");
			for(int i=0;i<list.getLength();i++)
			{
				Element bean=(Element)list.item(i);
				String id=bean.getAttribute("id");
				String cls=bean.getAttribute("class");
				System.out.println(id+":"+cls);
				clsList.add(cls);
			}
		}
		catch(Exception ex) {}
	}
	// 웹에서 사용자 요청 => servlet / jsp
	// servlet : 화면 출력은 하지 않는다 (연결)
	// 화면 : jsp(View)
	/*
	 * 		Controller : Servlet
	 *          Spring : DispatcherServlet
	 *          Struts : ActionServlet
	 *          Struts : FileDispatcher
	 *          			----------- 배달부 (request)
	 *      Model : 요청 처리 => java
	 *      View : 화면 출력 => jsp
	 * 
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try 
		{
			String path=request.getRequestURI();
			path=path.substring(request.getContextPath().length()+1);
			for(String cls:clsList)
			{
				// Class 정보 읽기
				Class clsName=Class.forName(cls);
				Object obj=clsName.getDeclaredConstructor().newInstance();
				// 메소드 읽어 오기
				Method[] methods=clsName.getDeclaredMethods();
				for(Method m:methods)
				{
					RequestMapping rm=m.getAnnotation(RequestMapping.class);
					if(rm.value().equals(path))
					{
						String jsp=(String)m.invoke(obj, request,response);
						if(jsp==null) // return형이 void일때
						{
							return;
						}
						else if(jsp.startsWith("redirect:"))
						{
							response.sendRedirect(jsp.substring(jsp.indexOf(":")+1));
						}
						else
						{
							RequestDispatcher rd=request.getRequestDispatcher(jsp);
							rd.forward(request, response);
						}
						return;
					}
				}
				
			}
		}
		catch(Exception ex) {}
	}

}
