package board.dao;

import java.util.HashMap;
import java.util.List;

import board.model.BoardVO;

public interface BoardDao {
	public abstract int count(String category);
	
	public abstract int countAll();
	
	public abstract List<BoardVO> list(HashMap<String, Object> map);
	
	public abstract List<BoardVO> listAll(int start);
	
	public abstract List<BoardVO> listAllSearch(HashMap<String, Object> map);
	
	public abstract List<BoardVO> listUnder(HashMap <String, Object> map);
	
	public abstract BoardVO select(int num0);
	
	public abstract void insert(BoardVO boardVO);
	
	public abstract void insertUnder(BoardVO boardVO);
	
	public abstract void update(BoardVO boardVO);
	
	public abstract void delete(int num1);
	
	public abstract void updateUnder(BoardVO boardVO);
	
	public abstract void deleteUnder(BoardVO boardVO);
	
	public abstract int updateReadCount(int num0);
	
	public abstract int getNewNum1(String category);
	
	public abstract int getNewNum2(int num0);
	
	public abstract String download(int num0);
	
	public abstract List<BoardVO> getList(String writer);
	
	public abstract List<BoardVO> getListUnder(String writer);
	
	public abstract int getListCount(String writer);
	
	public abstract int getListUnderCount(String writer);
	
	public abstract void updateWriter(HashMap <String, Object> map);
	
	public abstract void deleteAdmin(int num1);
	
	public abstract void deleteUnderAdmin(BoardVO boardVO);
	
	public abstract int readUnder(int num1);
	
	public abstract List<BoardVO> bestImageReadCount();
	
	public abstract List<BoardVO> bestVideoReadCount(); 
	
	public abstract List<BoardVO> bestPlaytip();
}
