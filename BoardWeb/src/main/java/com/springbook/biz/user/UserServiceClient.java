package com.springbook.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.user.*;

public class UserServiceClient {

	public static void main(String[] args) {
		//1.spring 컨테이너를 구동한다.
		AbstractApplicationContext container =
				new GenericXmlApplicationContext("com/springbook/biz/applicationContext.xml");

		//2.spring 컨테이너로부터 UserServiceImpl 객체를 Lookup 한다.
		UserService userService = (UserService) container.getBean("userService");

		//3. 로그인 기능
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test123");

		UserVO user = userService.getUser(vo);
		if(user!=null) {
			System.out.println(user.getName()+"님 환영합니다.");
		}else {
			System.out.println("로그인 실패");
		}
		container.close();
	}
}
