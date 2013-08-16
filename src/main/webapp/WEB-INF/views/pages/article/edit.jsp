<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<%@ taglib prefix="wt" uri="/WEB-INF/tld/action.tld"%>


<p>
<div class="panel panel-info">

	
	<form:form method="post" action='save'
		modelAttribute="articleForm">

<div class="panel-heading"><h3 class="panel-title">Создать/Редактировать статью</h3></div>
	
		<fieldset>
	
			<div class="form-group">
				<label  for="inputEmail">Заголовок</label>
					<form:input class="form-control" type="text" id="inputEmail"
						path="title" placeholder="Заголовок статьи" />
					<form:errors path="title" cssClass="alert-error alert input-xlarge"
						element="div"></form:errors>
				
			</div>
			
			
			<div class="form-group">
				<label  for="inputText">Текст</label>
					<form:textarea class="form-control" type="area" id="inputText"
						path="text" placeholder="Текст статьи" />
					<form:errors path="text" cssClass="alert-error alert input-xlarge"
						element="div"></form:errors>
				
			</div>

			<div class="form-group">
				
				
				
					<label class="checkbox"> <form:checkbox path="accept" />
						Принимаю условия <a href="#">соглашения</a>

					</label>
					<form:errors path="accept"
						cssClass="alert-error alert input-xlarge" element="div"></form:errors>
					
					
					<label class="checkbox"> <form:checkbox path="publish" />
						Опубликовать (Показать другим) </a>
					<br>	<br>	
					<button type="submit" class="btn btn-default">Сохранить</button>
					
				
		</fieldset>
	</form:form>



<ckeditor:replace replace="inputText" basePath="../resources/ckeditor/" />


</div>


</p>