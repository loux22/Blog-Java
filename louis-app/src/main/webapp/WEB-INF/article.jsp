<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ArticleDesc</title>
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
<h1>${article.getTitre()}</h1>
<h2>Descritpion : ${article.getDescription()}</h2>
<h2>Texte : ${article.getTexte()}</h2>
<h2>Date de cr�ation : ${article.getDate_article()}</h2>
<h2>Auteur : ${article.getUser().getPseudo()}</h2>


<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</body>
</html>