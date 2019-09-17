package board.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.model.CharacterVO;

@Repository
public class CharacterDaoMybatis implements CharacterDao{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public CharacterDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public List<CharacterVO> listAll(HashMap <String, Object> map){
		return sqlSessionTemplate.selectList("characterDao.listAll", map);
	}
	
	@Override
	public List<CharacterVO> selectByScenario(String scenario){
		return sqlSessionTemplate.selectList("characterDao.selectByScenario", scenario);
	}
	
	@Override
	public List<CharacterVO> selectByName(String keyWord){
		return sqlSessionTemplate.selectList("characterDao.selectByName", keyWord);
	}
	
	@Override
	public CharacterVO select(String name) {
		return sqlSessionTemplate.selectOne("characterDao.select", name);
	}
	
	
}
