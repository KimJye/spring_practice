package com.webtoonvote.dao;

import java.util.List;

import com.webtoonvote.dto.CharacterDto;

public interface CharacterDao {
	void insertWebtoonCharac(CharacterDto ch);
	List<CharacterDto> findByWebtoon(int webtoon_vote_no);
	void voteCharacter(int character_no, int webtoon_vote_no);

}
