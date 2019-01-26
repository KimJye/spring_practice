package com.webtoonvote.controller;

import java.util.List;

import com.webtoonvote.dto.WebtoonDto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WebtoonAndBList {
	private List<WebtoonDto> webtoonList;
	private List<WebtoonDto> webtoonListEnd;
	private String mytoken;
}
