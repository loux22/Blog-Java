package Mainblog;

import firstMavenProject.dao.DAOUser;
import firstMavenProject.dao.DaoFactory;

import firstMavenProject.model.User;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Connexion extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pseudo = (req.getParameter("pseudo"));
		String password = (req.getParameter("password"));

		DaoFactory factory = new DaoFactory();
		DAOUser daouser = factory.getDaoUser();
		List<User> listUser = daouser.getAllUsers();
		String message = null;
		for (User user : listUser) {
			if (password.trim().isEmpty() || pseudo.trim().isEmpty()) {
				message = "Vous n'avez pas rempli tous les champs !";
			} else {
				if (pseudo.equals(user.getPseudo())) {
					if (password.equals(user.getPassword())) {
						HttpSession session = req.getSession();
						session.setAttribute("id", user.getId());
					} else {
						message = "le mot de passe ne correspond pas au compte";
					}
				} else {
					message = "Ce compte n'existe pas";
				}
			}
		}
		req.setAttribute("message", message);

		this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(req, resp);
	}
}