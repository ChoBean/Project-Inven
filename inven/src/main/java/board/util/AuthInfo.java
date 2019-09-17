package board.util;

public class AuthInfo {
	private String id;
	private String name;
	private int grade;
	private String password;
	
	public AuthInfo(String id, String name, int grade, String password) {
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.password = password; 
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

}
