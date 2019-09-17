package board.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.model.KartVO;

@Repository
public class KartDaoMybatis implements KartDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public KartDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public int getAllCount() {
		return sqlSessionTemplate.selectOne("kartDao.getAllCount");
	}

	@Override
	public List<KartVO> getAll(int start) {
		return sqlSessionTemplate.selectList("kartDao.getAll", start);
	}

	@Override
	public List<KartVO> getBySearch(HashMap <String, Object> map) {
		return sqlSessionTemplate.selectList("kartDao.getBySearch", map);
	}

	@Override
	public List<KartVO> getByEngine(HashMap <String, Object> map) {
		return sqlSessionTemplate.selectList("kartDao.getByEngine", map);
	}

	@Override
	public List<KartVO> getByType(HashMap <String, Object> map) {
		return sqlSessionTemplate.selectList("kartDao.getByType", map);
	}

	@Override
	public List<KartVO> getByRate(HashMap <String, Object> map) {
		return sqlSessionTemplate.selectList("kartDao.getByRate", map);
	}

}
