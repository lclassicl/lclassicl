package net.mds.forum.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserDAO userDAO;

	@Override
	public void userRegister(UserVO userVO) throws Exception {
		userDAO.userRegister(userVO);
	}

	@Override
	public UserVO getUser(UserVO userVO) throws Exception {
		return userDAO.getUser(userVO);
	}

	@Override
	public int userUpdate(UserVO userVO) throws Exception {
		int result = 0;
		result = userDAO.matchUserId(userVO.getUser_id());
		if(result==1){
			userDAO.userUpdate(userVO);
			return 1;
		}else{
			return 0;
		}
	}

	@Override
	public String checkid(String user_id) throws Exception {
		int result = 0;
		result = userDAO.checkid(user_id);
		if(result == 1){
			return "fail";
		}else{
			return "success";
		}
	}

	@Override
	public String checknick(String user_nick) throws Exception {
		int result = 0;
		result = userDAO.checknick(user_nick);
		if(result == 1){
			return "fail";
		}else{
			return "success";
		}
	}

	@Override
	public String checkoldpw(UserVO userVO) throws Exception {
		int result = 0;
		result = userDAO.checkoldpw(userVO);
		if(result == 1){
			return "success";
		}else{
			return "fail";
		}
	}
}
