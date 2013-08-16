<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="wt" uri="/WEB-INF/tld/action.tld"%>
<%
  final String path = request.getContextPath();
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta content="text/html; charset=utf-8" http-equiv="content-type">
<title>Колаборатор</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="<%=path%>/resources/bootstrap/css/bootstrap.css"
	rel="stylesheet" />
<style type="text/css">
body {
	padding-top: 20px;
	padding-bottom: 10px;
}
</style>
</head>

<body>


	<div class="container">

		<div class="jumbotron">
			<h1>Колаборатор</h1>
			<p>Ресурс который помогает найти достоверную информацию</p>
			<p>
				<a class="btn btn-primary btn-large"
					href='<wt:action action="articles" apiId="${api.id}" />'>
					Больше... </a>
			</p>
		</div>



		<div class="row">

			<div class="col-lg-6">
				<div class="thumbnail">
					<img alt="300x200" data-src="holder.js/300x200"
						style="width: 400px; height: 250px;"
						src="resources/images/User_Experience3_650x370.jpg">
					<div class="caption">
						<h3>Пользователь</h3>
						<p>
							Пользователь может задать вопрос о любых вещах, явлениях,
							ситуациях. Может получить рекомендацию у експерта касательно
							своих проблем. <br> <br>
						</p>
						<p>
							<a class="btn btn-primary" href="ask-question.html">Задать
								вопрос</a>
						</p>
					</div>

				</div>
				</div>
				<div class="col-lg-6">
					<div class="thumbnail">
						<img alt="300x200" data-src="holder.js/400x250"
							style="width: 400px; height: 250px;"
							src="resources/images/finance_specialists.jpg">
						<div class="caption">
							<h3>Експерт</h3>
							<p>Експерт - человек ведущий научную деятельность или имеющий
								практику. Основная цель написание статей и получение рейтинга
								активности. Возможность отвечать на вопросы пользователей.</p>
							<p>
								<a class="btn btn-primary" href="signup">Регистрация</a> <a
									class="btn btn-info" href="#">Рейтинг активности</a>
							</p>
						</div>
					</div>
				</div>


			</div>

			<hr>

			<footer>
				<p>&copy; Company 2013</p>
			</footer>

		</div>
		<!-- /container -->


		<%-- <script src="<%=path%>/resources/bootstrap/js/bootstrap.js"></script> --%>
</body>
</html>
