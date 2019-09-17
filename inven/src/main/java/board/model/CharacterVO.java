package board.model;

import org.apache.ibatis.type.Alias;

@Alias("CharacterVO")
public class CharacterVO {
	private String name;
	private String scenario;
	private int num;
	private String path;
	private String imageName;
	private String iconName;
	
	public CharacterVO(){}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getScenario() {
		return scenario;
	}


	public void setScenario(String scenario) {
		this.scenario = scenario;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public String getImageName() {
		return imageName;
	}


	public void setImageName(String imageName) {
		this.imageName = imageName;
	}


	public String getIconName() {
		return iconName;
	}


	public void setIconName(String iconName) {
		this.iconName = iconName;
	}


	


	
	
	
}
