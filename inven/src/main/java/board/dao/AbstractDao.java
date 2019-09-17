package board.dao;

import java.util.List;

import board.model.UserVO;
import board.util.ModifyRequest;
import board.util.RegisterRequest;

public interface AbstractDao {
	
	public void printQueryId(String queryId);

	public UserVO selectByEmail(String email);
 
    public UserVO selectById(String id);
 
    public String selectByPw(String id);
    
    public void insertUser(RegisterRequest regReq);
      
    public Object insert(String queryId, Object params);
      
    public Object update(String queryId, Object params);
      
    public Object delete(String queryId, Object params);
      
    public Object selectOne(String queryId);
      
    public Object selectOne(String queryId, Object params);
    
    public void updateUser(ModifyRequest modReq); 
    
    public int countList(String name);
    
    public UserVO selectByName(String name);
    
    public void updateVisit(String name);
    
    public int selectVisit(String name);
    
    @SuppressWarnings("rawtypes")
    public List selectList(String queryId);
      
    @SuppressWarnings("rawtypes")
    public List selectList(String queryId, Object params);
	
}
