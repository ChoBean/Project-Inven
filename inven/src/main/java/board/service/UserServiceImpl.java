package board.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import board.dao.UserDao;
import board.model.UserVO;
import board.exception.AlreadyExistingEmailException;
import board.exception.AlreadyExistingIdException;
import board.exception.AlreadyExistingNameException;
import board.exception.IdPasswordNotMatchingException;
import board.exception.PasswordNotMatchingException;
import board.service.UserService;
import board.util.AuthInfo;
import board.util.DeleteRequest;
import board.util.LoginCommand;
import board.util.ModifyRequest;
import board.util.RegisterRequest;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource(name="userDao")
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public void register(RegisterRequest regReq) throws Exception {
		UserVO email = userDao.selectByEmail(regReq.getEmail());
		if(email != null) {
			throw new AlreadyExistingEmailException(regReq.getEmail() + "is duplicate email.");
		}
		UserVO id = userDao.selectById(regReq.getId());
		if(id != null) {
			throw new AlreadyExistingIdException(regReq.getId() + "is duplicate id.");
		}
		UserVO name = userDao.selectByName(regReq.getName());
		if(name != null) {
			throw new AlreadyExistingNameException(regReq.getName() + "is duplicate name.");
		}
		userDao.insertUser(regReq);
	}


	
	@Override
	public AuthInfo loginAuth(LoginCommand loginCommand) throws Exception {
		UserVO user = userDao.selectById(loginCommand.getId());
		if(user == null) {
			throw new IdPasswordNotMatchingException();
		}
		if(!user.matchPassword(loginCommand.getPw())) {
			throw new IdPasswordNotMatchingException();
		}
		return new AuthInfo(user.getID(), user.getNAME(), user.getGRADE(), user.getPASSWORD());
	}

	@Override
	public void update(ModifyRequest modReq, String id) throws Exception {
		UserVO email = userDao.selectByEmail(modReq.getEmail());
		if(email!=null) {
			throw new AlreadyExistingEmailException(modReq.getEmail()+"is duplicate email.");
		}
		String tmppw = userDao.selectByPw(id);
		String tmppw1 = modReq.getExistPw();
		if(!tmppw.equals(tmppw1)) {
			throw new PasswordNotMatchingException(modReq.getExistPw()+"is NotMatching Password");
		}
		userDao.updateUser(modReq);
	}

	@Override
	public void delete(DeleteRequest delReq, String id) throws Exception {
		String tmppw = userDao.selectByPw(id);
		String tmppw1 = delReq.getExistPw();
		if(!tmppw.equals(tmppw1)) {
			throw new PasswordNotMatchingException(delReq.getExistPw()+"is NotMatching Password");
		}
		userDao.deleteUser(delReq);
	}

	@Override
	public void updateVisit(String name) throws Exception {
		userDao.updateVisit(name);
	}

	@Override
	public int getVisit(String name) throws Exception {
		int visitCount = userDao.selectVisit(name);
		return visitCount;
	}

}
