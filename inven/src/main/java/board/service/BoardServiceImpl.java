package board.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.dao.BoardDao;
import board.model.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	public BoardDao getBoardDao() {
		return boardDao;
	}
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public int count(String category) {
		return boardDao.count(category);
	}
	
	@Override
	public int countAll() {
		return boardDao.countAll();
	}
	
	@Override
	public List<BoardVO> list(HashMap<String, Object> map) {
		return boardDao.list(map);
	}
	
	@Override
	public List<BoardVO> listAll(int start){
		return boardDao.listAll(start);
	}
	
	@Override
	public List<BoardVO> listAllSearch(HashMap<String, Object> map){
		return boardDao.listAllSearch(map);
	}
	
	@Override
	public List<BoardVO> listUnder(HashMap <String, Object> map){
		return boardDao.listUnder(map);
	}

	@Override
	public BoardVO read(int num0) {
		boardDao.updateReadCount(num0);
		return boardDao.select(num0);
	}

	@Override
	public void write(BoardVO boardVO) {
		// 기본 글
		boardVO.setNum1(boardDao.getNewNum1(boardVO.getCategory())+1);
		boardVO.setNum2(0);
		boardDao.insert(boardVO);
	}
	
	@Override
	public void writeUnder(BoardVO boardVO) {
		// 댓글
		boardVO.setNum1(boardVO.getNum1());
		boardVO.setNum2(boardDao.getNewNum2(boardVO.getNum1())+1);
		boardDao.insertUnder(boardVO);
	}

	@Override
	public void edit(BoardVO boardVO) {
		boardDao.update(boardVO);
	}

	@Override
	public void delete(int num1) {
		boardDao.delete(num1);
	}
	
	@Override
	public void editUnder(BoardVO boardVO) {
		boardDao.updateUnder(boardVO);
	}
	
	@Override
	public void deleteUnder(BoardVO boardVO) {
		boardDao.deleteUnder(boardVO);
	}
	
	@Override
	public String download(int num0) {
		String url = boardDao.download(num0);
		return url;
	}
	
	@Override
	public List<BoardVO> getList(String writer){
		return boardDao.getList(writer);
	}
	
	@Override
	public List<BoardVO> getListUnder(String writer){
		return boardDao.getListUnder(writer);
	}
	
	@Override
	public int getListCount(String writer) {
		return boardDao.getListCount(writer);
	}
	
	@Override
	public int getListUnderCount(String writer) {
		return boardDao.getListUnderCount(writer);
	}
	
	@Override
	public void editWriter(HashMap <String, Object> map) {
		boardDao.updateWriter(map);
	}
	
	@Override
	public void deleteAdmin(int num1) {
		boardDao.deleteAdmin(num1);
	}
	
	@Override
	public void deleteUnderAdmin(BoardVO boardVO) {
		boardDao.deleteUnderAdmin(boardVO);
	}
	
	@Override
	public int readUnder(int num1) {
		return boardDao.readUnder(num1);
	}
	
	@Override
	public List<BoardVO> bestImageReadCount() {
		return boardDao.bestImageReadCount();
	}
	
	@Override
	public List<BoardVO> bestVideoReadCount() {
		return boardDao.bestVideoReadCount();
	}
	
	@Override
	public List<BoardVO> bestPlaytip(){
		return boardDao.bestPlaytip();
	}

}
