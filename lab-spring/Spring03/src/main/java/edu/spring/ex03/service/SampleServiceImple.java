package edu.spring.ex03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex03.logger.Logger;
import edu.spring.ex03.logger.MyLogger;
import edu.spring.ex03.logger.NewLogger;

@Service
public class SampleServiceImple {
	
//	private MyLogger logger;
//	private NewLogger logger;
//	@Autowired private Logger logger;

	public void doService() {
//		logger = new MyLogger();
//		logger = new NewLogger();
//		logger.printLog("고객 관리 서비스를 시작");
//		logger.printNewLog("고객 관리 서비스를 시작");
		
		System.out.println(".....");
		System.out.println("..........");
		
//		logger.saveLog();
//		logger.saveNewLog();
	}
	
}








