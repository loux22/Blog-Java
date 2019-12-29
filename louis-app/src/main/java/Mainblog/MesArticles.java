package Mainblog;

import firstMavenProject.dao.DAOArticle;
import firstMavenProject.dao.DAOUser;
import firstMavenProject.dao.DaoFactory;
import firstMavenProject.model.Article;
import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MesArticles extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		DaoFactory factory = new DaoFactory();
		DAOArticle daoarticle = factory.getDaoArticle();
		HttpSession session = req.getSession();
		int id =  (Integer) session.getAttribute("id");
		List<Article> listArticle = daoarticle.getAllMyArticle(id);
		
		req.setAttribute("listArticle", listArticle);

		this.getServletContext().getRequestDispatcher("/WEB-INF/mesArticles.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  String id = req.getParameter("id");
		  int i = Integer.parseInt(id);
		  DaoFactory factory = new DaoFactory();
		  DAOArticle daoarticle = factory.getDaoArticle();
		  Article article = new Article();
		  article.setId(i);
		  daoarticle.deleteArticle(article);
		  
		 

		this.getServletContext().getRequestDispatcher("/WEB-INF/mesArticles.jsp").forward(req, resp);
	}
}