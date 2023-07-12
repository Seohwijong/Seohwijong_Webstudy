<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
// $(function(){
// 	$('#logoutBtn').click(function(){
// 		location.href="../member/logout.do";
// 	})
// })	
function logout(){
	location.href="../member/logout.do";
}
</script>
</head>
<body>
 <nav class="navbar navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="../jsp/main.do">
                <img src="../assets/imgs/logo.png" alt="">
            </a>
            <div class="socials">
                <a href="javascript:void(0)"><i class="ti-facebook"></i></a>
                <a href="javascript:void(0)"><i class="ti-twitter"></i></a>
                <a href="javascript:void(0)"><i class="ti-pinterest-alt"></i></a>
                <a href="javascript:void(0)"><i class="ti-instagram"></i></a>
                <a href="javascript:void(0)"><i class="ti-youtube"></i></a>
            </div>
   </div> 
    </nav> 
    <nav class="navbar custom-navbar navbar-expand-md navbar-light bg-primary sticky-top">
         <div class="container"> 
            <button class="navbar-toggler ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav">                     
                    <li class="nav-item">
                        <a class="nav-link" href="../jsp/main.do"><svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 576 512"><!--! Font Awesome Free 6.4.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M575.8 255.5c0 18-15 32.1-32 32.1h-32l.7 160.2c0 2.7-.2 5.4-.5 8.1V472c0 22.1-17.9 40-40 40H456c-1.1 0-2.2 0-3.3-.1c-1.4 .1-2.8 .1-4.2 .1H416 392c-22.1 0-40-17.9-40-40V448 384c0-17.7-14.3-32-32-32H256c-17.7 0-32 14.3-32 32v64 24c0 22.1-17.9 40-40 40H160 128.1c-1.5 0-3-.1-4.5-.2c-1.2 .1-2.4 .2-3.6 .2H104c-22.1 0-40-17.9-40-40V360c0-.9 0-1.9 .1-2.8V287.6H32c-18 0-32-14-32-32.1c0-9 3-17 10-24L266.4 8c7-7 15-8 22-8s15 2 21 7L564.8 231.5c8 7 12 15 11 24z"/></svg></a>
                    </li>
                    <!-- <li class="nav-item">
                        <a class="nav-link" href="no-sidebar.html">레시피</a>
                    </li> -->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            레시피
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        	 <a class="dropdown-item" href="../list/recipeList.do?type=all">전체보기</a>
                            <a class="dropdown-item" href="../list/recipeList.do?type=soup">국/탕</a>
                            <a class="dropdown-item" href="../list/recipeList.do?type=maindish">메인반찬</a>
                             <a class="dropdown-item" href="../list/recipeList.do?type=sidedish">사이드반찬</a>
                            <!-- <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Something else here</a> -->
                        </div>
                    </li>
                    <!-- <li class="nav-item">
                        <a class="nav-link" href="single-post.html">맛집</a>
                    </li> -->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            맛집
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">한식</a>
                            <a class="dropdown-item" href="#">중식</a>
                             <a class="dropdown-item" href="#">양식</a>
                             <a class="dropdown-item" href="#">디저트</a>
                            <!-- <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Something else here</a> -->
                        </div>
                    </li>
                    <!-- <li class="nav-item">
                        <a class="nav-link" href="single-post.html">상품</a>
                    </li> -->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            스토어
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">특가</a>
                            <a class="dropdown-item" href="#">신상</a>
                             <a class="dropdown-item" href="#">베스트</a>
                            <!-- <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Something else here</a> -->
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../share/shareList.do">공유주방</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            커뮤니티
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                  	      <a class="dropdown-item" href="#">공지사항</a>
                            <a class="dropdown-item" href="../board/list.do">자유게시판</a>
                            <a class="dropdown-item" href="#">묻고 답하기</a>
                            <!-- <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Something else here</a> -->
                        </div>
                    </li>
                    <li class="nav-item">
                        <select class="custom-select" id="inputGroupSelect01">
                        	<option selected="selected">스토어</option>
                        	<option>맛집</option>
                        	<option>주방용품</option>
                        	<option>공유주방</option>
                        </select>
                    </li>
<!--  -->                 
                    <form class="d-flex tm-search-form">
            			<input class="form-control tm-search-input" type="search" placeholder="Search" aria-label="Search" style="width:70%;">
            			<button class="btn btn-outline-success tm-search-btn" type="submit"style="width:30%">검색
                		<i class="fas fa-search"></i>
           				</button>
        			</form>
                </ul>
                <div class="navbar-nav ml-auto">
                <c:if test="${sessionScope.id==null }">
                    <li class="nav-item">
                        <a href="../member/login.do" style="background-color:#0B4C5F; border-radius:15px;" class="btn btn-danger mt-1 btn-sm">로그인</a>
                        <a href="../member/join.do" style="background-color:#ffc90e; color:black; border-radius:15px;" class="btn btn-danger mt-1 btn-sm">회원가입</a>
                    </li>
                   </c:if>
                    <c:if test="${sessionScope.id!=null }">
                    <li class="nav-item">
                    <li>⒰${sessionScope.name }${sessionScope.admin=='y'?"(관리자)":"" }님</li>&nbsp;
                    
     	                 <li><input type=button value="로그아웃" style="background-color:#0B4C5F; border-radius:15px;" class="btn btn-danger mt-1 btn-sm"  id="logoutBtn" onclick="logout()"></li>
     	             <c:if test="${sessionScope.admin!='y' }">    
     	                 <li><a href="../my/mypage.do" style="background-color:#ffc90e; border-radius:15px;" class="btn btn-danger mt-1 btn-sm">마이페이지</a></li>
     	             </c:if>
     	             <c:if test="${sessionScope.admin=='y' }">    
     	                 <li><a href="../admin/adminpage.do" style="background-color:#ffc90e; color:black; border-radius:15px;" class="btn btn-danger mt-1 btn-sm">관리자 페이지</a></li>
     	             </c:if>
                    </li>
                   </c:if>
                </div>
                <div class="navbar-nav ml-auto">
                    <li class="nav-item">
                         
                    </li>
                </div>
            </div>
        </div> 
    </nav>
</body>
</html>