package kr.ac.seoil.boardWeb.common;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import kr.ac.seoil.boardWeb.user.service.UserService;
import kr.ac.seoil.boardWeb.user.vo.UserVO;

@Controller
public class BaseController {
	@Resource(name="userService")
	UserService userService;
	
	public UserVO getUser(HttpServletRequest request) throws Exception{
		UserVO user=(UserVO)request.getSession().getAttribute("user");
		return user;
	}
}
