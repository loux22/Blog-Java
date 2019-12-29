package firstMavenProject.dao;

public class DaoFactory {
	
	private MySQLManager manager ;
	private DAOUser daoUser;
	private DAOArticle daoArticle;
	
public DaoFactory() {
	manager = MySQLManager.getInstance();
	daoUser = new DAOUserImpl(manager.getConnection());
	daoArticle = new DAOArticleImpl(manager.getConnection());
}

public DAOUser getDaoUser() {
	return daoUser;
}

public DAOArticle getDaoArticle() {
	return daoArticle;
}

}
