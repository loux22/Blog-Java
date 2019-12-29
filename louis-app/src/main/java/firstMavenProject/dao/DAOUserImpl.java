package firstMavenProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import firstMavenProject.model.Article;
import firstMavenProject.model.User;

public class DAOUserImpl implements DAOUser {
	private Connection connection = null;

	public DAOUserImpl(Connection co) {
		this.connection = co;
	}

	public User getUser(int id) {
		User user = new User();
		try {
			String query = "SELECT * FROM auteur WHERE id_auteur=?;";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet resultat = ps.executeQuery();

			while (resultat.next()) {
				user.setPseudo(resultat.getString("pseudo"));
				user.setPassword(resultat.getString("password_auteur"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return user;

	}

	public List<User> getAllUsers() {
		List<User> ListUser = new ArrayList<User>();
		try {
			String query = "SELECT * FROM auteur;";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet resultat = ps.executeQuery();
			while (resultat.next()) {
				User user = new User();
				user.setId(resultat.getInt("id_auteur"));
				user.setPseudo(resultat.getString("pseudo"));
				user.setPassword(resultat.getString("password_auteur"));
				ListUser.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ListUser;
	}
	
	public List<Article> getArticleCreer(int id) {
		List<Article> ListUserArticle = new ArrayList<Article>();
		try {
			String query = "SELECT * FROM article JOIN auteur ON auteur.id_auteur = article.id_auteur WHERE article.id_auteur=?;";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet resultat = ps.executeQuery();
			while (resultat.next()) {
				Article article = new Article();
				User userArticle = new User();
				article.setId(resultat.getInt("id_article"));
				article.setTitre(resultat.getString("titre"));
				article.setDate_article(resultat.getDate("date_article"));
				article.setDescription(resultat.getString("description_article"));
				article.setTexte(resultat.getString("texte"));
				userArticle.setId(resultat.getInt("id_auteur"));
				userArticle.setPseudo(resultat.getString("pseudo"));
				userArticle.setPassword(resultat.getString("password_auteur"));
				article.setUser(userArticle);
				ListUserArticle.add(article);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ListUserArticle;
		
	}

	 public void addUser(User user) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO auteur (pseudo,password_auteur) VALUES(?,?);");
			preparedStatement.setString(1, user.getPseudo());
			preparedStatement.setString(2, user.getPassword());

			int statut = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}	
}
