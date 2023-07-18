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
		<h1>내정보 수정</h1>
		</div>
		<form method=post action="my_update_ok.do">
		<table class="table"> <!-- 사이즈 보기 -->
			<tr>
			<th>아이디</th>
			<td><input type="hidden" name=id value="${vo.id }">
			${vo.id }</td>
		</tr>	
		<tr>
			<th>이름</th>
			<td>${vo.name }</td>
		</tr>
		<tr>
			<th>닉네임</th>
			<td><input type="text" name=nickname size=10 class="input-sm" value="${vo.nickname }"></td>
		</tr>	
		<tr>
			<th>생년월일</th>
			<td>${vo.birthday }</td>
		</tr>		
		<tr>
			<th>이메일</th>
			<td><input type="text" name=email size=15 class="input-sm" value="${vo.email }"></td>
		</tr>	
		<tr>
			<th>성별</th>
			<td>${vo.sex }</td>
		</tr>	
		<tr>
			<th>우편번호</th>
			<td><input type="text" name=post size=15 class="input-sm" value="${vo.post }"></td>
		</tr>	
		<tr>
			<th>주소</th>
			<td><input type="text" name=addr1 size=30 class="input-sm" value="${vo.addr1 }"></td>
		</tr>	
		<tr>
			<th>상세 주소</th>
			<td><input type="text" name=addr2 size=30 class="input-sm" value="${vo.addr2 }"></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><input type="text" name=phone size=15 class="input-sm" value="${vo.phone }"></td>
		</tr>		
		</table>
	
		<div class="text-right">
		<button class="btn btn-sm btn-danger">저장</button>
		<a href="../my/myinfo.do" class="btn btn-sm btn-danger">취소</a>
		
	</div>
	</form>
</body>
</html>