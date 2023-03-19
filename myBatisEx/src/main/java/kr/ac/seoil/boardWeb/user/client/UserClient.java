package kr.ac.seoil.boardWeb.user.client;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.ac.seoil.boardWeb.user.service.UserService;
import kr.ac.seoil.boardWeb.user.vo.UserVO;

public class UserClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext container =
			new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring 컨테이너로 부터 BoardServiceImpl 객체를 Lookup 한다.
		UserService userService = (UserService) container.getBean("userService");
		
		// 3. 로그인 기능테스트
		UserVO vo = new UserVO();
		vo.setUserId("admin");
		vo.setPassword("admin123");

		UserVO user = userService.getUser(vo);
		if (user != null) {
			System.out.println(user.getUserName() + "님 환영합니다.");
		} else {
			System.out.println("로그인 실패");
		}
		
		container.close();
	}

}










