package com.webtoonvote.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.webtoonvote.dto.CharacterDto;

@Mapper
public interface CharacterMapper {
	public List<CharacterDto> selectAll(@Param("webtoon") String webtoon) throws Exception;

	public void insert(@Param("webtoonId")String webtoonId,
			@Param("person_name")String person_name,
			@Param("count")Integer count,
			@Param("person_image")String person_image) throws Exception;
	
	public String selectTotal(@Param("webtoon") String webtoon) throws Exception;

	void insertWebtoonCharac(CharacterDto ch);

	List<CharacterDto> findByWebtoon(int webtoon_vote_no);

	void voteCharacter(int character_no, int webtoon_vote_no);
}
