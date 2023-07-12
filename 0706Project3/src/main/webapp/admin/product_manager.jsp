<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="margin-left: 490px"> <!-- 사이즈 보기 -->
	<h1>유저정보 보기</h1>
	</div>
	<table class="table" style="width: 1300px"> <!-- 사이즈 보기 -->
		<tr>
			<th>상품번호</th>
			<th>이름</th>
			<th></th>
			<th>부제목</th>
			<th>할인률</th>
			<th>할인가</th>
			<th>기본가</th>
			<th>첫구매 할인가</th>
			<th>배달비</th>
			<th>수량</th>
			<th></th>
			<th></th>
			<th></th>
			<%--pdno,title,poster,subject,sale,priced_sale,original_pri,first_pri,delivery_pri,goods_count --%>
		</tr>	
		<c:forEach var="vo" items="${plist }">
		<tr>
			<td>${vo.pdno }</td>
			<td>${vo.title }</td>
			<td><img src="${vo.poster }" style="width: 30px;height: 30px"></td>
			<td>${vo.subject }</td>
			<td>${vo.sale }</td>
			<td>${vo.priced_sale }</td>
			<td>${vo.original_pri }</td>
			<td>${vo.first_pri }</td>
			<td>${delivery_pri }</td>
			<td>${goods_count }</td>
			<td><input type="button" value="수정" class="btn btn-sm btn-danger"></td>
			<td><input type="button" value="삭제" class="btn btn-sm btn-danger"></td>
			<td><input type="button" value="판매중지" class="btn btn-sm btn-danger"></td>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>