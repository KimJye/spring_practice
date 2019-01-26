package com.webtoonvote.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class WebtoonDto {
	int webtoon_no;
	String webtoon_name;
	Timestamp vote_start_date;
	Timestamp  vote_end_date;

	public WebtoonDto(int webtoon_no, String webtoon_name, Timestamp  vote_start_date, Timestamp vote_end_date) {
		super();
		this.webtoon_no = webtoon_no;
		this.webtoon_name = webtoon_name;
		this.vote_start_date = vote_start_date;
		this.vote_end_date = vote_end_date;
	}

	public String getStartDate() {
		Date start=new Date(vote_start_date.getTime());
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return date.format(start);
	}

	public WebtoonDto() {
		super();
		// TODO Auto-generated constructor stub
	}
}
