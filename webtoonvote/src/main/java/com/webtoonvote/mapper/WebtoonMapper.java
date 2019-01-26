package com.webtoonvote.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.webtoonvote.dto.WebtoonDto;

@Mapper
public interface WebtoonMapper {
	List<WebtoonDto> findAll();
	List<WebtoonDto> findEnd();
	List<WebtoonDto> getWebtoonList();
}
