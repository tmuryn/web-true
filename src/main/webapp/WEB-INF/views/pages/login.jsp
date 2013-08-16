<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<p>
<div class="panel panel-info">
			<div class="panel-heading"><h3 class="panel-title">Вход</h3></div>
	<form action="<c:url value='j_spring_security_check' />" method="post">
		
			


			<c:if test="${not empty error}">
				<div class="alert alert-error">
					Неверный email или пароль
				</div>
			</c:if>
			
			<div class="form-group">
			 
			<input type="text" name='j_username' class="form-control"
				placeholder="Введите email..."> 
				</div>
				
				<div class="form-group"> 
				 <input
				type="password" name='j_password' placeholder="Введите пароль..." class="form-control">
			</label> 
			</div>
			<button type="submit" class="btn btn-default">Войти</button>
			
			
	</form>

	<br/>
	Также Вы можете войти используя: </br>
	<br> <a
		href="https://loginza.ru/api/widget?token_url=http://localhost:8080/web-true-social/articles&provider=google"
		class="btn btn-default" alt="Google"><img
		src="http://loginza.ru/img/providers/google.png"></a> <a
		href="https://loginza.ru/api/widget?token_url=http://localhost:8080/web-true-social/articles&provider=facebook"
		class="btn btn-default" alt="Facebook"><img
		src="http://loginza.ru/img/providers/facebook.png"></a> <a
		href="https://loginza.ru/api/widget?token_url=http://localhost:8080/web-true-social/articles&provider=mailru"
		class="btn btn-default"><img src="http://loginza.ru/img/providers/mailru.png"
		alt="Mail.ru"></a> <br>
	<br>



</div>
</p>
