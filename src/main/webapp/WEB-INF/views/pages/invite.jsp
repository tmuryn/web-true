<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<p>
<div class="panel panel-info">

	<div class="panel-heading"><h3 class="panel-title">Пригласить експерта</h3></div>
	
	<form:form method="post" action="invite"
		modelAttribute="inventationForm" class="form-horizontal">

		<fieldset>
	
			<div class="form-group">
				<label class="control-label col-lg-3" for="inputEmail">Електронный
					адрес</label>
				<div class="controls col-lg-9">
					<form:input class=" form-control" type="text" id="inputEmail"
						path="email" placeholder="Корректный електронный адрес" />
					<form:errors path="email" cssClass="alert-error alert input-xlarge"
						element="div"></form:errors>
				</div>
			</div>

			<div class="form-group">
				<div class="controls col-lg-3"></div>
				
				<div class="controls col-lg-9">
					<label class="checkbox"> <form:checkbox path="accept" />
						Принимаю условия <a href="#">соглашения</a>

					</label>
					<form:errors path="accept"
						cssClass="alert-error alert input-xlarge" element="div"></form:errors>
					<br>
					<button type="submit" class="btn btn-default">Пригласить</button>
				</div>
			</div>
		</fieldset>
	</form:form>





</div>


</p>
