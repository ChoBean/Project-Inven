package board.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.model.BoardVO;

@Repository
public class BoardDaoMybatis implements BoardDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public BoardDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public int count(String category) {
		return sqlSessionTemplate.selectOne("boardDao.count", category);
	}
	
	@Override
	public int countAll() {
		return sqlSessionTemplate.selectOne("boardDao.countAll");
	}

	@Override
	public List<BoardVO> list(HashMap<String, Object> map) {
		return sqlSessionTemplate.selectList("boardDao.list", map);
	}
	
	@Override
	public List<BoardVO> listAll(int start){
		return sqlSessionTemplate.selectList("boardDao.listAll", start);
	}
	
	@Override
	public List<BoardVO> listAllSearch(HashMap<String, Object> map){
		return sqlSessionTemplate.selectList("boardDao.listAllSearch", map);
	}
	
	@Override
	public List<BoardVO> listUnder(HashMap <String, Object> map){
		return sqlSessionTemplate.selectList("boardDao.listUnder", map);
	}

	@Override
	public BoardVO select(int num0) {
		 BoardVO vo = (BoardVO) sqlSessionTemplate.selectOne("boardDao.select", num0);
         return vo;
	}

	@Override
	public void insert(BoardVO boardVO) {
		sqlSessionTemplate.insert("boardDao.insert", boardVO);
	}
	
	@Override
	public void insertUnder(BoardVO boardVO) {
		sqlSessionTemplate.insert("boardDao.insertUnder", boardVO);
	}

	@Override
	public void update(BoardVO boardVO) {
		 sqlSessionTemplate.update("boardDao.update", boardVO);
	}

	@Override
	public void delete(int num1) {
		sqlSessionTemplate.delete("boardDao.delete", num1);
	}
	
	@Override
	public void updateUnder(BoardVO boardVO) {
		sqlSessionTemplate.update("boardDao.updateUnder", boardVO);
	}
	
	@Override
	public void deleteUnder(BoardVO boardVO) {
		sqlSessionTemplate.delete("boardDao.deleteUnder", boardVO);
	}

	@Override
	public int updateReadCount(int num0) {
		return sqlSessionTemplate.update("boardDao.updateReadCount", num0);
	}
	
	@Override
	public int getNewNum1(String category) {
		return sqlSessionTemplate.selectOne("boardDao.getNewNum1", category);
	}
	
	@Override
	public int getNewNum2(int num0) {
		return sqlSessionTemplate.selectOne("boardDao.getNewNum2", num0);
	}
	
	@Override
	public String download(int num0) {
		String filepath = sqlSessionTemplate.selectOne("boardDao.getFilePath", num0);
		String filename = sqlSessionTemplate.selectOne("boardDao.getFileName", num0);
		
		return filepath + "/" + filename;
	}
	
	@Override
	public List<BoardVO> getList(String writer){
		return sqlSessionTemplate.selectList("boardDao.getList", writer);
	}
	
	@Override
	public List<BoardVO> getListUnder(String writer){
		return sqlSessionTemplate.selectList("boardDao.getListUnder", writer);
	}
	
	@Override
	public int getListCount(String writer) {
		return sqlSessionTemplate.selectOne("getListCount", writer);
	}
	
	@Override
	public int getListUnderCount(String writer) {
		return sqlSessionTemplate.selectOne("getListUnderCount", writer);
	}
	
	@Override
	public void updateWriter(HashMap <String, Object> map) {
		sqlSessionTemplate.update("boardDao.updateWriter", map);
	}
	
	@Override
	public void deleteAdmin(int num1) {
		sqlSessionTemplate.delete("boardDao.deleteAdmin", num1);
	}
	
	@Override
	public void deleteUnderAdmin(BoardVO boardVO) {
		sqlSessionTemplate.delete("boardDao.deleteUnderAdmin", boardVO);
	}
	
	@Override
	public int readUnder(int num1) {
		return sqlSessionTemplate.selectOne("boardDao.readUnder", num1);
	}
	
	@Override
	public List<BoardVO> bestImageReadCount(){
		return sqlSessionTemplate.selectList("boardDao.bestImageReadCount");
	}
	@Override
	public List<BoardVO> bestVideoReadCount(){
		return sqlSessionTemplate.selectList("boardDao.bestVideoReadCount");
	}
	@Override
	public List<BoardVO> bestPlaytip(){
		return sqlSessionTemplate.selectList("boardDao.bestPlaytip");
	}
}
