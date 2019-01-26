package com.webtoonvote.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webtoonvote.dto.CharacterDto;
import com.webtoonvote.mapper.CharacterMapper;

@Service
public class CharacterDaoImpl implements CharacterDao{
	@Autowired
	CharacterMapper characterMapper;
	
	@Override
	public void insertWebtoonCharac(CharacterDto ch) {
		characterMapper.insertWebtoonCharac(ch);
	}
	
	@Override
	public List<CharacterDto> findByWebtoon(int webtoon_vote_no){
		return characterMapper.findByWebtoon(webtoon_vote_no);
	}
	
	@Override
	public void voteCharacter(int character_no, int webtoon_vote_no) {
		characterMapper.voteCharacter(character_no, webtoon_vote_no);
	}
}
