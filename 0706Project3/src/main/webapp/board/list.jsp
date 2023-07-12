<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html> 
<html>  
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous"> -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<link rel="stylesheet" href="../board/css/search-bar.css">


</head>
<body>
<div>
<ul class="a">
  <li><a class="home" href="#">전체</a></li>
  <li><a class="ll" href="#">공지</a></li>
  <li><a class="ll" href="#">레시피</a></li>
  <li><a class="ll" href="#">스토어</a></li>
  <li><a class="ll" href="#">공유주방</a></li>
</ul>
</div>

    <div class="wrapper row3">
    <main class="container clear">
     <table class = "table">
        <tr>
         <td>
          <a href="" class="btn btn-success" role="button" id="write-article" >글쓰기</a>
<!--               <div class="row"> -->
         <div class="card card-margin search-form">
            <div class="card-body p-0">
                <form id="search-form">
                    <div class="row">
                        <div class="col-12">
                            <div class="row no-gutters">
                                <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                                
                                    <label for="search-type" hidden>검색 유형</label>
                                    <select class="form-control" id="search-type" name="searchType">
                                        <option>제목</option>
                                        <option>본문</option>
                                        <option>id</option>
                                        <option>닉네임</option>
                                        <option>해시태그</option>
                                    </select>
                                </div>
                                <div class="col-lg-8 col-md-6 col-sm-12 p-0">
                                    <label for="search-value" hidden>검색어</label>
                                    <input type="text" placeholder="검색어를 입력해주세요." class="form-control" id="search-value"
                                           name="searchValue">
                                </div>
                                <div class="col-lg-1 col-md-3 col-sm-12 p-0">
                                    <button type="submit" class="btn btn-base">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                             viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
                                             stroke-linecap="round" stroke-linejoin="round"
                                             class="feather feather-search">
                                            <circle cx="11" cy="11" r="8"></circle>
                                            <line x1="21" y1="21" x2="16.65" y2="16.65"></line>
                                        </svg>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
      </div>
<!--     </div> -->
         </td>
        </tr>    
           
     </table>
     <table class="table table-hover" id="article-table">
           <tr class="table-success">
                <th width=10% class="text-center">번호</th>
                <th width=20% class="text-center">제목</th>
                <th width=15% class="text-center">이름</th>
                <th width=10% class="text-center">작성일</th>
                <th width=10% class="text-center">조회수</th>
                <th width=10% class="text-center">추천수</th>
            </tr>

            <c:forEach var="vo" items="${list}">
            <tr class="table">
                <td width=10% class="text-center">${vo.bno }</td>
                <td width=20% class="text-center">${vo.subject }</td>
                <td width=10% class="text-center">${vo.name }</td>
                <td width=10% class="text-center">${vo.dbday }</td>
                <td width=10% class="text-center">${vo.hit }</td>
                <td width=10% class="text-center">${vo.suggest }</td>
            </tr>
            </c:forEach>
        </table>
    </main>
    </div>
	  	
    

    <div class="container">
      <div class="row">
        <div class="justify-content-center">
         <nav id="pagination" aria-label="Page navigation" style="margin-left:400px;">
	            <ul class="pagination justify-content-center">
		 			<c:if test="${curpage>1 }">
		            <li class="page-item"><a class="page-link" href="list.do?page=${curpage>1?curpage-1:curpage }">Previous</a></li>
					</c:if>
					
		             <c:forEach var="i" begin="${startpage }" end="${endpage }">
		             	<c:if test="${i==curpage }">
		             	<li class="page-item"><a class="active" class="active" href="list.do?page=${i }">${i }</a></li>
		             	</c:if>
		             	<c:if test="${i!=curpage }">
		             	<li class="page-item"><a class="page-link" class="active" href="list.do?page=${i }">${i }</a></li>
		             	</c:if>
		             </c:forEach> 
		             
	                <c:if test="${curpage<totalpage }">
	                <li class="page-item"><a class="page-link" href="list.do?page=${curpage<totalpage?curpage+1:curpage }">Next</a></li>
	              </c:if>
	            </ul>
	        </nav>
        </div>
	   
    </div>
      </div>
       
</body>
</html>