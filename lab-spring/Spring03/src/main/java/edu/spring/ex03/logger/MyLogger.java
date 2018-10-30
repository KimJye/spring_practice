package edu.spring.ex03.logger;

public class MyLogger implements Logger {
	
	@Override
	public void printLog(String msg) {
		System.out.println("MyLogger: " + msg);
	}
	
	@Override
	public void saveLog() {
		System.out.println("로그를 파일에 저장했습니다.");
	}

}
