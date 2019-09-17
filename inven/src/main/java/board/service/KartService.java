package board.service;

import java.util.HashMap;
import java.util.List;

import board.model.KartVO;

public interface KartService {
	
	public abstract int getAllCount();
	
	public abstract List<KartVO> getAll(int start);
	
	public abstract List<KartVO> getBySearch(HashMap <String, Object> map);
	
	public abstract List<KartVO> getByEngine(HashMap <String, Object> map);
	
	public abstract List<KartVO> getByType(HashMap <String, Object> map);
	
	public abstract List<KartVO> getByRate(HashMap <String, Object> map);
}
