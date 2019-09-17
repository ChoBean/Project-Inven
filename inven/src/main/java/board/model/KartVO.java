package board.model;

import org.apache.ibatis.type.Alias;

@Alias("KartVO")
public class KartVO {
	private int kartnum;
	private String kartname;
	private String filename;
	private String filepath;
	private String engine;
	private String type;
	private String rate;
	
	KartVO() {}

	public int getKartnum() {
		return kartnum;
	}

	public void setKartnum(int kartnum) {
		this.kartnum = kartnum;
	}

	public String getKartname() {
		return kartname;
	}

	public void setKartname(String kartname) {
		this.kartname = kartname;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}
	
}
