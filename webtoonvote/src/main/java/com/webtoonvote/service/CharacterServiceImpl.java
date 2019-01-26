package com.webtoonvote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webtoonvote.dao.CharacterDao;
import com.webtoonvote.dto.CharacterDto;

@Service
public class CharacterServiceImpl implements CharacterService{

	@Autowired
	CharacterDao characterDao;
	
	@Override
	public void insertWebtoonCharac(CharacterDto ch) {
		characterDao.insertWebtoonCharac(ch);
	}
	
	@Override
	public List<CharacterDto> findByWebtoon(int webtoon_vote_no){
		return characterDao.findByWebtoon(webtoon_vote_no);
	}
	
	@Override
	public void voteCharacter(int character_no, int webtoon_vote_no) {
		characterDao.voteCharacter(character_no, webtoon_vote_no);
	}
	
}
