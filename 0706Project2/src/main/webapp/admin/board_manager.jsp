<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let u=0;
$(function(){
	$('.admin_board_ups').click(function(){
		let bno=$(this).attr("data-no");
		$('.admin_board_ups').text("수정");
		if(u===0)
		{
			$('#u'+bno).show();
			$(this).text("취소");
			u=1;
		}
		else
		{
			$('#u'+bno).hide();
			$(this).text("수정");
			u=0;
		}
	})
})
</script>
</head>
<body>
<div style="margin-left: 450px"> <!-- 사이즈 보기 -->
	<h1>게시글 정보 보기</h1>
	
</div>
<table class="table" style="width: 1400px;">
           <tr>
                <th width=10% >번호</th>
                <th width=10% >제목</th>
                <th width=10% >이름</th>
                <th width=30% >내용</th>
                <th width=10% >작성일</th>
                <th width=10% >조회수</th>
                <th width=10% >추천수</th>
                <th width=5% ></th>
                <th width=5% ></th>
            </tr>

            <c:forEach var="vo" items="${blist}">
            <tr class="table">
                <td width=10% >${vo.bno }</td>
                <td width=10% >${vo.subject }</td>
                <td width=10% >${vo.name }</td>
                <td width=30% >${vo.content }</td>
                <td width=10% >${vo.dbday }</td>
                <td width=10% >${vo.hit }</td>
                <td width=10% >${vo.suggest }</td>
                <td><span class="btn btn-xs btn-danger admin_board_ups" data-no="${vo.bno }" style="width: 70px">수정</span></td>
                <td><a href="admin_board_delete_ok.do?bno=${vo.bno }" class="btn btn-sm btn-danger">삭제</a></td>
            </tr>
            <tr style="display: none" class="updates" id="u${vo.bno }">
			        <form method="post" action="board_update_ok.do">
			         <td><input type="hidden" name=bno value="${vo.bno }">${vo.bno }</td>
			         <td><input type="text" name=subject size=10 class="input-sm" value="${vo.subject }"></td>
			         <td>${vo.name }</td>
			         <td><textarea name=content value="${vo.content }">${vo.content }</textarea></td>
			         <td>${vo.dbday }</td>
			         <td>${vo.hit }</td>
			         <td>${vo.suggest }</td>
					<td><button class="btn btn-sm btn-danger">수정</button></td>
		            <td style="width: 70px"></td>
			        </form>
			     </tr>
            </c:forEach>
        </table>
        
        <div class="container">
      <div class="row">
        <div class="justify-content-center">
         <nav id="pagination" aria-label="Page navigation" style="margin-left:600px;">
	            <ul class="pagination justify-content-center">
		 			<c:if test="${bcurpage>1 }">
		            <li class="page-item"><a class="page-link" href="board_manager.do?page=${bcurpage>1?bcurpage-1:bcurpage }">Previous</a></li>
					</c:if>
					
		             <c:forEach var="i" begin="${bstartpage }" end="${bendpage }">
		             	<c:if test="${i==bcurpage }">
		             	<li class="page-item"><a class="active" class="active" href="board_manager.do?page=${i }">${i }</a></li>
		             	</c:if>
		             	<c:if test="${i!=bcurpage }">
		             	<li class="page-item"><a class="page-link" class="active" href="board_manager.do?page=${i }">${i }</a></li>
		             	</c:if>
		             </c:forEach> 
		             
	                <c:if test="${bcurpage<btotalpage }">
	                <li class="page-item"><a class="page-link" href="board_manager.do?page=${bcurpage<btotalpage?bcurpage+1:bcurpage }">Next</a></li>
	              </c:if>
	            </ul>
	        </nav>
        </div>
	   
    </div>
      </div>

</body>
</html>