<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	
  
  <div class="container">
  <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img class="d-block w-100" src="../assets/imgs/t2.jpg" alt="First slide" style="height: 350px">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="../assets/imgs/t1.jpg" alt="Second slide" style="height: 350px">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="../assets/imgs/img-1.jpg" alt="Third slide" style="height: 350px">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
</div>
	
    <div class="container">
    <section>
            <div class="feature-posts">                     
                    <span class="feature-post-item">뭐넣지</span>
                <a href="single-post.html" class="feature-post-item">
                    <img src="../assets/imgs/img-1.jpg" class="w-100" alt="">
                    <div class="feature-post-caption">레시피-인기</div>
                </a>
                <a href="single-post.html" class="feature-post-item">
                    <img src="../assets/imgs/img-2.jpg" class="w-100" alt="">
                    <div class="feature-post-caption">레시피-추천</div>
                </a>
                <a href="single-post.html" class="feature-post-item">
                    <img src="../assets/imgs/img-3.jpg" class="w-100" alt="">
                    <div class="feature-post-caption">레시피-신상</div>
                </a>
                <a href="single-post.html" class="feature-post-item">
                    <img src="../assets/imgs/img-4.jpg" class="w-100" alt="">
                    <div class="feature-post-caption">스토어-특가</div>
                </a>
            </div>
        </section> 
        <hr>
        <div class="container-fluid tm-container-content tm-mt-60">
        <div class="row mb-4">
            <h2 class="col-6 tm-text-primary">
                Restaurant
            </h2>
            <div class="col-6 d-flex justify-content-end align-items-center">
                <!-- <form action="" class="tm-text-primary">
                    Page <input type="text" value="1" size="1" class="tm-input-paging tm-text-primary"> of 200
                </form> -->
                <a href="../food/foodList.do">더보기</a>
            </div>
        </div>
        <div class="row tm-mb-90 tm-gallery">
        	<c:forEach var="flist" items="${flist }">
        	<div class="col-xl-3 col-lg-4 col-md-6 col-sm-6 col-12 mb-5">
                <figure class="effect-ming tm-video-item">
              	  <a href="#">
                    <img src="${flist.poster }" alt="Image" class="img-fluid rounded" style="width:250px; height:150px; border-radius:20px;">
                    <figcaption class="d-flex align-items-center justify-content-center">
                         <h2>
                        <c:if test="${flist.title.length()>10 }">
                          	 ${flist.title.substring(0,10) }
                          </c:if>
                       
                          <c:if test="${flist.title.length()<10 }">
                          	 ${flist.title }
                          </c:if>
                        </h2>
                       
                    </figcaption>   
                     e</a>                 
                </figure>
                <div class="d-flex justify-content-between tm-text-gray">
                	<span>${flist.score }</span> 	 
                    <span>${flist.price }</span>
                </div>
            </div>  
            </c:forEach> 
        </div> <!-- row -->
        <div class="row tm-mb-90">
            <!-- <div class="col-12 d-flex justify-content-between align-items-center tm-paging-col">
                <a href="javascript:void(0);" class="btn btn-primary tm-btn-prev mb-2 disabled">Previous</a>
                <div class="tm-paging d-flex">
                    <a href="javascript:void(0);" class="active tm-paging-link"style="color: black;">1</a>
                    <a href="javascript:void(0);" class="tm-paging-link"style="color: black;">2</a>
                    <a href="javascript:void(0);" class="tm-paging-link"style="color: black;">3</a>
                    <a href="javascript:void(0);" class="tm-paging-link"style="color: black;">4</a>
                </div>
                <a href="javascript:void(0);" class="btn btn-primary tm-btn-next">Next Page</a>
            </div>         -->    
        </div>
    </div>
    <div class="container-fluid tm-container-content tm-mt-60">
        <div class="row mb-4">
            <h2 class="col-6 tm-text-primary">
                Recipe
            </h2>
            <div class="col-6 d-flex justify-content-end align-items-center">
                <!-- <form action="" class="tm-text-primary">
                    Page <input type="text" value="1" size="1" class="tm-input-paging tm-text-primary"> of 200
                </form> -->
                <a href="../list/recipeList.do">더보기</a>
            </div>
        </div>
        
        <div class="row tm-mb-90 tm-gallery">
        <!--  cforEach -->
        <c:forEach var="rlist" items="${rlist }">
        	<div class="col-xl-3 col-lg-4 col-md-6 col-sm-6 col-12 mb-5">
                <figure class="effect-ming tm-video-item">
              	  <a href="../list/recipeDetail.do?rdno=${rlist.rdno }">
                    <img src="${rlist.poster }" alt="Image" class="img-fluid rounded" style="width:250px; height:150px; border-radius:20px;">
                    <figcaption class="d-flex align-items-center justify-content-center">
                         <h2>
                        <c:if test="${rlist.title.length()>10 }">
                          	 ${rlist.title.substring(0,10) }
                          </c:if>
                       
                          <c:if test="${rlist.title.length()<10 }">
                          	 ${rlist.title }
                          </c:if>
                        </h2>
                       
                    </figcaption>   
                    </a>                 
                </figure>
                <div class="d-flex justify-content-between tm-text-gray">
                	<img alt="" src="../img/defaultchef_pos.jpg" style="width:50px; border-radius:50px;">
                	<c:if test="${rlist.chef_pos!=null } ">
                    <img alt="" src="${rlist.chef_pos}" style="width:50px; border-radius:50px;">
                    </c:if>
                    <span>${rlist.chef }</span>
                </div>
            </div>  
            </c:forEach>
             <!-- cForeach 끝 -->
        </div> <!-- row -->
       
        <div class="row tm-mb-90">
            <!-- <div class="col-12 d-flex justify-content-between align-items-center tm-paging-col">
                <a href="javascript:void(0);" class="btn btn-primary tm-btn-prev mb-2 disabled">Previous</a>
                <div class="tm-paging d-flex">
                    <a href="javascript:void(0);" class="active tm-paging-link"style="color: black;">1</a>
                    <a href="javascript:void(0);" class="tm-paging-link"style="color: black;">2</a>
                    <a href="javascript:void(0);" class="tm-paging-link"style="color: black;">3</a>
                    <a href="javascript:void(0);" class="tm-paging-link"style="color: black;">4</a>
                </div>
                <a href="javascript:void(0);" class="btn btn-primary tm-btn-next">Next Page</a>
            </div>  -->           
        </div>
    </div>
    <div class="container-fluid tm-container-content tm-mt-60">
        <div class="row mb-4">
            <h2 class="col-6 tm-text-primary">
                Shopping
            </h2>
            <div class="col-6 d-flex justify-content-end align-items-center">
                <!-- <form action="" class="tm-text-primary">
                    Page <input type="text" value="1" size="1" class="tm-input-paging tm-text-primary"> of 200
                </form> -->
                <a href="#">더보기</a>
            </div>
        </div>
        <div class="row tm-mb-90 tm-gallery">
        	<c:forEach var="plist" items="${plist }">
        	<div class="col-xl-3 col-lg-4 col-md-6 col-sm-6 col-12 mb-5">
                <figure class="effect-ming tm-video-item">
              	  <a href="#">
                    <img src="${plist.poster }" alt="Image" class="img-fluid rounded" style="width:250px; height:150px; border-radius:20px;">
                    <figcaption class="d-flex align-items-center justify-content-center">
                         <h2>
                        <c:if test="${plist.title.length()>10 }">
                          	 ${plist.title.substring(0,10) }
                          </c:if>
                       
                          <c:if test="${plist.title.length()<10 }">
                          	 ${plist.title }
                          </c:if>
                        </h2>
                       
                    </figcaption>   
                     e</a>                 
                </figure>
                <div class="d-flex justify-content-between tm-text-gray">
                	<span>${plist.score }</span> 	 
                    <span>${plist.first_pri }</span>
                </div>
            </div>  
            </c:forEach> 
        </div> <!-- row -->
        <div class="row tm-mb-90">
           <!--  <div class="col-12 d-flex justify-content-between align-items-center tm-paging-col">
                <a href="javascript:void(0);" class="btn btn-primary tm-btn-prev mb-2 disabled">Previous</a>
                <div class="tm-paging d-flex">
                    <a href="javascript:void(0);" class="active tm-paging-link"style="color: black;">1</a>
                    <a href="javascript:void(0);" class="tm-paging-link"style="color: black;">2</a>
                    <a href="javascript:void(0);" class="tm-paging-link"style="color: black;">3</a>
                    <a href="javascript:void(0);" class="tm-paging-link"style="color: black;">4</a>
                </div>
                <a href="javascript:void(0);" class="btn btn-primary tm-btn-next">Next Page</a>
            </div>       -->      
        </div>
    </div>
    <div class="container-fluid tm-container-content tm-mt-60">
        <div class="row mb-4">
        
            <h2 class="col-6 tm-text-primary">
                ShareKitchen
            </h2>
            <div class="col-6 d-flex justify-content-end align-items-center">
                <!-- <form action="" class="tm-text-primary">
                    Page <input type="text" value="1" size="1" class="tm-input-paging tm-text-primary"> of 200
                </form> -->
                <a href="../share/shareList.do">더보기</a>
            </div>
        </div>
        <div class="row tm-mb-90 tm-gallery">
        <!-- forEachh -->
        <c:forEach var="slist" items="${slist }">
        	<div class="col-xl-3 col-lg-4 col-md-6 col-sm-6 col-12 mb-5">
                <figure class="effect-ming tm-video-item">
              	  <a href="../share/shareDetail.do?skdno=${slist.skdno }">
                    <img src="${slist.poster }" alt="Image" class="img-fluid rounded" style="width:250px; height:150px; border-radius:20px;">
                    <figcaption class="d-flex align-items-center justify-content-center">
                         <h2>
                        <c:if test="${slist.title.length()>10 }">
                          	 ${slist.title.substring(0,10) }
                          </c:if>
                       
                          <c:if test="${slist.title.length()<10 }">
                          	 ${slist.title }
                          </c:if>
                        </h2>
                       
                    </figcaption>   
                     e</a>                 
                </figure>
                <div class="d-flex justify-content-between tm-text-gray">
                	<span>${slist.max_mem }</span> 	 
                    <span>${slist.price }</span>
                </div>
            </div>  
            </c:forEach>
            <!-- forEach end -->
        </div> <!-- row -->
        <div class="row tm-mb-90">
            <!-- <div class="col-12 d-flex justify-content-between align-items-center tm-paging-col">
                <a href="javascript:void(0);" class="btn btn-primary tm-btn-prev mb-2 disabled">Previous</a>
                <div class="tm-paging d-flex">
                    <a href="javascript:void(0);" class="active tm-paging-link"style="color: black;">1</a>
                    <a href="javascript:void(0);" class="tm-paging-link"style="color: black;">2</a>
                    <a href="javascript:void(0);" class="tm-paging-link"style="color: black;">3</a>
                    <a href="javascript:void(0);" class="tm-paging-link"style="color: black;">4</a>
                </div>
                <a href="javascript:void(0);" class="btn btn-primary tm-btn-next">Next Page</a>
            </div>          -->   
        </div>
    </div>
    </div>
</body>
</html>