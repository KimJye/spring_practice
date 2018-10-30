package edu.spring.ex04.domain;

public class Member {
	private String userid;
	private String password;
	private String email;
	
	public Member() {}

	public Member(String userid, String password, String email) {
		this.userid = userid;
		this.password = password;
		this.email = email;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}







