package Mainblog;

import firstMavenProject.dao.DAOUser;
import firstMavenProject.dao.DaoFactory;
import firstMavenProject.model.Article;
import firstMavenProject.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArticleAuteur extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DaoFactory factory = new DaoFactory();
		DAOUser daouser = factory.getDaoUser();
		String selectArticle = req.getParameter("auteur");

		int i = Integer.parseInt(selectArticle);
		User user = daouser.getUser(i);
		List<Article> userArticle = daouser.getArticleCreer(i);	
		
		req.setAttribute("user", user);
		req.setAttribute("userArticle", userArticle);

		
		this.getServletContext().getRequestDispatcher("/WEB-INF/articleAuteur.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*String test = req.getParameter("test");
		req.setAttribute("test", test);*/
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/articleAuteur.jsp").forward(req, resp);
	}
}