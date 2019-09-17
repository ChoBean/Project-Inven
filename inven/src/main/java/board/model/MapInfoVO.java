package board.model;

import org.apache.ibatis.type.Alias;

@Alias("MapInfoVO")
public class MapInfoVO {
	private int mapnum;
	private String mapname;
	private int maplevel;
	private int maplap;
	private String maptheme;
	private String mapvideo;
	private String filename;
	private String filepath;
	
	public MapInfoVO() {}
	
	
	public String getMaptheme() {
		return maptheme;
	}



	public void setMaptheme(String maptheme) {
		this.maptheme = maptheme;
	}



	public int getMapnum() {
		return mapnum;
	}

	public void setMapnum(int mapnum) {
		this.mapnum = mapnum;
	}

	public String getMapname() {
		return mapname;
	}

	public void setMapname(String mapname) {
		this.mapname = mapname;
	}

	public int getMaplevel() {
		return maplevel;
	}

	public void setMaplevel(int maplevel) {
		this.maplevel = maplevel;
	}

	public int getMaplap() {
		return maplap;
	}

	public void setMaplap(int maplap) {
		this.maplap = maplap;
	}

	public String getMapvideo() {
		return mapvideo;
	}

	public void setMapvideo(String mapvideo) {
		this.mapvideo = mapvideo;
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
	
	
}
