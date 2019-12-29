package Mainblog;

import firstMavenProject.dao.DAOArticle;
import firstMavenProject.dao.DaoFactory;
import firstMavenProject.model.Article;
import firstMavenProject.model.User;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateArticle extends HttpServlet {
	private String selectArticle;
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			DaoFactory factory = new DaoFactory();
			DAOArticle daoarticle = factory.getDaoArticle();
			setSelectArticle(req.getParameter("article"));

			int i = Integer.parseInt(getSelectArticle());
			Article article = daoarticle.getArticle(i);

			req.setAttribute("article", article);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/updateArticle.jsp").forward(req, resp);
		}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String titre = req.getParameter("titre");
		String description = req.getParameter("description");
		String texte = req.getParameter("texte");
		
		setSelectArticle(req.getParameter("article"));

		int id = Integer.parseInt(getSelectArticle());
		
		java.util.Date d1 = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(d1.getTime());
		Article article = new Article();
		
		article.setId(id);
		article.setTitre(titre);
		article.setDescription(description);
		article.setTexte(texte);
		article.setDate_article(sqlDate);
		
		DaoFactory factory = new DaoFactory();
		DAOArticle daoarticle = factory.getDaoArticle();
		String message = null;
		if (titre.trim().isEmpty() || description.trim().isEmpty() || texte.trim().isEmpty()) {
			message = "Vous n'avez pas rempli tous les champs !";
		} else {
			daoarticle.updateArticle(article);
		}
		
		req.setAttribute("message", message);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/updateArticle.jsp").forward(req, resp);
	}
	public String getSelectArticle() {
		return selectArticle;
	}
	public void setSelectArticle(String selectArticle) {
		this.selectArticle = selectArticle;
	}
}