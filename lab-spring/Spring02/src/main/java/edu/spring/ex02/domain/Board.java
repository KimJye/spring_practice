package edu.spring.ex02.domain;

import java.util.Date;

public class Board {
	private int bno;
	private String title;
	private String content;
	private String userid;
	private Date regdate;
	
	public Board() {}

	public Board(int bno, String title, String content, String userid, Date regdate) {
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.userid = userid;
		this.regdate = regdate;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "Board{"
				+ "bno: " + bno
				+ ", title: " + title
				+ ", content: " + content
				+ ", userid: " + userid
				+ ", regdate: " + regdate
				+ "}";
	}
	
}





