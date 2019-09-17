package board.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.model.UserVO;
import board.util.DeleteRequest;
import board.util.ModifyRequest;
import board.util.RegisterRequest;

@Repository
public class UserDao implements AbstractDao{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public UserDao(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	protected Log log = LogFactory.getLog(AbstractDao.class);
	
	public void printQueryId(String queryId) {
        if(log.isDebugEnabled()){
            log.debug("\t QueryId  \t:  " + queryId);
        }
    }

	public UserVO selectByEmail(String email) {
        return (UserVO)selectOne("user.selectByEmail", email);
    }
 
    public UserVO selectById(String id) {
        return (UserVO)selectOne("user.selectById", id);
    }
    public UserVO selectByName(String name) {
        return (UserVO)selectOne("user.selectById", name);
    }
    public String selectByPw(String id) {
        return (String) selectOne("user.selectByPw", id);
    }
    
    public void updateUser(ModifyRequest modReq) {
    	update("user.modify", modReq);
    }
 
    public void insertUser(RegisterRequest regReq) {
        insert("user.register", regReq);
    }
    
    public void deleteUser(DeleteRequest delReq) {
    	delete("user.delete", delReq);
    }
      
    public Object insert(String queryId, Object params){
        printQueryId(queryId);
        return sqlSessionTemplate.insert(queryId, params);
    }
      
    public Object update(String queryId, Object params){
        printQueryId(queryId);
        return sqlSessionTemplate.update(queryId, params);
    }
      
    public Object delete(String queryId, Object params){
        printQueryId(queryId);
        return sqlSessionTemplate.delete(queryId, params);
    }
      
    public Object selectOne(String queryId){
        printQueryId(queryId);
        return sqlSessionTemplate.selectOne(queryId);
    }
      
    public Object selectOne(String queryId, Object params){
        printQueryId(queryId);
        return sqlSessionTemplate.selectOne(queryId, params);
    }
      
    @SuppressWarnings("rawtypes")
    public List selectList(String queryId){
        printQueryId(queryId);
        return sqlSessionTemplate.selectList(queryId);
    }
      
    @SuppressWarnings("rawtypes")
    public List selectList(String queryId, Object params){
        printQueryId(queryId);
        return sqlSessionTemplate.selectList(queryId,params);
    }
    
    public int countList(String name) {
    	return sqlSessionTemplate.selectOne("boardDao.getListCount", name);
    }
    public int countListUnder(String name) {
    	return sqlSessionTemplate.selectOne("boardDao.getListUnderCount", name);
    }
    public void updateVisit(String name) {
    	sqlSessionTemplate.update("user.visit", name);
    }
    public int selectVisit(String name) {
    	return sqlSessionTemplate.selectOne("user.selectByVisit", name);
    }
}
