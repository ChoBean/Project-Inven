package board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.model.MapInfoVO;

@Repository
public class MapInfoDaoImpl implements MapInfoDao{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public MapInfoDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<MapInfoVO> getList(int start) {
		return sqlSessionTemplate.selectList("mapInfo.mapListAll", start);
	}
	
	@Override
	public int getListCount() {
		return sqlSessionTemplate.selectOne("mapInfo.mapListAllCount");
	}

	@Override
	public MapInfoVO read(int mapnum) {
		MapInfoVO vo = (MapInfoVO)sqlSessionTemplate.selectOne("mapInfoContent",mapnum);
		return vo;
	}

	@Override
	public List<MapInfoVO> getListFilter(String maptheme) {
		return sqlSessionTemplate.selectList("mapInfo.mapInfoFilter", maptheme);
	}

}
