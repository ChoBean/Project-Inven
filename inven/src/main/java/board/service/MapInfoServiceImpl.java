package board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.dao.MapInfoDao;
import board.model.MapInfoVO;

@Service
public class MapInfoServiceImpl implements MapInfoService {
	
	@Autowired
	private MapInfoDao mapInfoDao;
	
	public MapInfoDao getMapInfoDao() {
		return mapInfoDao;
	}

	public void setMapInfoDao(MapInfoDao mapInfoDao) {
		this.mapInfoDao = mapInfoDao;
	}

	@Override
	public List<MapInfoVO> listAll(int start) {
		return mapInfoDao.getList(start);
	}

	@Override
	public int listAllCount() {
		return mapInfoDao.getListCount();
	}

	@Override
	public MapInfoVO read(int mapnum) {
		return mapInfoDao.read(mapnum);
	}

	@Override
	public List<MapInfoVO> listFilter(String maptheme) {
		return mapInfoDao.getListFilter(maptheme);
	}
}
