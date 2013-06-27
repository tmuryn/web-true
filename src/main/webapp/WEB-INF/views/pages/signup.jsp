<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="thumbnail">
	<form action="registration" method="post"
		class="form-horizontal">
		<fieldset>
			<legend>Регистрация</legend>

			<div class="control-group">
			
			<label class="control-label">
			Регистрация используя:
			</label> 
			<div class="controls">
			<a
				href="https://loginza.ru/api/widget?token_url=http://localhost:8080/web-true-social/articles&provider=google"
				class="btn" alt="Google"><img
				src="http://loginza.ru/img/providers/google.png"></a> <a
				href="https://loginza.ru/api/widget?token_url=http://localhost:8080/web-true-social/articles&provider=facebook"
				class="btn" alt="Facebook"><img
				src="http://loginza.ru/img/providers/facebook.png"></a> <a
				href="https://loginza.ru/api/widget?token_url=http://localhost:8080/web-true-social/articles&provider=mailru"
				class="btn"><img
				src="http://loginza.ru/img/providers/mailru.png" alt="Mail.ru"></a>
			</div>
			</div>
			
			<br />
			
			
			<div class="control-group">
				<label class="control-label" for="inputEmail">Електронный адрес</label>
				<div class="controls">
					<input class="input-xxlarge" type="text" id="inputEmail" name="account.email"
						placeholder="Корректный електронный адрес">
				</div>
			</div>
			
			<div class="control-group">
				<label class="control-label" for="inputEmail">Пароль</label>
				<div class="controls">
					<input class="input-xxlarge" type="text" id="inputEmail" name="account.password"
						placeholder="от 6 до 12 символов">
				</div>
			</div>
			

			<div class="control-group">
				<label class="control-label" for="inputEmail">Имя, Фамилия</label>
				<div class="controls">
					<input class="input-xxlarge" type="text" id="inputEmail"
						placeholder="От 10 до 100 символов" name="fullName">
				</div>
			</div>

					
			<div class="control-group">
				<label class="control-label" for="invantation">Приглашение експерта</label>
				<div class="controls">
					<input class="input-xxlarge" type="text" id="invantation.code"
						placeholder="Идентификационный номер приглашения">
				</div>
			</div>


			<div class="control-group">
				<div class="controls">
					<label class="checkbox"> <input type="checkbox">
						Принимаю условия <a href="#">соглашения</a>
					</label> <br>
					<button type="submit" class="btn">Зарегистрировать</button>
				</div>
			</div>
	</form>






</div>
