package firstMavenProject.dao;

import java.util.List;

import firstMavenProject.model.Article;
import firstMavenProject.model.User;

public interface DAOUser {
	public User getUser(int id);
	public List<User> getAllUsers();
	public void addUser(User user);
	public List<Article> getArticleCreer(int id);
}
