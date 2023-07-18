<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let u=0;
$(function(){
	$('.user_ups').click(function(){
		let id=$(this).attr("data-no");
		$('.user_ups').text("수정");
		if(u===0)
		{
			$('#u'+id).show();
			$(this).text("취소");
			u=1;
		}
		else
		{
			$('#u'+id).hide();
			$(this).text("수정");
			u=0;
		}
	})
})
</script>
</head>
<body>
<div style="margin-left: 490px"> <!-- 사이즈 보기 -->
	<h1>유저정보 보기</h1>
	</div>
	<form method=post action="">
	<table class="table" style="width: 1400px"> <!-- 사이즈 보기 -->
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>닉네임</th>
			<th>생년월일</th>
			<th>이메일</th>
			<th>성별</th>
			<th>우편번호</th>
			<th>주소</th>
			<th>상세 주소</th>
			<th>전화번호</th>
			<th></th>
			<th></th>
		</tr>	
		<c:forEach var="vo" items="${ulist }">
		<tr>
			<td>${vo.id }</td>
			<td>${vo.name }</td>
			<td>${vo.nickname }</td>
			<td>${vo.birthday }</td>
			<td>${vo.email }</td>
			<td>${vo.sex }</td>
			<td>${vo.post }</td>
			<td>${vo.addr1 }</td>
			<td>${vo.addr2 }</td>
			<td>${vo.phone }</td>
			
			<td><span class="btn btn-xs btn-danger user_ups" data-no="${vo.id }" style="width: 70px">수정</span></td>
			<td><a href="user_delete_ok.do?id=${vo.id }" class="btn btn-sm btn-danger">회원 삭제</a></td>
		</tr>
		<tr style="display: none" class="updates" id="u${vo.id }">
			        <form method="post" action="userupdate_ok.do">
			         <td><input type="hidden" name=id value="${vo.id }">${vo.id }</td>
			         <td><input type="text" name=name size=10 class="input-sm" value="${vo.name }"></td>
			         <td><input type="text" name=nickname size=10 class="input-sm" value="${vo.nickname }"></td>
			         <td><input type="text" name=birthday size=10 class="input-sm" value="${vo.birthday }"></td>
			         <td><input type="text" name=email size=10 class="input-sm" value="${vo.email }"></td>
			         <td><input type="text" name=sex size=10 class="input-sm" value="${vo.sex }"></td>
			         <td><input type="text" name=post size=10 class="input-sm" value="${vo.post }"></td>
			         <td><input type="text" name=addr1 size=10 class="input-sm" value="${vo.addr1 }"></td>
			         <td><input type="text" name=addr2 size=10 class="input-sm" value="${vo.addr2 }"></td>
			         <td><input type="text" name=phone size=10 class="input-sm" value="${vo.phone }"></td>
<%-- 					<td><img src="${vo.poster }" style="width: 30px;height: 30px"></td> --%>
<!-- 		            <td style="width: 70px"><input type=submit value="수정" class="btn btn-sm btn-danger" style="width: 70px;height: 42px"></td> -->
					<td><button class="btn btn-sm btn-danger">수정</button></td>
		            <td style="width: 70px"></td>
			        </form>
			     </tr>
		</c:forEach>
	</table>
	</form>
	
<!-- 	<div class="container"> -->
<!--       <div class="row"> -->
<!--         <div class="justify-content-center"> -->
<!--          <nav id="pagination" aria-label="Page navigation" style="margin-left:600px;"> -->
<!-- 	            <ul class="pagination justify-content-center"> -->
<%-- 		 			<c:if test="${ucurpage>1 }"> --%>
<%-- 		            <li class="page-item"><a class="page-link" href="userinfo.do?&page=${ucurpage>1?ucurpage-1:ucurpage }">Previous</a></li> --%>
<%-- 					</c:if> --%>
					
<%-- 		             <c:forEach var="i" begin="${ustartpage }" end="${uendpage }"> --%>
<%-- 		             	<c:if test="${i==ucurpage }"> --%>
<%-- 		             	<li class="page-item"><a class="active" class="active" href="userinfo.do?page=${i }">${i }</a></li> --%>
<%-- 		             	</c:if> --%>
<%-- 		             	<c:if test="${i!=ucurpage }"> --%>
<%-- 		             	<li class="page-item"><a class="page-link" class="active" href="userinfo.do?page=${i }">${i }</a></li> --%>
<%-- 		             	</c:if> --%>
<%-- 		             </c:forEach>  --%>
		             
<%-- 	                <c:if test="${ucurpage<utotalpage }"> --%>
<%-- 	                <li class="page-item"><a class="page-link" href="userinfo.do?page=${ucurpage<utotalpage?ucurpage+1:ucurpage }">Next</a></li> --%>
<%-- 	              </c:if> --%>
<!-- 	            </ul> -->
<!-- 	        </nav> -->
<!--         </div> -->
	   
<!--     </div> -->
<!--       </div> -->
</body>
</html>