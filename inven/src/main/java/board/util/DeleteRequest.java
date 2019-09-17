package board.util;


public class DeleteRequest {
	
	private String id;
	private String existPw;
	
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
		
}
