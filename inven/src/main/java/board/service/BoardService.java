package board.service;

import java.util.HashMap;
import java.util.List;

import board.model.BoardVO;

public interface BoardService {
	public abstract int count(String category);
	
	public abstract int countAll();
	
	public abstract List<BoardVO> list(HashMap<String, Object> map);
	
	public abstract List<BoardVO> listAll(int start);
	
	public abstract List<BoardVO> listAllSearch(HashMap<String, Object> map);
	
	public abstract List<BoardVO> listUnder(HashMap<String, Object> map);
	
	public abstract BoardVO read(int num0);
	
	public abstract void write(BoardVO boardVO);
	
	public abstract void writeUnder(BoardVO boardVO);
	
	public abstract void edit(BoardVO boardVO);

	public abstract void delete(int num1);
	
	public abstract void editUnder(BoardVO boardVO);
	
	public abstract void deleteUnder(BoardVO boardVO);
	
	public abstract String download(int num0);
	
	public abstract List<BoardVO> getList(String writer);
	
	public abstract List<BoardVO> getListUnder(String writer);
	
	public abstract int getListCount(String writer);
	
	public abstract int getListUnderCount(String writer);
	
	public abstract void editWriter(HashMap <String, Object> map);
	
	public abstract void deleteAdmin(int num1);
	
	public abstract void deleteUnderAdmin(BoardVO boardVO);
	
	public abstract int readUnder(int num1);
	
	public abstract List<BoardVO> bestImageReadCount();
	
	public abstract List<BoardVO> bestVideoReadCount();
	
	public abstract List<BoardVO> bestPlaytip();
	
}
