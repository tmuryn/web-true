<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<p>
<div class="row show-grid">
	<div class="col-lg-9">
	
		<ul class="nav nav-pills">
			<sec:authorize access="hasAnyRole('ADMIN','EXPERT')">
			<li class="<c:if test="${not empty articlesmy}">active</c:if>"><a href="#">Мои</a></li>
			</sec:authorize>
			<li class="<c:if test="${not empty articlesnew}">active</c:if>"><a href="#">Новые</a></li>
			<li class="<c:if test="${not empty articlespopular}">active</c:if>"><a href="#">Популярные</a></li>
			<li class="<c:if test="${not empty articlescomments}">active</c:if>"><a href="#">Комментируемые</a></li>
			<li class="<c:if test="${not empty articlesbest}">active</c:if>"><a href="#">Лучшие</a></li>
			<li class="<c:if test="${not empty articlesworst}">active</c:if>"><a href="#">Худшие</a></li>
			
			
		</ul>
	</div>
	
	<div class="col-3">
		<sec:authorize access="hasAnyRole('ADMIN','EXPERT')">
		<a type="button" class="btn btn-primary pull-right" href="<wt:action action="article/new" apiId="${api.id}" />">Добавить
			статью</a>
			</sec:authorize>
	</div>
</div>
<p/>
<div class="thumbnail">
	<img alt="300x200" 
		src="http://i.dailymail.co.uk/i/pix/2013/05/07/article-2320635-19A813BF000005DC-233_964x635.jpg">
	<div class="caption">
		<h3>Большой балуун</h3>
		<p>This is the amazing collection of the world's most wonderful
			hot air balloons - and it includes everything from Coca Cola bottles
			to space shuttles and polar bears. They are all produced by Cameron
			Balloons, in Bristol, who make between 150 and 200 every year as the
			world's leading hot air balloon company. Read more:
			http://www.dailymail.co.uk/news/article-2320635/Up-away-Wonderful-success-story-British-balloon-factory-build-ALL-SORTS.html#ixzz2UmJktDZk
			Follow us: @MailOnline on Twitter | DailyMail on Facebook</p>
		<p>
			<a class="btn btn btn-default" href="#">Читать дальше</a> <a class="btn btn-primary">Редактировать</a>
		</p>
	</div>
</div>
<br>
<div class="thumbnail">

	<div class="caption">
		<h3>Thumbnail label</h3>
		<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam.
			Donec id elit non mi porta gravida at eget metus. Nullam id dolor id
			nibh ultricies vehicula ut id elit.</p>
		<p>
			<a class="btn btn btn-default" href="#">Читать дальше</a> <a
				class="btn disabled btn-primary">Редактировать</a>
		</p>
	</div>
</div>
