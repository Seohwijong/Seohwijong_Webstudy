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
			<th>아이디</th>
			<th>이름</th>
			<th>닉네임</th>
			<th>생년월일</th>
			<th>이메일</th>
			<th>성별</th>
			<th>우편번호</th>
			<th>주소</th>
			<th></th>
			<th></th>
		</tr>	
		<c:forEach var="vo" items="${list }">
		<tr>
			<td>${vo.id }</td>
			<td>${vo.name }</td>
			<td>${vo.nickname }</td>
			<td>${vo.birthday }</td>
			<td>${vo.email }</td>
			<td>${vo.sex }</td>
			<td>${vo.post }</td>
			<td>${vo.addr1 }</td>
			<td><input type="button" value="회원수정" class="btn btn-sm btn-danger"></td>
			<td><input type="button" value="회원삭제" class="btn btn-sm btn-danger"></td>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>