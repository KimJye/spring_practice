package com.webtoonvote.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webtoonvote.dto.WebtoonDto;
import com.webtoonvote.mapper.WebtoonMapper;

@Repository
public class WebtoonDaoImpl implements WebtoonDao {

	@Autowired WebtoonMapper webtoonMapper;

	@Override
	public List<WebtoonDto> findAll(){
		return webtoonMapper.findAll();
	}

	@Override
	public List<WebtoonDto> findEnd(){
		return webtoonMapper.findEnd();
	}

	@Override
	public List<WebtoonDto> getWebtoonList(){
		return webtoonMapper.getWebtoonList();
	}
}
