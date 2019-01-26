package com.webtoonvote.service;

import java.util.List;

import com.webtoonvote.dto.WebtoonDto;

public interface WebtoonService {
	List<WebtoonDto> findAll();
	List<WebtoonDto> findEnd();
	String createToken();
	List<WebtoonDto> getWebtoonList();
}
