<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="text-center"> <!-- 사이즈 보기 -->
		<h1>내정보 보기</h1>
		</div>
		<table class="table""> <!-- 사이즈 보기 -->
			<tr>
				<th>닉네임</th>
				<td>${vo.nickname }</td>
			</tr>	
			<tr>
				<th>생년월일</th>
				<td>${vo.birthday }</td>
			</tr>		
			<tr>
				<th>이메일</th>
				<td>${vo.email }</td>
			</tr>	
			<tr>
				<th>성별</th>
				<td>${vo.sex }</td>
			</tr>	
			<tr>
				<th>우편번호</th>
				<td>${vo.post }</td>
			</tr>	
			<tr>
				<th>주소</th>
				<td>${vo.addr1 }</td>
			</tr>	
		</table>
</body>
</html>