<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="thumbnail">

	<form:form method="post" action="invite"
		modelAttribute="inventationForm" class="form-horizontal">

		<fieldset>
			<legend>Пригласить експерта</legend>

			<div class="control-group">
				<label class="control-label" for="inputEmail">Електронный
					адрес</label>
				<div class="controls">
					<form:input class="input-xxlarge" type="text" id="inputEmail"
						path="email" placeholder="Корректный електронный адрес" />
					<form:errors path="email" cssClass="alert-error alert input-xlarge"
						element="div"></form:errors>
				</div>
			</div>

			<div class="control-group">
				<div class="controls">
					<label class="checkbox"> <form:checkbox path="accept" />
						Принимаю условия <a href="#">соглашения</a>

					</label>
					<form:errors path="accept"
						cssClass="alert-error alert input-xlarge" element="div"></form:errors>
					<br>
					<button type="submit" class="btn">Пригласить</button>
				</div>
			</div>
		</fieldset>
	</form:form>





</div>
