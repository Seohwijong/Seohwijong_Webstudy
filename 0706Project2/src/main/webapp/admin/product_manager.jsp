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
	<table class="table" style="width: 1400px"> <!-- 사이즈 보기 -->
		<tr>
			<th style="width: 60px">번호</th>
			<th style="width: 200px">이름</th>
			<th style="width: 30px"></th>
			<th style="width: 300px">부제목</th>
			<th style="width: 70px">할인률</th>
			<th style="width: 100px">할인가</th>
			<th style="width: 120px">기본가</th>
			<th style="width: 130px">첫구매 할인가</th>
			<th style="width: 50px">별점</th>
			<th style="width: 90px">배달비</th>
			<th style="width: 70px">수량</th>
			<th style="width: 70px"></th>
			<th style="width: 70px"></th>
<!-- 			<th style="width: 90px"></th> -->
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
			<td>${vo.score }</td>
			<td>${vo.delivery_pri }</td>
			<td>${vo.goods_count }</td>
			
		
			
			<td><span class="btn btn-xs btn-danger ups" data-no="${vo.pdno }" style="width: 70px">수정</span></td>
			<td><a href="product_delete.do?pdno=${vo.pdno }" class="btn btn-xs btn-danger" style="width: 70px">삭제</a></td>
		</tr>	
		
		
			<tr style="display: none" class="updates" id="u${vo.pdno }">
			        <form method="post" action="product_update_ok.do" class="inline">
			         <input type=hidden name=pdno value="${vo.pdno}">
			         <%-- bno는 다시 detail.do로 이동 --%>
			         <input type=hidden name=no value="${vo.pdno }">
			         <td style="width: 65px">${vo.pdno }</td>	
<%-- 			         <td><textarea>${vo.pdno }</textarea></td> --%>
					 <td style="width: 170px"><textarea style="width: 170px" name=title value="${vo.title }">${vo.title }</textarea></td>
<%-- 					<td><img src="${vo.poster }" style="width: 30px;height: 30px"></td> --%>
					<td style="width: 30px"><img src="${vo.poster }" style="width: 30px;height: 30px"></td>
					<td style="width: 240px"><textarea style="width: 240px" name=subject value="${vo.subject }">${vo.subject }</textarea></td>
					<td style="width: 40px"><textarea style="width: 40px" name=sale value="${vo.sale }">${vo.sale }</textarea></td>
					<td style="width: 70px"><textarea style="width: 80px" name=priced_sale value="${vo.priced_sale }">${vo.priced_sale }</textarea></td>
					<td style="width: 80px"><textarea style="width: 90px" name=original_pri value="${vo.original_pri }">${vo.original_pri }</textarea></td>
					<td style="width: 90px"><textarea style="width: 90px" name=first_pri value="${vo.first_pri }">${vo.first_pri }</textarea></td>
					<td style="width: 30px"><textarea style="width: 30px" >${vo.score }</textarea></td>
					<td style="width: 60px"><textarea style="width: 70px" name=delivery_pri value="${vo.delivery_pri }">${vo.delivery_pri }</textarea></td>
					<td style="width: 40px"><textarea style="width: 40px" name=goods_count value="${vo.goods_count }">${vo.goods_count }</textarea></td>
		            <td style="width: 70px"><button class="btn btn-sm btn-danger" style="width: 70px;height: 42px">저장</button></td>
		            <td style="width: 70px"></td>
			        </form>
			     </tr>
			  
			
<!-- 			<td><input type="button" value="판매중지" class="btn btn-sm btn-danger"></td> -->
		</c:forEach>
	</table>
<!--   	 </div> -->
  	 <div class="container">
      <div class="row">
        <div class="justify-content-center">
         <nav id="pagination" aria-label="Page navigation" style="margin-left:600px;">
	            <ul class="pagination justify-content-center">
		 			<c:if test="${pcurpage>1 }">
		            <li class="page-item"><a class="page-link" href="product_manager.do?&page=${pcurpage>1?pcurpage-1:pcurpage }">Previous</a></li>
					</c:if>
					
		             <c:forEach var="i" begin="${pstartpage }" end="${pendpage }">
		             	<c:if test="${i==pcurpage }">
		             	<li class="page-item"><a class="active" class="active" href="product_manager.do?page=${i }">${i }</a></li>
		             	</c:if>
		             	<c:if test="${i!=pcurpage }">
		             	<li class="page-item"><a class="page-link" class="active" href="product_manager.do?page=${i }">${i }</a></li>
		             	</c:if>
		             </c:forEach> 
		             
	                <c:if test="${pcurpage<ptotalpage }">
	                <li class="page-item"><a class="page-link" href="product_manager.do?page=${pcurpage<ptotalpage?pcurpage+1:pcurpage }">Next</a></li>
	              </c:if>
	            </ul>
	        </nav>
        </div>
	   
    </div>
      </div>
</body>
</html>