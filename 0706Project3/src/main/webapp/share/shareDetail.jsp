<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Page Header -->
    <header class="page-header page-header-mini">
        <h1 class="title">${svo.title }</h1>
        <ol class="breadcrumb pb-0">
            <li class="breadcrumb-item">${svo.sub_title }</a></li>
        </ol>
    </header>
    <!-- End Of Page Header -->

    <section class="container">
        <div class="page-container">
            <div class="page-content">
                <div class="card">
                    <div class="card-header pt-0">
                        <div class="blog-media mb-4">
                            <img src="${svo.poster }" alt="" class="w-100">
                        </div>  
                        <small class="small text-muted">
                       	<span>${svo.max_mem }</span>
                            <span class="px-2">·</span>
                            <span>${svo.price }</span>
                        </small><br>
                         <small class="small text-muted">
                         <!-- if문쓰기 -->
                            <span class="px-2">${svo.run }</span>
                             <span class="px-2">${svo.holi }</span><br>
                             <span class="px-2">${svo.address }</span><br>
                             <span class="px-2">${svo.hs_tag }</span>
                        </small>
                    </div>
                    <!-- 상세설명 시작 -->
                    <div class="card-body border-top">
                        <h2 class="title text-center">소개</h2> <!-- step 1,2,3,4 -->
                        <!-- for -->
                        <pre>${svo.intro }</pre>
                        <!-- for문 종료 -->
                    </div>
                    <div class="card-body border-top">
                        <h2 class="title text-center">정보</h2> <!-- step 1,2,3,4 -->
                        <!-- for -->
                        <pre>${svo.info }</pre>
                        <!-- for문 종료 -->
                    </div>
                    <div class="card-body border-top">
                        <h2 class="title text-center">환불규정</h2> <!-- step 1,2,3,4 -->
                        <!-- for -->
                       <pre>${svo.refund }</pre>
                        <!-- for문 종료 -->
                    </div>
                    <div class="card-footer">
                         <h6 class="mt-5 mb-3 text-center"><a href="#" class="text-dark">Comments 4</a></h6>
                        <hr>
                        <div class="media">
                            <img src="assets/imgs/avatar-1.jpg" class="mr-3 thumb-sm rounded-circle" alt="...">
                            <div class="media-body">
                                <h6 class="mt-0">Janice Wilder</h6>
                                <p>Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin.</p>
                                <a href="#" class="text-dark small font-weight-bold"><i class="ti-back-right"></i> Replay</a>
                                <div class="media mt-5">
                                    <a class="mr-3" href="#">
                                    <img src="assets/imgs/avatar.jpg" class="thumb-sm rounded-circle" alt="...">
                                    </a>
                                    <div class="media-body align-items-center">
                                        <h6 class="mt-0">Joe Mitchell</h6>
                                        <p>Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus</p>
                                        <a href="#" class="text-dark small font-weight-bold"><i class="ti-back-right"></i> Replay</a>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="media mt-5">
                            <img src="assets/imgs/avatar-2.jpg" class="mr-3 thumb-sm rounded-circle" alt="...">
                            <div class="media-body">
                                <h6 class="mt-0">Crosby Meadows</h6>
                                <p>Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin.</p>
                                <a href="#" class="text-dark small font-weight-bold"><i class="ti-back-right"></i> Replay</a>
                            </div>
                        </div>
                        <div class="media mt-4">
                            <img src="assets/imgs/avatar-3.jpg" class="mr-3 thumb-sm rounded-circle" alt="...">
                            <div class="media-body">
                                <h6 class="mt-0">Jean Wiley</h6>
                                <p>Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin.</p>
                                <a href="#" class="text-dark small font-weight-bold"><i class="ti-back-right"></i> Replay</a>
                            </div>
                        </div>

                        <h6 class="mt-5 mb-3 text-center"><a href="#" class="text-dark">Write Your Comment</a></h6>
                        <hr>
                        <form>
                            <div class="form-row">
                                <div class="col-12 form-group">
                                    <textarea name="" id="" cols="30" rows="10" class="form-control" placeholder="Enter Your Comment Here"></textarea>
                                </div>
                                <div class="col-sm-4 form-group">
                                    <input type="text" class="form-control" value="Name">
                                </div>
                                <div class="col-sm-4 form-group">
                                    <input type="email" class="form-control" placeholder="Email">
                                </div>
                                <div class="col-sm-4 form-group">
                                    <input type="url" class="form-control" placeholder="Website">
                                </div>
                                <div class="form-group col-12">
                                    <button class="btn btn-primary btn-block">Post Comment</button>
                                </div>
                            </div>
                        </form>
                    </div>                  
                </div> 

                <h6 class="mt-5 text-center">Related Posts</h6>
                <hr>
                <div class="row">                       
                    <div class="col-md-6 col-lg-4">
                        <div class="card mb-5">
                            <div class="card-header p-0">                                   
                                <div class="blog-media">
                                    <img src="assets/imgs/blog-2.jpg" alt="" class="w-100">
                                    <a href="#" class="badge badge-primary">#Placeat</a>        
                                </div>  
                            </div>
                            <div class="card-body px-0">
                                <h6 class="card-title mb-2"><a href="#" class="text-dark">Voluptates Corporis Placeat</a></h6>  
                                <small class="small text-muted">January 20 2019 
                                    <span class="px-2">-</span>
                                    <a href="#" class="text-muted">34 Comments</a>
                                </small>
                            </div>                  
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-4">
                        <div class="card mb-5">
                            <div class="card-header p-0">                                   
                                <div class="blog-media">
                                    <img src="assets/imgs/blog-3.jpg" alt="" class="w-100">
                                    <a href="#" class="badge badge-primary">#dolores</a>        
                                </div>  
                            </div>
                            <div class="card-body px-0">
                                <h6 class="card-title mb-2"><a herf="#" class="text-dark">Dolorum Dolores Itaque</a></h6>   
                                <small class="small text-muted">January 19 2019 
                                    <span class="px-2">-</span>
                                    <a href="#" class="text-muted">64 Comments</a>
                                </small>
                            </div>      
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-4 d-none d-lg-block">
                        <div class="card mb-5">
                            <div class="card-header p-0">                                   
                                <div class="blog-media">
                                    <img src="assets/imgs/blog-4.jpg" alt="" class="w-100">
                                    <a href="#" class="badge badge-primary">#amet</a>       
                                </div>  
                            </div>
                            <div class="card-body px-0">
                                <h6 class="card-title mb-2">Quisquam Dignissimos</h6>   
                                <small class="small text-muted">January 17 2019 
                                    <span class="px-2">-</span>
                                    <a href="#" class="text-muted">93 Comments</a>
                                </small>
                            </div>  
                        </div>
                    </div>
                </div>
            </div>
            <!-- Sidebar -->
            <div class="page-sidebar">
               	<h6 class=" ">지도</h6> 
                 <div style="height: 300px;width:280px; border:1px solid red">
                 
                 </div>
    
<!--                 <div class="ad-card"> -->
<!--                    <div style="display"><span href="#" class="font-weight-bold">ADS</span></div> -->
<!--                     <input type="button" value="전체삭제" class="btn btn-sm btn-danger"> -->
<!--                 </div> -->
                <div class="ad-card">
                   <div><table class="table">
                   		<tr>
                   		<td><img src="">pic</td>
                   		</tr>
                   		<tr>
                   			<td>최근목록</td>
                   			
                   		</tr>
                   </table>
                   <input type="button" class="btn btn-sm btn-danger" value="전체삭제">
                   </div>
                </div>
            </div>
        </div>
    </section>

</body>
</html>