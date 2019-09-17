package board.dao;

import java.util.List;

import board.model.MapInfoVO;

public interface MapInfoDao {
	
	public abstract List<MapInfoVO> getList(int start);
	
	public abstract int getListCount();
	
	public abstract MapInfoVO read(int mapnum);
	
	public abstract List<MapInfoVO> getListFilter(String maptheme);
}
