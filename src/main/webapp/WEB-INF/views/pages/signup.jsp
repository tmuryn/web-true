<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<p>
<div class="panel panel-info">
			<div class="panel-heading"><h3 class="panel-title">Регистрация</h3></div>
	
	<form:form method="post" action="registration"  modelAttribute="registrationForm" class="form-horizontal">  
	
		<fieldset>
			

			<div class="form-group">
			
			<label class="control-label col-lg-3" for="loginProviders">
			Регистрация используя:
			</label> 
			<div class="controls col-lg-9" id="loginProviders">
			<a
				href="https://loginza.ru/api/widget?token_url=http://localhost:8080/web-true-social/articles&provider=google"
				class="btn btn-default" alt="Google"><img
				src="http://loginza.ru/img/providers/google.png"></a> <a
				href="https://loginza.ru/api/widget?token_url=http://localhost:8080/web-true-social/articles&provider=facebook"
				class="btn btn-default" alt="Facebook"><img
				src="http://loginza.ru/img/providers/facebook.png"></a> <a
				href="https://loginza.ru/api/widget?token_url=http://localhost:8080/web-true-social/articles&provider=mailru"
				class="btn btn-default"><img
				src="http://loginza.ru/img/providers/mailru.png" alt="Mail.ru"></a>
			</div>
			</div>
			
			<br />
			
			
			<div class="form-group">
				<label class="control-label col-lg-3" for="inputEmail">Електронный адрес</label>
				<div class="col-lg-9">
					<form:input type="text" id="inputEmail" path="email" class="form-control"
						placeholder="Корректный електронный адрес"/>
						<form:errors path="email" cssClass="alert-error alert input-xlarge" element="div"></form:errors>
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-lg-3" for="inputEmail">Пароль</label>
				<div class="controls col-lg-9">
					<form:input  class="form-control" type="password" id="inputPassword" path="password"
						placeholder="от 6 до 12 символов"/>
						<form:errors path="password" cssClass="alert-error alert input-xlarge" element="div"></form:errors>
				</div>
			</div>
			

			<div class="form-group">
				<label class="control-label col-lg-3" for="inputName">Имя, Фамилия</label>
				<div class="controls col-lg-9">
					<form:input  path="fullName" class="form-control" id="inputName"
						placeholder="От 10 до 100 символов"/>
					<form:errors path="fullName" cssClass="alert-error alert input-xlarge" element="div"></form:errors>
				</div>
			</div>

					
			<div class="form-group">
				<label class="control-label col-lg-3" for="invitation">Приглашение експерта</label>
				<div class="controls col-lg-9">
					<form:input class="form-control" type="text" path="invitation"
						placeholder="Идентификационный номер приглашения"/> <br>
						<form:errors path="invitation" cssClass="alert-error alert input-xxlarge" element="div"></form:errors>
				</div>
			</div>


			<div class="form-group">
				<div class="col-lg-3"></div>
				<div class="controls col-lg-9">
					<label class="checkbox"> <form:checkbox path="accept"/>
						Принимаю условия <a href="#">соглашения</a>
						
					</label>
					<form:errors path="accept" cssClass="alert-error alert input-xlarge" element="div"></form:errors> <br>
					<button type="submit" class="btn btn-default">Зарегистрировать</button>
				</div>
			</div>
		</fieldset>
	</form:form>





</div>
</p>
