<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <meta name="description" content="Start your development with JoeBLog landing page.">
   <meta name="author" content="Devcrud">
   <title>JoeBLog | Components</title>
   <!-- font icons -->
   <link rel="stylesheet" href="../assets/vendors/themify-icons/css/themify-icons.css">
   <!-- Bootstrap + Steller  -->
   <link rel="stylesheet" href="../assets/css/joeblog.css">
   <link rel="stylesheet" href="../shadow/css/shadowbox.css">
<style type="text/css">
.container{
	margin-top: 50px;
}
.row1{
	margin: 0px auto;
	width:700px;
} 
h1{
	text-align: center;
	font-family: 'Noto Sans KR', sans-serif;
}
</style>
<!-- import -->
<script type="text/javascript" src="https://code.jquery.com/jquery.js"></script>
<script type="text/javascript" src="../shadow/js/shadowbox.js"></script>
<script type="text/javascript">
function check_pwd(){
	if(document.getElementById('pwd1').value !='' && document.getElementById('pwd2').value!=''){
        if(document.getElementById('pwd1').value==document.getElementById('pwd2').value){
            document.getElementById('check').innerHTML='비밀번호가 일치합니다.'
            document.getElementById('check').style.color='blue';
        }
        else{
            document.getElementById('check').innerHTML='비밀번호가 일치하지 않습니다.';
            document.getElementById('check').style.color='red';
        }
	}
}
function fn_dbCheckId(){
	
	let id= $('#id').val()
		$.ajax({
			type:'post',
			url:'../member/idcheck_ok.do',
			data:{"id":id},
			success:function(result) // result(실행결과 읽기) => callback
			{
				
				let count=Number(result.trim());
				if(count==0)
				{
					$('#res').html(
					 '<span style="color:blue">'
					 +id+"는(은) 사용 가능한 아이디입니다!!</span>"
					)
					
					
				}
				else if(count==1)
				{
					$('#res').html(
							 '<span style="color:red">'
							 +id+"는(은) 이미 사용중인 아이디입니다!!</span>"
					)
					$('#id').val("")
					$('#id').focus()
				}
				else
				{
					$('#res').html(
							 '<span style="color:red">공백은 사용할수 없습니다.</span>'
							 
					)
					$('#id').val("")
					$('#id').focus()
				}
			}
		})
}
function fn_dbCheckNick(){
	
	let nickname= $('#nickname').val()
		$.ajax({
			type:'post',
			url:'../member/nicknamecheck_ok.do',
			data:{"nickname":nickname},
			success:function(result) // result(실행결과 읽기) => callback
			{
				
				let count=Number(result.trim());
				if(count==0)
				{
					$('#res2').html(
					 '<span style="color:blue">'
					 +nickname+"는(은) 사용 가능한 닉네임입니다!!</span>"
					)
					
					
				}
				else if(count==1)
				{
					$('#res2').html(
							 '<span style="color:red">'
							 +nickname+"는(은) 이미 사용중인 닉네임입니다!!</span>"
					)
					$('#nickname').val("")
					$('#nickname').focus()
				}
				else 
				{
					$('#res2').html(
							 '<span style="color:red">공백은 사용을 못해용</span>'
							
					)
					$('#nickname').val("")
					$('#nickname').focus()
				}
			}
		})
}
</script>
<script>
Shadowbox.init({
	   players:['iframe']
	})
	$(function(){  
	   $('#postBtn').click(function(){
	      Shadowbox.open({
	    	  content:'../member/postfind.do',
	    	  player:'iframe',
	    	  width:520,
	    	  height:350,
	    	  title:'우편번호 검색'
	      })
	   })
	   
	   $('#joinBtn').click(function(){
		   $('#joinFrm').submit();
	   })
	})
</script>

