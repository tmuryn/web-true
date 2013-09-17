<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="wt" uri="/WEB-INF/tld/action.tld"%>


<p>
<div class="row show-grid">
	<div class="col-lg-9">

		<ul class="nav nav-pills">
			<sec:authorize access="hasAnyRole('ADMIN','EXPERT')">
				<li class="<c:if test="${artyiclesType=='Author'}">active</c:if>"><a
					href="<wt:action action="articlestype" type="author"/>">Мои</a></li>
			</sec:authorize>
			<li class="<c:if test="${artyiclesType=='New'}">active</c:if>"><a
				href="<wt:action action="articlestype" type="new"/>">Новые</a></li>
			<li class="<c:if test="${artyiclesType=='Popular'}">active</c:if>"><a
				href="<wt:action action="articlestype" type="popular"/>">Популярные</a></li>
			<li class="<c:if test="${artyiclesType=='Commented'}">active</c:if>"><a
				href="<wt:action action="articlestype" type="commented"/>">Комментируемые</a></li>
			<li class="<c:if test="${artyiclesType=='Best'}">active</c:if>"><a
				href="<wt:action action="articlestype" type="best"/>">Лучшие</a></li>
			<li class="<c:if test="${artyiclesType=='Worse'}">active</c:if>"><a
				href="<wt:action action="articlestype" type="worse"/>">Худшие</a></li>


		</ul>
	</div>

	<div class="col-3">
		<sec:authorize access="hasAnyRole('ADMIN','EXPERT')">
			<a type="button" class="btn btn-primary pull-right"
				href="<wt:action action="article/new" apiId="${api.id}" />">Добавить
				статью</a>
		</sec:authorize>
	</div>
</div>
<p />


<c:forEach var="article" items="${articles}">	
		<div class="thumbnail">
		<div class="caption">
			<h3>${article.title}</h3>
			<p>${article.text}</p>
			<p>
				<a class="btn btn btn-default" href="#">Читать дальше</a> <a
					class="btn btn-primary">Редактировать</a>
			</p>
		</div>
	</div>
	<br>
</c:forEach>