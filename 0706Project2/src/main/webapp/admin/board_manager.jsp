<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
                <td><input type="button" value="수정" class="btn btn-sm btn-danger"></td>
                <td><input type="button" value="삭제" class="btn btn-sm btn-danger"></td>
            </tr>
            </c:forEach>
        </table>
        
        <div class="container">
      <div class="row">
        <div class="justify-content-center">
         <nav id="pagination" aria-label="Page navigation" style="margin-left:600px;">
	            <ul class="pagination justify-content-center">
		 			<c:if test="${bcurpage>1 }">
		            <li class="page-item"><a class="page-link" href="adminpage.do?mode=5&page=${bcurpage>1?bcurpage-1:bcurpage }">Previous</a></li>
					</c:if>
					
		             <c:forEach var="i" begin="${bstartpage }" end="${bendpage }">
		             	<c:if test="${i==bcurpage }">
		             	<li class="page-item"><a class="active" class="active" href="adminpage.do?mode=5&page=${i }">${i }</a></li>
		             	</c:if>
		             	<c:if test="${i!=bcurpage }">
		             	<li class="page-item"><a class="page-link" class="active" href="adminpage.do?mode=5&page=${i }">${i }</a></li>
		             	</c:if>
		             </c:forEach> 
		             
	                <c:if test="${bcurpage<btotalpage }">
	                <li class="page-item"><a class="page-link" href="adminpage.do?mode=5&page=${bcurpage<btotalpage?bcurpage+1:curpage }">Next</a></li>
	              </c:if>
	            </ul>
	        </nav>
        </div>
	   
    </div>
      </div>

</body>
</html>