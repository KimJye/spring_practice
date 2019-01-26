package com.webtoonvote.dto;

import lombok.Data;

@Data
public class VoteDto {
	String user;
	int character_no;
	int webtoon_no;

	public VoteDto(String user, int character_no, int webtoon_no) {
		this.user = user;
		this.character_no = character_no;
		this.webtoon_no = webtoon_no;
	}
}
