package board.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import board.dao.KartDao;
import board.model.KartVO;

public class KartServiceImpl implements KartService {
	
	@Autowired
	private KartDao kartDao;
	
	public KartDao getKartDao() {
		return kartDao;
	}
	
	public void setKartDao(KartDao kartDao) {
		this.kartDao = kartDao;
	}
	
	@Override
	public int getAllCount() {
		return kartDao.getAllCount();
	}

	@Override
	public List<KartVO> getAll(int start) {
		return kartDao.getAll(start);
	}

	@Override
	public List<KartVO> getBySearch(HashMap <String, Object> map) {
		return kartDao.getBySearch(map);
	}

	@Override
	public List<KartVO> getByEngine(HashMap <String, Object> map) {
		return kartDao.getByEngine(map);
	}

	@Override
	public List<KartVO> getByType(HashMap <String, Object> map) {
		return kartDao.getByType(map);
	}

	@Override
	public List<KartVO> getByRate(HashMap <String, Object> map) {
		return kartDao.getByRate(map);
	}

}
