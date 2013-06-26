<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="thumbnail">
	<form action="<c:url value='j_spring_security_check' />" method="post">
		<fieldset>
			<legend>Вход</legend>


			<c:if test="${not empty error}">
				<div class="alert alert-error">
					Неверный email или пароль
				</div>
			</c:if>

			<input type="text" name='j_username'
				placeholder="Введите email..."> </label> <br> <input
				type="password" name='j_password' placeholder="Введите пароль...">
			</label> <br>
			<button type="submit" class="btn">Войти</button>
		</fieldset>
	</form>


	Также Вы можете войти используя: </br>
	<br> <a
		href="https://loginza.ru/api/widget?token_url=http://localhost:8080/web-true-social/articles&provider=google"
		class="btn" alt="Google"><img
		src="http://loginza.ru/img/providers/google.png"></a> <a
		href="https://loginza.ru/api/widget?token_url=http://localhost:8080/web-true-social/articles&provider=facebook"
		class="btn" alt="Facebook"><img
		src="http://loginza.ru/img/providers/facebook.png"></a> <a
		href="https://loginza.ru/api/widget?token_url=http://localhost:8080/web-true-social/articles&provider=mailru"
		class="btn"><img src="http://loginza.ru/img/providers/mailru.png"
		alt="Mail.ru"></a> <br>
	<br>



</div>
