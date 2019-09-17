package board.util;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class LoginCommand {
	
	@Length(min=2, max=20)
	@NotEmpty(message="아이디 쳐라")
	private String id;
	
	@Length(min=4, max=20)
	@NotEmpty(message="비밀번호를 입력해라")
	private String pw;
	private boolean rememberId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public boolean isRememberId() {
		return rememberId;
	}
	public void setRememberId(boolean rememberId) {
		this.rememberId = rememberId;
	}
	
	
}
