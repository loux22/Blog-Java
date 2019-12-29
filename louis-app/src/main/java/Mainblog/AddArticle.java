package Mainblog;

import firstMavenProject.dao.DAOArticle;
import firstMavenProject.dao.DAOUser;
import firstMavenProject.dao.DaoFactory;
import firstMavenProject.model.Article;
import firstMavenProject.model.User;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddArticle extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/addArticle.jsp").forward(req, resp);
		}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id =  req.getParameter("id");
		int i = Integer.parseInt(id);
		String titre = req.getParameter("titre");
		String description = req.getParameter("description");
		String texte = req.getParameter("texte");
		
		java.util.Date d1 = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(d1.getTime());
		Article article = new Article();
		User user = new User();
		
		article.setTitre(titre);
		article.setDescription(description);
		article.setTexte(texte);
		article.setDate_article(sqlDate);
		user.setId(i);
		article.setUser(user);
		
		DaoFactory factory = new DaoFactory();
		DAOArticle daoarticle = factory.getDaoArticle();
		String message = null;
		if (titre.trim().isEmpty() || description.trim().isEmpty() || texte.trim().isEmpty()) {
			message = "Vous n'avez pas rempli tous les champs !";
		} else {
			daoarticle.addArticle(article);
		}
		
		req.setAttribute("message", message);
		
		//resp.sendRedirect("http://localhost:8080/louis-app/addArticle");
		this.getServletContext().getRequestDispatcher("/WEB-INF/addArticle.jsp").forward(req, resp);
		
	}
}