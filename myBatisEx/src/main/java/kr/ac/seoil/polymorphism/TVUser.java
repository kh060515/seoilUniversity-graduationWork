package kr.ac.seoil.polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext factory 
			= new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring 컨테이너로부터 필요한 객체를 요청(Lookup)한다.
		TV tv = (TV) factory.getBean("lgTV");
		tv.powerOn();
		tv.soundUp();
		tv.soundDown();
		tv.powerOff();
		
//		TV tv2 = (TV) factory.getBean("tv");
//		TV tv3 = (TV) factory.getBean("tv");

//		System.out.println(tv.toString());
//		System.out.println(tv2.toString());
//		System.out.println(tv3.toString());

		
//		TV tv1 = (TV) factory.getBean("tv1");
//		tv1.powerOn();
//		tv1.soundUp();
//		tv1.soundDown();
//		tv1.powerOff();

		// 3. Spring 컨테이너 종료
		factory.close();
		
		//		SamsungTV tv = new SamsungTV();
//		tv.powerOn();
//		tv.soundUp();
//		tv.soundDown();
//		tv.powerOff();
		
//		LgTV tv = new LgTV();
//		tv.powerOn();
//		tv.soundUp();
//		tv.soundDown();
//		tv.powerOff();
	}

}
