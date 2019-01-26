package com.webtoonvote.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webtoonvote.dao.WebtoonDao;
import com.webtoonvote.dto.WebtoonDto;
import com.webtoonvote.util.SecurityUtil;

@Service
public class WebtoonServiceImpl implements WebtoonService {

	@Autowired WebtoonDao webtoonDao;

	@Override
	public List<WebtoonDto> findAll(){
		return webtoonDao.findAll();
	}
	@Override
	public List<WebtoonDto> findEnd(){
		return webtoonDao.findEnd();
	}
	@Override
	public String createToken() {
		SecurityUtil su = new SecurityUtil();
		String date = new Date().toString();
		String mytoken = su.encryptBySHA256(date);
		System.out.println("token:"+mytoken);
		return mytoken;
	}
	@Override
	public List<WebtoonDto> getWebtoonList(){
		return webtoonDao.getWebtoonList();
	}
}
