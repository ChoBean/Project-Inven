package board.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.dao.CharacterDao;
import board.model.BoardVO;
import board.model.CharacterVO;




@Service
public class CharacterServiceImpl implements CharacterService{
	
	@Autowired
	private CharacterDao characterDao;
	
	public CharacterDao getCharacterDao() {
		return characterDao;
	}
	
	public void setCharacterDao(CharacterDao characterDao) {
		this.characterDao = characterDao;
	}
	
	@Override
	public List<CharacterVO> listAll(HashMap <String, Object> map){
		return characterDao.listAll(map);
	}
	
	@Override
	public List<CharacterVO> selectByScenario(String scenario){
		return characterDao.selectByScenario(scenario);
	}
	
	@Override
	public List<CharacterVO> selectByName(String keyWord){
		return characterDao.selectByName(keyWord);
	}
	
	@Override
	public CharacterVO read(String name) {
		return characterDao.select(name);
	}
	
	
}
