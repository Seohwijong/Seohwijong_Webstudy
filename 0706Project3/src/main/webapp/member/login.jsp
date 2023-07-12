<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Insert title here</title>

<style type="text/css">

/* html { */

/*   height: 100%; */

/* } */

/* body { */

/*   margin:0; */

/*   padding:0; */

/*   font-family: sans-serif; */

/*   background: linear-gradient(#141e30, #243b55); */

/* } */



.login-box {

  position: relatives;

  top: 50%;

  left: 50%;

  width: 400px;

  padding: 40px;

  /* transform: translate(-50%, -50%); */

  margin : 0px auto;

  background: rgba(0,0,0,.5);

  box-sizing: border-box;

  box-shadow: 1 15px 25px rgba(0,0,0,.6);

  border-radius: 10px;

}



.login-box h2 {

  margin: 0 0 30px;

  padding: 0;

  color: #fff;

  text-align: center;

}



.login-box .user-box {

  position: relative;

}



.login-box .user-box input {

  width: 100%;

  padding: 10px 0;

  font-size: 16px;

  color: #fff;

  margin-bottom: 30px;

  border: none;

  border-bottom: 1px solid #fff;

  outline: none;

  background: transparent;

}

.login-box .user-box label {

  position: absolute;

  top:0;

  left: 0;

  padding: 10px 0;

  font-size: 16px;

  color: #fff;

  /* pointer-events: none; */

  transition: .5s;

}



.login-box .user-box input:focus ~ label,

.login-box .user-box input:valid ~ label {

  top: -20px;

  left: 0;

  color: #03e9f4;

  font-size: 12px;

}



.login-box form a {

  position: relative;

  display: inline-block;

  padding: 10px 20px;

  color: #03e9f4;

  font-size: 16px;

  text-decoration: none;

  text-transform: uppercase;

  overflow: hidden;

  transition: .5s;

  margin-top: 40px;

  letter-spacing: 4px

}



.login-box a:hover {

  background: #03e9f4;

  color: #fff;

  border-radius: 5px;

  box-shadow: 0 0 5px #03e9f4,

              0 0 25px #03e9f4,

              0 0 50px #03e9f4,

              0 0 100px #03e9f4;

}



.login-box a span {

  position: absolute;

  display: block;

}



.login-box a span:nth-child(1) {

  top: 0;

  left: -100%;

  width: 100%;

  height: 2px;

  background: linear-gradient(90deg, transparent, #03e9f4);

  animation: btn-anim1 1s linear infinite;

}



@keyframes btn-anim1 {

  0% {

    left: -100%;

  }

  50%,100% {

    left: 100%;

  }

}



.login-box a span:nth-child(2) {

  top: -100%;

  right: 0;

  width: 2px;

  height: 100%;

  background: linear-gradient(180deg, transparent, #03e9f4);

  animation: btn-anim2 1s linear infinite;

  animation-delay: .25s

}



@keyframes btn-anim2 {

  0% {

    top: -100%;

  }

  50%,100% {

    top: 100%;

  }

}



.login-box a span:nth-child(3) {

  bottom: 0;

  right: -100%;

  width: 100%;

  height: 2px;

  background: linear-gradient(270deg, transparent, #03e9f4);

  animation: btn-anim3 1s linear infinite;

  animation-delay: .5s

}



@keyframes btn-anim3 {

  0% {

    right: -100%;

  }

  50%,100% {

    right: 100%;

  }

}



.login-box a span:nth-child(4) {

  bottom: -100%;

  left: 0;

  width: 2px;

  height: 100%;

  background: linear-gradient(360deg, transparent, #03e9f4);

  animation: btn-anim4 1s linear infinite;

  animation-delay: .75s

}



@keyframes btn-anim4 {

  0% {

    bottom: -100%;

  }

  50%,100% {

    bottom: 100%;

  }

}
</style>
<script type="text/javascript">
function log(){
	$('#logBtn').click(function(){
		// 유효성 검사 => 반드시 입력
		let id=$('#id').val();
		if(id.trim()=="")
			{
				$('#id').focus();
				return;
			}
		let pwd=$('#pwd').val();
		if(pwd.trim()=="")
		{
			$('#pwd').focus();
			return;
		}
		
		// 전송 => 실행결과를 가지고 온다 (자체 처리) (요청 = 응답 : Ajax,Vue,React)
		$.ajax({
			type:'post',
			url:'../member/login_ok.do',
			data:{"id":id,"pwd":pwd},
			success:function(result) //NOID,NOPWD,OK
			{
				let res=result.trim();
				if(res==='NOID')
				{
					alert("아이디가 존재하지 않습니다!");
					$('#id').val("");
					$('#pwd').val("");
					$('#id').focus();
				}
				else if(res==='NOPWD')
				{
					alert("비밀번호가 틀립니다!")
					$('#pwd').val("");
					$('#pwd').focus();
				}
				else 
				{
					location.href="../jsp/main.do"
				}
			}
		})
	})
}
</script>

</head>

<body>

<div class="row" style="padding-top: 30px">

<div class="login-box">

  <h2>LOGIN</h2>
	<form>
 
    <div class="user-box">

      <input type="text" name="id" id="id" required="required">

      <label>ID</label>

    </div>

    <div class="user-box">

      <input type="password" name="pwd" id="pwd" required="required">

      <label>PWD</label>

    </div>
 <div>
     <a href="javascript:void(0);" id="logBtn" onclick="log()"> 
	
      <span></span>

      <span></span>

      <span></span>

      <span></span>

      Login
	</a>
	</div>
	<div>
     <a href="javascript:void(0);" id="logBtn" onclick="log()"> 
	
      <span></span>

      <span></span>

      <span></span>

      <span></span>

      Find id
	</a>
  <a href="javascript:void(0);" id="logBtn" onclick="log()"> 
	
      <span></span>

      <span></span>

      <span></span>

      <span></span>

      Find pwd?
	</a>
  </div>
</form>
</div> 

</div>

</body>

</html>