package board.dao;

import java.util.HashMap;
import java.util.List;

import board.model.CharacterVO;

public interface CharacterDao {
	public abstract List<CharacterVO> listAll(HashMap <String, Object> map);
	
	public abstract List<CharacterVO> selectByScenario(String scenario);
	
	public abstract List<CharacterVO> selectByName(String keyWord);
	
	public abstract CharacterVO select(String name);

}
