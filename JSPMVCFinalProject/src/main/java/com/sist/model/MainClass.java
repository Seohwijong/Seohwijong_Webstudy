package com.sist.model;

import java.util.Scanner;
import java.lang.*;
import java.lang.reflect.Method;

class Board
{
	@RequestMapping("list.do")
	public void boardList()
	{
		System.out.println("목록 출력");
	}
	@RequestMapping("insert.do")
	public void boardInsert()
	{
		System.out.println("데이터 추가");
	}
	@RequestMapping("update.do")
	public void boardUpdate()
	{
		System.out.println("데이터 수정");
	}
	@RequestMapping("delete.do")
	public void boardDelete()
	{
		System.out.println("데이터 삭제");
	}
	@RequestMapping("find.do")
	public void boardFind()
	{
		System.out.println("데이터 검색");
	}
}
public class MainClass {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("URL입력:");
		String url=scan.next();
//		Board board=new Board();
//		if(url.equals("list.do"))
//		{
//			board.boardList();
//		}
//		else if(url.equals("insert.do"))
//		{
//			board.boardInsert();
//		}
//		else if(url.equals("update.do"))
//		{
//			board.boardUpdate();
//		}
//		else if(url.equals("delete.do"))
//		{
//			board.boardDelete();
//		}
//		else if(url.equals("find.do"))
//		{
//			board.boardFind();
//		}
		try
		{
			Class clsName=Class.forName("com.sist.model.Board");
			Object obj=clsName.getDeclaredConstructor().newInstance();
			Method[] methods=clsName.getDeclaredMethods();
			for(Method m:methods)
			{
				RequestMapping rm=m.getAnnotation(RequestMapping.class);
				if(rm.value().equals(url))
				{
					m.invoke(obj,null);
				}
			}
		}
		catch(Exception ex) {}
		
	}
}
