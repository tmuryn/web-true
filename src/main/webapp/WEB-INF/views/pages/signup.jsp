<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  


<div class="thumbnail">

	<form:form method="post" action="registration"  modelAttribute="registrationForm" class="form-horizontal">  
	
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
					<form:input  class="input-xxlarge" type="text" id="inputEmail" path="email"
						placeholder="Корректный електронный адрес"/>
						<form:errors path="email" cssClass="alert-error alert input-xlarge" element="div"></form:errors>
				</div>
			</div>
			
			<div class="control-group">
				<label class="control-label" for="inputEmail">Пароль</label>
				<div class="controls">
					<form:input  class="input-xxlarge" type="password" id="inputPassword" path="password"
						placeholder="от 6 до 12 символов"/>
						<form:errors path="password" cssClass="alert-error alert input-xlarge" element="div"></form:errors>
				</div>
			</div>
			

			<div class="control-group">
				<label class="control-label" for="inputName">Имя, Фамилия</label>
				<div class="controls">
					<form:input  path="fullName" class="input-xxlarge" id="inputName"
						placeholder="От 10 до 100 символов"/>
					<form:errors path="fullName" cssClass="alert-error alert input-xlarge" element="div"></form:errors>
				</div>
			</div>

					
			<div class="control-group">
				<label class="control-label" for="invitation">Приглашение експерта</label>
				<div class="controls">
					<form:input class="input-xxlarge" type="text" path="invitation"
						placeholder="Идентификационный номер приглашения"/> <br>
						<form:errors path="invitation" cssClass="alert-error alert input-xxlarge" element="div"></form:errors>
				</div>
			</div>


			<div class="control-group">
				<div class="controls">
					<label class="checkbox"> <form:checkbox path="accept"/>
						Принимаю условия <a href="#">соглашения</a>
						
					</label>
					<form:errors path="accept" cssClass="alert-error alert input-xlarge" element="div"></form:errors> <br>
					<button type="submit" class="btn">Зарегистрировать</button>
				</div>
			</div>
		</fieldset>
	</form:form>





</div>