</head>
<body>
 
    <!-- End Of Page Second Navigation -->

   <!-- Page Header -->
   <header class="header header-mini"> 
      <div class="header-title">회원가입</div> 
      <nav aria-label="breadcrumb">
      </nav>
   </header> <!-- End Of Page Header -->

   <!-- main content -->
   <div class="container">

      <!-- Inputs -->
      <div class="row row1">
        <form method=post action="../member/join_ok.do" name=joinFrm
	        id="joinFrm" >      
	      <table class="table">
	        <tr>
	          <th class="text-left" width=30%>아이디</th>
	          <td width=70%>
	            <input type=text id="id" name="id" onkeydown="inputIdChk()" class=input-sm" size=15 placeholder="ID를 입력하세요">
	            <button type=button onclick="fn_dbCheckId()" name=dbCheckId class=checkId>중복확인</button>
	          </td>
	          <tr>
	          <td class="text-right" colspan="2" id="res"></td>
	          </tr>
	        </tr>
	        <tr>
	          <th class="text-left" width=30%>비밀번호</th>
	          <td width=70%>
	            <input type=password name="pwd" id=pwd1 onchange="check_pwd()" class=input-sm" size=20>
	          </td>
	        </tr>
	        <tr>
	          <th class="text-left" width=30%>비밀번호 확인</th>
	          <td width=70%>
	            <input type=password name="pwd" id=pwd2 onchange="check_pwd()" class=input-sm" size=20><br><span id="check"></span>
	          </td>
	        </tr>
	        <tr>
	          <th class="text-left" width=30%>이름</th>
	          <td width=70%>
	            <input type=text name="name" class=input-sm" size=15>
	          </td>
	        </tr>
	        <tr>
	          <th class="text-left" width=30%>닉네임</th>
	          <td width=70%>
	            <input type=text name="nickname" id="nickname" class=input-sm" size=15>
	            <button type=button onclick="fn_dbCheckNick()" name=dbCheckId class=checkId>중복확인</button>
	          </td>
	            <tr>
	          <td class="text-right" colspan="2"id=res2></td>
	          </tr>
	        </tr>
	        <tr>
	          <th class="text-left" width=30%>성별</th>
	          <td width=70% class="inline">
	            <input type="radio" name=sex value="남자" checked>남자
          <input type="radio" name=sex value="여자">여자
	          </td>
	        </tr>
	        <tr>
	          <th class="text-left" width=30%>생년월일</th>
	          <td width=70%>
	            <input type=date name="birthday" class=input-sm">
	          </td>
	        </tr>
	          <tr>
	         <th class="text-left" width=10%>전화</th>
	         <td width=90% class="inline">
	          <select name=phone1 class="input-sm">
	           <option>010</option>
	          </select>
	          <input type=text name=phone2 id=phone size=12 class="input-sm">
	          <input type=button value="전화체크" 
	            class="btn btn-sm btn-warning" id="phoneBtn">
	         </td>
        </tr> 
	        <tr>
	          <th class="text-left" width=30%>이메일</th>
	          <td width=70%>
	            <input type=text name="email1" class="input-sm" size=20>
	            <span>@</span>
	            <input type=text name="email2" class="input-sm" size=20 placeholder="이메일을 선택하세요">
	            	<select id="select">
	            		<option value="" disabled selected>E-mail 선택</option>
	            		<option value="directly" id="textEmail">직접 입력하기</option>
	                    <option value="naver.com" id="naver.com">naver.com</option>
	                    <option value="hanmail.net" id="hanmail.net">hanmail.net</option>
	                    <option value="gmail.com" id="gmail.com">gmail.com</option>
	                    <option value="nate.com" id="nate.com">nate.com</option>
                    </select>
	          </td>
	        </tr>
	        <tr>
	           <th class="text-left" width=30%>주소</th>
	           <td width=70%>
	           		<input type="text" id="post" name="post" placeholder="우편번호">
					<input type="button" id="postBtn" onclick="sample3_execDaumPostcode()" value="우편번호 찾기"><br>
					<input type="text" id="addr1" name="addr1" placeholder="주소"><br>
					<input type="text" id="addr2" name="addr2" placeholder="상세주소">
			   </td>
	         </tr>
	         
	         <tr>
	          <td colspan="2" class="text-center">
	            <input type=button value="회원가입" class="btn btn-sm btn-info" id="joinBtn">
	            <input type=button value="취소" class="btn btn-sm btn-info"
	             onclick="javascript:history.back()">
	          </td>
	        </tr>
	      </table>
	      </form>
         <!-- <div class="col-md-6">
         	<div class="form-group">
               아이디<input type="text" class="form-control" id="exampleFormControlInput1" placeholder="ID를 입력하세요">
            </div>   
            <div class="form-group">
               비밀번호<input type="password" class="form-control" id="exampleFormControlInput1" placeholder="비밀번호를 입력하세요">
            </div>
            <div class="form-group">
               비밀번호 확인<input type="email" class="form-control" id="exampleFormControlInput1" placeholder="비밀번호를 확인하세요">
            </div>   
            <div class="form-group">
               이름<input type="email" class="form-control" id="exampleFormControlInput1" placeholder="이름">
            </div>
            <div class="form-group">
               닉네임<input type="email" class="form-control" id="exampleFormControlInput1" placeholder="닉네임">
            </div>   
         	<div class="form-group">
               성별
            </div>   
            <div class="form-group">
               생년월일<input type="date" class="form-control" id="exampleFormControlInput1">
            </div>
            <div class="form-group">
               이메일<input type="email" class="form-control" id="exampleFormControlInput1" placeholder="Email address">
            </div>   
            <div class="form-group">
               주소<input type="email" class="form-control" id="exampleFormControlInput1" placeholder="이름">
            </div>
         </div> -->
      </div> <!-- end of inputs -->   

      
   <!-- Page Footer -->
    <footer class="page-footer">
        <div class="container">
            <p class="border-top mb-0 mt-4 pt-3 small">&copy; <script>document.write(new Date().getFullYear())</script>, JoeBlog Created By <a href="https://www.devcrud.com" class="text-muted font-weight-bold" target="_blank">DevCrud.</a>  All rights reserved </p> 
        </div>      
    </footer>
    <!-- End of Page Footer -->
   
   <!-- core  -->
   <script src="assets/vendors/jquery/jquery-3.4.1.js"></script>
   <script src="assets/vendors/bootstrap/bootstrap.bundle.js"></script>

</body>
</html>
