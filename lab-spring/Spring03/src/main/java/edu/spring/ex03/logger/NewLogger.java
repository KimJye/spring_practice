package edu.spring.ex03.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewLogger 
	implements edu.spring.ex03.logger.Logger {
	
	private static final Logger logger =
			LoggerFactory.getLogger(NewLogger.class);
	
	@Override
	public void printLog(String msg) {
		logger.info("NewLogger: " + msg);
	}
	
	@Override
	public void saveLog() {
		logger.info("로그 저장 성공!!!");
	}

}





