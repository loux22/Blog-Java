package firstMavenProject.model;

import java.util.Date;

public class Article {
	private int id;
	private String titre;
	private String description;
	private String texte;
	private Date date_article;
	private User user;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public Date getDate_article() {
		return date_article;
	}
	public void setDate_article(Date date_article) {
		this.date_article = date_article;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getId());
		sb.append(" - ");
		sb.append(getTitre());
		sb.append(" - ");
		sb.append(getTexte());
		sb.append(" - ");
		sb.append(getDate_article());
		sb.append(" - ");

		return sb.toString();
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
