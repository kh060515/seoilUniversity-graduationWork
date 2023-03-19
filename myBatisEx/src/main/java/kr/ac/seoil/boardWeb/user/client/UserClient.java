package kr.ac.seoil.boardWeb.user.client;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.ac.seoil.boardWeb.user.service.UserService;
import kr.ac.seoil.boardWeb.user.vo.UserVO;

public class UserClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 1. Spring �����̳ʸ� �����Ѵ�.
		AbstractApplicationContext container =
			new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring �����̳ʷ� ���� BoardServiceImpl ��ü�� Lookup �Ѵ�.
		UserService userService = (UserService) container.getBean("userService");
		
		// 3. �α��� ����׽�Ʈ
		UserVO vo = new UserVO();
		vo.setUserId("admin");
		vo.setPassword("admin123");

		UserVO user = userService.getUser(vo);
		if (user != null) {
			System.out.println(user.getUserName() + "�� ȯ���մϴ�.");
		} else {
			System.out.println("�α��� ����");
		}
		
		container.close();
	}

}










