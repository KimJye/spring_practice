package net.skhu.model;

import lombok.Data;

@Data
public class Message {
	String name;
	String message;

	public Message(String name, String message) {
		super();
		this.name = name;
		this.message = message;
	}

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

}
