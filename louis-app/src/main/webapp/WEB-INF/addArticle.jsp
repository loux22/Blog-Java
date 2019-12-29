<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter un article</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-dark bg-dark">
  <a class="navbar-brand" href="/louis-app/">Blog</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/louis-app/">Accueil<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/louis-app/listeArticle">Liste Articles</a>
      </li>
      <c:if test = "${ !empty sessionScope.id}">
      <li class="nav-item">
        <a class="nav-link" href="/louis-app/mesArticles">Mes articles</a>
      </li>
       </c:if>
      <li class="nav-item">
        <a class="nav-link" href="/louis-app/listeAuteur">Liste Auteurs</a>
      </li>
      <c:if test = "${ empty sessionScope.id}">
      <li class="nav-item">
        <a class="nav-link" href="/louis-app/inscription">Creer un compte</a>
      </li>
      </c:if>
      <c:if test = "${ empty sessionScope.id}">
      <li class="nav-item">
        <a class="nav-link" href="/louis-app/connexion">Se connecter</a>
      </li>
       </c:if>
        <c:if test = "${ !empty sessionScope.id}">
      <li class="nav-item">
        <a class="nav-link" href="/louis-app/deconnexion">Se deconnecter</a>
      </li>
       </c:if>
    </ul>
  </div>
</nav>
<c:if test = "${ empty sessionScope.id}"> 
<c:redirect url = "http://localhost:8080/louis-app/"/>
</c:if>
<h1>Ajouter un article</h1>

<form action="" method="POST">
<div class="form-group">
	<input name="id"  type="hidden" value="${ sessionScope.id }">
	<input name="titre" class="form-control" type="text" placeholder="Titre">
	</div>
	<div class="form-group">
	<textarea name="description" class="form-control" placeholder="Description"></textarea>
	</div>
	<div class="form-group">
	<textarea name="texte" class="form-control" placeholder="Texte"></textarea>
	</div>
		<button type="submit" class="btn btn-primary" name="addArticle">Ajouter</button>
	</form>
<% if(request.getAttribute("message") != null) {%>
    <div class="error"><%=request.getAttribute("message")%></div>
<%}%>	


<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</body>
</html>