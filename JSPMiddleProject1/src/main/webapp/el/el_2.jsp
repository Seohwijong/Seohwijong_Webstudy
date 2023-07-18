<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
		EL 지원하는 내장객체
		1) requestScope => rquset.setAttribute()
		2) sessionScope => session.setAttribute()
		3) param		=> requset.getParameter()
		4) paramValues	=> request.getParameterValues()
 --%>
<%
	String name="홍길동";
	request.setAttribute("name", "홍길동");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
이름:${name },${requestScope.name}
</body>
</html>