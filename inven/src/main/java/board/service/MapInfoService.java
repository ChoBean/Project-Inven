package board.service;

import java.util.List;

import board.model.MapInfoVO;

public interface MapInfoService {
	public abstract List<MapInfoVO> listAll(int start);
	
	public abstract int listAllCount();
	
	public abstract MapInfoVO read(int mapnum);
	
	public abstract List<MapInfoVO> listFilter(String maptheme);
}
