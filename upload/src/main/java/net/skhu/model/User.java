package net.skhu.model;

import lombok.Data;

@Data
public class User {
	String userId;
	String password;
	String userName;
	String email;
	String phone;
	String departmentName;
	String gender;
	String grade;

	public User() {

	}

	public User(String userId, String password, String userName, String email, String phone, String departmentName,
			String gender, String grade) {
		super();
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.departmentName = departmentName;
		this.gender = gender;
		this.grade = grade;
	}


}
