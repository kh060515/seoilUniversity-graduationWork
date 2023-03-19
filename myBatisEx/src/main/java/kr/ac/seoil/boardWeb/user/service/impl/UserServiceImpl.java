package kr.ac.seoil.boardWeb.user.service.impl;

import kr.ac.seoil.boardWeb.user.service.UserService;
import kr.ac.seoil.boardWeb.user.vo.UserVO;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public UserVO getUser(UserVO vo) throws Exception {
		return userDAO.selectUser(vo);
	}
}
