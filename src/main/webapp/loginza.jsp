<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.net.URL" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="https://loginza.ru/api/widget?token_url=http://localhost:8080/loginza.jsp" class="loginza">Login OpenID</a>

<iframe src="http://loginza.ru/api/authinfo?token=<%=request.getParameter("token") %>"></iframe>
</body>
</html>