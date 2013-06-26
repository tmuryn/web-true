<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}
</style>
<link href="../assets/css/bootstrap-responsive.css" rel="stylesheet">

</head>

<body>


	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a data-target=".navbar-responsive-collapse" data-toggle="collapse"
					class="btn btn-navbar"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a href="home" class="brand">Колаборатор</a>
				<div class="nav-collapse collapse navbar-responsive-collapse">

					<form action="" class="navbar-search pull-left">
						<input type="text"
							placeholder="Введите искомое, идентификатор статьи или вопроса"
							class="search-query span6">
					</form>

					<ul class="nav">

					</ul>

					<ul class="nav pull-right">


						<li class="dropdown"><a data-toggle="dropdown"
							class="dropdown-toggle" href="#"><i
								class="icon-user icon-white"></i> Профиль <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="signin">Войти</a></li>
								<li><a href="signup">Регистрация</a></li>

							</ul></li>

						<li class="dropdown"><a data-toggle="dropdown"
							class="dropdown-toggle" href="#"><i
								class="icon-info-sign icon-white"></i> Информация <b
								class="caret"></b></a>
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

		<div class="row-fluid">
			<div class="span10">

				<ul class="nav nav-tabs">
					<li class="active1"><a href="#">Статьи</a></li>
					<li><a href="#">Теги</a></li>
					<li><a href="questions-answers.html">Вопросы/Рекомендации</a></li>
					<li><a href="ask-question.html">Задать вопрос</a></li>
				</ul>