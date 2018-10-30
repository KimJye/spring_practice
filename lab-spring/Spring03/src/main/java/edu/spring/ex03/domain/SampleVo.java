package edu.spring.ex03.domain;

// VO(Value Object): MVC 패턴에서 Model 클래스
// DTO(Data Transfer Object): 메소드 간에 데이터 전송(매개변수, 리턴 타입)을 위한 클래스
public class SampleVo {
	private String name;
	private int age;
	
	public SampleVo() {}
	public SampleVo(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}







