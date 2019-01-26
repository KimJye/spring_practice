package com.webtoonvote.dto;

import lombok.Data;

@Data
public class CharacterDto {
	int character_no;
	int webtoon_vote_no;
	String character_name;
	int count;
	String image;

	@Override
	public String toString() {
		return "character [character_no=" + character_no + ", webtoon_vote_no=" + webtoon_vote_no + ", character_name="
				+ character_name + ", count=" + count + ", image=" + image + "]";
	}

	public int getCharacter_no() {
		return character_no;
	}

	public void setCharacter_no(int character_no) {
		this.character_no = character_no;
	}

	public int getWebtoon_vote_no() {
		return webtoon_vote_no;
	}

	public void setWebtoon_vote_no(int webtoon_vote_no) {
		this.webtoon_vote_no = webtoon_vote_no;
	}

	public String getCharacter_name() {
		return character_name;
	}

	public void setCharacter_name(String character_name) {
		this.character_name = character_name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


}
