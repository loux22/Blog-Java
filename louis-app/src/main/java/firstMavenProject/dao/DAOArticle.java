package firstMavenProject.dao;

import java.util.List;

import firstMavenProject.model.Article;


public interface DAOArticle {
	public Article getArticle(int id);
	public List<Article> getAllArticle();
	public void addArticle(Article user);
	public void updateArticle(Article user);
	public void deleteArticle(Article user);
	public List<Article> getTwoLastArticle();
	public List<Article> getAllMyArticle(int id);
}
