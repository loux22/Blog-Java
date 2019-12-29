package Mainblog;

import firstMavenProject.dao.DAOArticle;
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

public class ArticleDesc extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		DaoFactory factory = new DaoFactory();
		DAOArticle daoarticle = factory.getDaoArticle();
		String selectArticle = req.getParameter("article");

		int i = Integer.parseInt(selectArticle);
		Article article = daoarticle.getArticle(i);

		req.setAttribute("article", article);

		this.getServletContext().getRequestDispatcher("/WEB-INF/article.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * String test = req.getParameter("test"); req.setAttribute("test", test);
		 */

		this.getServletContext().getRequestDispatcher("/WEB-INF/article.jsp").forward(req, resp);
	}
}