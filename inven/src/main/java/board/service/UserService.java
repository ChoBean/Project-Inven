package board.service;


import board.util.AuthInfo;
import board.util.DeleteRequest;
import board.util.LoginCommand;
import board.util.ModifyRequest;
import board.util.RegisterRequest;

public interface UserService {
	void register(RegisterRequest regReq) throws Exception;
	
	void update(ModifyRequest modReq, String id) throws Exception;
	
	AuthInfo loginAuth(LoginCommand loginCommand) throws Exception;

	void delete(DeleteRequest delReq, String id) throws Exception;
	
	void updateVisit(String name) throws Exception;
	
	int getVisit(String name) throws Exception;
}
