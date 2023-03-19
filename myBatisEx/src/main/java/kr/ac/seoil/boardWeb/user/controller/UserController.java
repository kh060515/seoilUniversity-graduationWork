package kr.ac.seoil.boardWeb.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.seoil.boardWeb.user.service.UserService;
import kr.ac.seoil.boardWeb.user.service.impl.UserDAO;
import kr.ac.seoil.boardWeb.user.vo.UserVO;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/user/login.do")
	public String login() {
		return "user/login";
	}
	
	@RequestMapping("/user/loginProcess.do")
	public String loginProcess(HttpServletRequest request, UserVO vo) throws Exception {
		
		UserVO user = userService.getUser(vo);

		// 3. 화면 내비게이션
		if (user != null) {
			request.getSession().setAttribute("user", user);
			return "redirect:/board/getList.do";
		} else {
			return "redirect:login.do";
		}
	}
	
	@RequestMapping("/user/logout.do")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:login.do";
	}
}







