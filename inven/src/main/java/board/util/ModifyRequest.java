package board.util;


public class ModifyRequest {
	
	private String id;
	private String email;
	private String name;
	private String pw;
	private String checkPw;
	private String existPw;
	private String spd;
	
	//비밀번호 확인
	public boolean equalToCheckPw() {
		return pw.equals(checkPw);
	}

	public String getSpd() {
		return spd;
	}

	public void setSpd(String spd) {
		this.spd = spd;
	}



	public String getExistPw() {
		return existPw;
	}


	public void setExistPw(String existPw) {
		this.existPw = existPw;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getCheckPw() {
		return checkPw;
	}
	public void setCheckPw(String checkPw) {
		this.checkPw = checkPw;
	}
	
	
}
