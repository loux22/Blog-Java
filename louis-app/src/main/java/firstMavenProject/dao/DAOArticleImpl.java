package firstMavenProject.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import firstMavenProject.model.Article;
import firstMavenProject.model.User;

public class DAOArticleImpl implements DAOArticle {
	private Connection connection = null;

	public DAOArticleImpl(Connection co) {
		this.connection = co;
	}
	public Article getArticle(int id) {
		Article article = new Article();
		User user = new User();
		
		
		try {
			String query = "SELECT * FROM article JOIN auteur ON auteur.id_auteur = article.id_auteur WHERE id_article=?;";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet resultat = ps.executeQuery();

			while (resultat.next()) {
				article.setId(resultat.getInt("id_article"));
				article.setTitre(resultat.getString("titre"));
				article.setDate_article(resultat.getDate("date_article"));
				article.setDescription(resultat.getString("description_article"));
				article.setTexte(resultat.getString("texte"));
				user.setId(resultat.getInt("id_auteur"));
				user.setPseudo(resultat.getString("pseudo"));
				user.setPassword(resultat.getString("password_auteur"));
				article.setUser(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return article;
	}
	
	public List<Article> getAllArticle() {
		List<Article> ListArticle = new ArrayList<Article>();
		try {
			String query = "SELECT * FROM article JOIN auteur ON auteur.id_auteur = article.id_auteur;";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet resultat = ps.executeQuery();
			while (resultat.next()) {
				Article article = new Article();
				User user = new User();
				article.setId(resultat.getInt("id_article"));
				article.setTitre(resultat.getString("titre"));
				article.setDate_article(resultat.getDate("date_article"));
				article.setDescription(resultat.getString("description_article"));
				article.setTexte(resultat.getString("texte"));
				user.setPseudo(resultat.getString("pseudo"));
				user.setId(resultat.getInt("id_auteur"));
				article.setUser(user);
				ListArticle.add(article);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ListArticle;
	}
	
	public List<Article> getTwoLastArticle() {
		List<Article> ListArticle = new ArrayList<Article>();
		try {
			String query = "SELECT * FROM article ORDER BY date_article desc LIMIT 2;";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet resultat = ps.executeQuery();
			while (resultat.next()) {
				Article article = new Article();
				article.setId(resultat.getInt("id_article"));
				article.setTitre(resultat.getString("titre"));
				article.setDate_article(resultat.getDate("date_article"));
				article.setDescription(resultat.getString("description_article"));
				article.setTexte(resultat.getString("texte"));
				ListArticle.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ListArticle; 		
	}
	
	public void addArticle(Article article) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO article (titre,description_article,texte,date_article,id_auteur) VALUES(?,?,?,?,?);");
			preparedStatement.setString(1, article.getTitre());
			preparedStatement.setString(2, article.getDescription());
			preparedStatement.setString(3, article.getTexte());
			preparedStatement.setDate(4, (Date) article.getDate_article());
			preparedStatement.setInt(5, article.getUser().getId());
			
			int statut = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteArticle(Article article) {
		try {
			String query = "DELETE FROM article WHERE id_article=?;";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, article.getId());
			boolean resultat = ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateArticle(Article article) {
		try {
			String query = "UPDATE article SET titre=?, description_article=?, texte=?, date_article=? WHERE id_article=?;";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, article.getTitre());
			ps.setString(2, article.getDescription());
			ps.setString(3, article.getTexte());
			ps.setDate(4, (Date) article.getDate_article());
			ps.setInt(5, article.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Article> getAllMyArticle(int id) {
		List<Article> ListArticle = new ArrayList<Article>();
		try {
			String query = "SELECT * FROM article JOIN auteur ON auteur.id_auteur = article.id_auteur WHERE article.id_auteur=?;";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet resultat = ps.executeQuery();
			while (resultat.next()) {
				Article article = new Article();
				User user = new User();
				article.setId(resultat.getInt("id_article"));
				article.setTitre(resultat.getString("titre"));
				article.setDate_article(resultat.getDate("date_article"));
				article.setDescription(resultat.getString("description_article"));
				article.setTexte(resultat.getString("texte"));
				user.setPseudo(resultat.getString("pseudo"));
				user.setId(resultat.getInt("id_auteur"));
				article.setUser(user);
				ListArticle.add(article);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ListArticle;
	}

	
	

}
