package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
			//1.Spring 컨테이너를 구동한다.
			AbstractApplicationContext factory = new GenericXmlApplicationContext("polymorphism/applicationContext.xml");

			/*
			TV tv = (TV)factory.getBean("tv");
			tv.powerOn();
			tv.volumeDown();
			tv.volumeDown();
			tv.powerOff();

			factory.close();
	*/
	}

}
