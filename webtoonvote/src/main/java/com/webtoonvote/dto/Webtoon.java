package com.webtoonvote.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Webtoon {
	int webtoon_vote_no;
	String webtoon_name;
	Date vote_start_date;
	Date vote_end_date;

	@Override
	public String toString() {
		return "webtoon_vote [webtoon_vote_no=" + webtoon_vote_no + ", webtoon_name=" + webtoon_name
				+ ", vote_start_date=" + vote_start_date + ", vote_end_date=" + vote_end_date + "]";
	}

	public int getWebtoon_vote_no() {
		return webtoon_vote_no;
	}

	public void setWebtoon_vote_no(int webtoon_vote_no) {
		this.webtoon_vote_no = webtoon_vote_no;
	}

	public String getWebtoon_name() {
		return webtoon_name;
	}

	public void setWebtoon_name(String webtoon_name) {
		this.webtoon_name = webtoon_name;
	}

	public Date getVote_start_date() {
		return vote_start_date;
	}

	public void setVote_start_date(Date vote_start_date) {
		this.vote_start_date = vote_start_date;
	}

	public Date getVote_end_date() {
		return vote_end_date;
	}

	public void setVote_end_date(Date vote_end_date) {
		this.vote_end_date = vote_end_date;
	}

	
}
