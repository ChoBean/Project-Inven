package board.service;

import java.util.HashMap;
import java.util.List;

import board.model.BoardVO;
import board.model.CharacterVO;



public interface CharacterService {
	
	public abstract List<CharacterVO>selectByScenario(String scenario);
	
	public abstract List<CharacterVO>selectByName(String keyWord);
	
	public abstract List<CharacterVO> listAll(HashMap <String, Object> map);
	
	public abstract CharacterVO read(String name);
	

}
