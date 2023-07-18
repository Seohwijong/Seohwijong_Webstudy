<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	$('.updates').click(function(){
		$.ajax({
			type:'post',
			url:'myinfo.do',
			success:function(result)
			{
				location.href="../my/myinfo2.do"
			}
	})
})
</script>
</head>
<body>
	<div class="text-center"> <!-- 사이즈 보기 -->
	<h1>내정보 보기</h1>
	</div>
	<table class="table"> <!-- 사이즈 보기 -->
		<tr>
			<th>아이디</th>
			<td >${vo.id }</td>
		</tr>	
		<tr>
			<th>이름</th>
			<td>${vo.name }</td>
		</tr>
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
		<tr>
			<th>주소</th>
			<td>${vo.addr2 }</td>
		</tr>	
		<tr>
			<th>전화번호</th>
			<td>${vo.phone }</td>
		</tr>		
	</table>
	<div class="text-right">
		<a href="../my/my_update.do" class="btn btn-sm btn-danger update">수정</a>
<!-- 		<input type=button value="수정" class="btn btn-sm btn-danger update" > -->
		<a href="my_delete_ok.do" class="btn btn-sm btn-danger">회원탈퇴</a>
	</div>
</body>
</html>