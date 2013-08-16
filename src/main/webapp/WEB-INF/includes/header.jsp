<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="wt" uri="/WEB-INF/tld/action.tld"%>
<%@ page session="false"%>
<%
  final String path = request.getContextPath();
%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta content="text/html; charset=utf-8" http-equiv="content-type">
<script src="//loginza.ru/js/widget.js" type="text/javascript"></script>
<title>Колаборатор</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="<%=path%>/resources/bootstrap/css/bootstrap.css"
	rel="stylesheet">
<link href="<%=path%>/resources/bootstrap/css/bootstrap-glyphicons.css"
	rel="stylesheet">


<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}
</style>

</head>

<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-responsive-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				</a> <a href="<wt:action action="home" />" class="navbar-brand">Колаборатор</a>
				<div class="nav-collapse collapse navbar-responsive-collapse">

					<form action="" class="navbar-form pull-left col-lg-5">
						<input type="text"
							placeholder="Введите искомое, идентификатор статьи или вопроса"
							class="form-control">
					</form>




					<ul class="nav navbar-nav pull-right">


						<li ><a href="#" class="glyphicon glyphicon-plus icon-white"> Добавить вопрос</a></li>

						<li class="dropdown"><a data-toggle="dropdown"
							class="dropdown-toggle" href="#"><i
								class="glyphicon glyphicon-user icon-white"></i> <sec:authorize
									var="loggedIn" access="isAuthenticated()" /> <c:choose>
									<c:when test="${loggedIn}">
										<%=request.getUserPrincipal().getName()%>
									</c:when>
									<c:otherwise>
       								Профиль
   									 </c:otherwise>
								</c:choose> <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<sec:authorize var="loggedIn" access="isAuthenticated()" />
								<c:choose>
									<c:when test="${loggedIn}">
										<li><a href="<wt:action action="logout" />">Выход</a></li>
										<li><a href="<wt:action action="invate" />">Редактировать
												профайл</a></li>
									</c:when>
									<c:otherwise>
										<li><a href="<wt:action action="signin" />">Войти</a></li>
										<li><a href="<wt:action action="signup" />">Регистрация</a></li>
									</c:otherwise>
								</c:choose>

								<sec:authorize access="hasAnyRole('ADMIN','EXPERT')">
									<li><a href="<wt:action action="newinvite" />">Пригласить
											експерта</a></li>
								</sec:authorize>

							</ul></li>

						<li class="dropdown"><a data-toggle="dropdown"
							class="dropdown-toggle" href="#"><i
								class="glyphicon glyphicon-info-sign icon-white"></i> Информация
								<b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="#">Рейтинг Активности</a></li>
								<li><a href="#">Общие вопросы по проекту</a></li>

								<li class="divider"></li>

								<li><a href="#">Контакты</a></li>

							</ul></li>
					</ul>
				</div>
				<!-- /.nav-collapse -->
			</div>
		</div>
		<!-- /navbar-inner -->
	</div>


	<div class="container">

		<div class="row show-grid">

			<div class="col-lg-9">

				<ul class="nav nav-pills">
					<li class="<c:if test="${not empty articles}">active</c:if>"><a href="<wt:action action="article/list" apiId="${api.id}" />">Статьи</a></li>
					<li><a href="#">Теги</a></li>
					<li><a href="questions-answers.html">Вопросы</a></li>
				</ul>