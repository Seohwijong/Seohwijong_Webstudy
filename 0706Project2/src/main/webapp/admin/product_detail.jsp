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
	$('.ups').click(function(){
		let no=$(this).attr("data-no");
		$('.ups').text("수정");
		if(u===0)
		{
			$('#u'+no).show();
			$(this).text("취소");
			u=1;
		}
		else
		{
			$('#u'+no).hide();
			$(this).text("수정");
			u=0;
		}
	})
})
</script>
</head>
<body>
	<div style="margin-left: 490px"> <!-- 사이즈 보기 -->
	<h1>상품정보 보기</h1>
	</div>
	<c:forEach var="vo" items="${plist }">
	<table class="table" style="width: 200px;height: 400px;"> <!-- 사이즈 보기 -->
		<tr>
			<td><img src="${vo.poster }" style="width: 200px;height: 200px"></td>
			
		</tr>	
		<tr>
			<td>${vo.pdno }&nbsp;&nbsp;&nbsp;${vo.title }</td>
			<td><span class="btn btn-xs btn-danger ups" data-no="${vo.pdno }" style="width: 70px">수정</span></td>
			<td><input type="button" value="삭제" class="btn btn-sm btn-danger"></td>
		</tr>

		</table>
		<table>
			<tr style="display: none" class="updates" id="u${vo.pdno }">
			        <form method="post" action="#" class="inline">
			         <input type=hidden name=pdno value="${vo.pdno}">
			         <%-- bno는 다시 detail.do로 이동 --%>
			         <input type=hidden name=no value="${vo.pdno }">
			         <td style="width: 65px">${vo.pdno }</td>	
<%-- 			         <td><textarea>${vo.pdno }</textarea></td> --%>
					 <td style="width: 170px"><textarea style="width: 170px">${vo.title }</textarea></td>
<%-- 					<td><img src="${vo.poster }" style="width: 30px;height: 30px"></td> --%>
					<td style="width: 30px"><img src="${vo.poster }" style="width: 30px;height: 30px"></td>
					<td style="width: 240px"><textarea style="width: 240px">${vo.subject }</textarea></td>
					<td style="width: 40px"><textarea style="width: 40px">${vo.sale }</textarea></td>
					<td style="width: 70px"><textarea style="width: 80px">${vo.priced_sale }</textarea></td>
					<td style="width: 80px"><textarea style="width: 90px">${vo.original_pri }</textarea></td>
					<td style="width: 90px"><textarea style="width: 90px">${vo.first_pri }</textarea></td>
					<td style="width: 30px"><textarea style="width: 30px">${vo.score }</textarea></td>
					<td style="width: 60px"><textarea style="width: 70px">${vo.delivery_pri }</textarea></td>
					<td style="width: 40px"><textarea style="width: 40px">${vo.goods_count }</textarea></td>
		            <td style="width: 70px"><input type=submit value="수정" class="btn btn-sm btn-danger" style="width: 70px;height: 42px"></td>
		            <td style="width: 70px"></td>
			        </form>
			     </tr>
			  
			
<!-- 			<td><input type="button" value="판매중지" class="btn btn-sm btn-danger"></td> -->
		
	</table>
	</c:forEach>
<!-- 	<div class="text-center"> -->
<!-- 			<ul class="pagination" style="margin-left: 650px;width: 1000px;"> -->
<%--   	 	  <c:if test="${pstartpage>1 }"> --%>
<%--   	 	  	<li><a href="adminpage.do?mode=2&page=${pstartpage-1 }" style="font-size: 30px" >&lt;이전</a></li>  --%>
<%--   	 	  </c:if> --%>
<%--   	 	  <c:forEach var="i" begin="${pstartpage }" end="${pendpage }"> --%>
<%--   	 	     <c:if test="${pcurpage==i }"> --%>
<%--   	 	     <li class="active"><a href="adminpage.do?mode=2&page=${i}" style="font-size: 30px">${i }</a></li> --%>
<%--   	 	     </c:if> --%>
<%--   	 	     <c:if test="${pcurpage!=i }"> --%>
<%--   	 	     <li class=""><a href="adminpage.do?mode=2&page=${i}" style="font-size: 30px">${i }</a></li> --%>
<%--   	 	     </c:if> --%>
<%--   	 	  </c:forEach> --%>
<%--   	 	   <c:if test="${pendpage<ptotalpage }"> --%>
<%--   	 	    <li><a href="adminpage.do?mode=2&page=${pendpage+1 }" style="font-size: 30px">다음&gt;</a></li> --%>
<%--   	 	  </c:if> --%>
<!--   	 	  	</ul> -->

<!--   	 </div> -->
  	 <div class="container">
      <div class="row">
        <div class="justify-content-center">
         <nav id="pagination" aria-label="Page navigation" style="margin-left:600px;">
	            <ul class="pagination justify-content-center">
		 			<c:if test="${pcurpage>1 }">
		            <li class="page-item"><a class="page-link" href="adminpage.do?mode=2&page=${pcurpage>1?pcurpage-1:curpage }">Previous</a></li>
					</c:if>
					
		             <c:forEach var="i" begin="${pstartpage }" end="${pendpage }">
		             	<c:if test="${i==pcurpage }">
		             	<li class="page-item"><a class="active" class="active" href="adminpage.do?mode=2&page=${i }">${i }</a></li>
		             	</c:if>
		             	<c:if test="${i!=pcurpage }">
		             	<li class="page-item"><a class="page-link" class="active" href="adminpage.do?mode=2&page=${i }">${i }</a></li>
		             	</c:if>
		             </c:forEach> 
		             
	                <c:if test="${pcurpage<ptotalpage }">
	                <li class="page-item"><a class="page-link" href="adminpage.do?mode=2&page=${pcurpage<ptotalpage?pcurpage+1:pcurpage }">Next</a></li>
	              </c:if>
	            </ul>
	        </nav>
        </div>
	   
    </div>
      </div>
</body>
</html>