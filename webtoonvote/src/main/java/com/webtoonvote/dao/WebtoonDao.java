package com.webtoonvote.dao;

import java.util.List;

import com.webtoonvote.dto.WebtoonDto;

public interface WebtoonDao {
	List<WebtoonDto> findAll();
	List<WebtoonDto> findEnd();
	List<WebtoonDto> getWebtoonList();

}
