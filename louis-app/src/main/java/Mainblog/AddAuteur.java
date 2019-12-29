package Mainblog;

import firstMavenProject.dao.DAOArticle;
import firstMavenProject.dao.DAOUser;
import firstMavenProject.dao.DaoFactory;
import firstMavenProject.model.Article;
import firstMavenProject.model.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddAuteur extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(req, resp);
		}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pseudo = req.getParameter("pseudo");
		String password = req.getParameter("password");
		String Password_verif = req.getParameter("password_verif");
		
			User user = new User();
			
			user.setPseudo(pseudo);
			user.setPassword(password);

			DaoFactory factory = new DaoFactory();
			DAOUser daouser = factory.getDaoUser();
			String message = null;
			String alert = null;
			if (password.trim().isEmpty() || Password_verif.trim().isEmpty() || pseudo.trim().isEmpty()) {
				message = "Vous n'avez pas rempli tous les champs !";
			} else  { 
				if(password.equals(Password_verif)) {
					daouser.addUser(user);
				} else {
					alert = "Votre password n'est pas confirmer";
				}
				
			}
			
				
			
			
			req.setAttribute("message", message);
			req.setAttribute("alert", alert);
			
		
		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(req, resp);
	}

}