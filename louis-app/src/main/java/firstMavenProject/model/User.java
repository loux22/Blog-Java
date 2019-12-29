package firstMavenProject.model;

public class User {
	private int id;
	private String pseudo;
	private String password;
	

	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getId());
		sb.append(" - ");
		sb.append(getPseudo());
		sb.append(" - ");
		sb.append(getPassword());
		return sb.toString();
	}
	
}
