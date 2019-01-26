package com.webtoonvote.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.webtoonvote.dto.CharacterDto;
import com.webtoonvote.dto.WebtoonDto;
import com.webtoonvote.mapper.CharacterMapper;
import com.webtoonvote.service.CharacterService;
import com.webtoonvote.service.WebtoonService;


@RestController
@RequestMapping("/api")
public class APIController {

	@Autowired
	private CharacterMapper characterMapper;
	@Autowired
	private CharacterService characterService;
	@Autowired
	private WebtoonService webtoonService;

	//webtoon 테이블 findAll
		@RequestMapping("/getWebtoon")
		public WebtoonAndBList getWebtoon(){
			System.out.println("getWebtoonController");
			return WebtoonAndBList.builder()
					.webtoonList(webtoonService.findAll())
					.webtoonListEnd(webtoonService.findEnd())
					.mytoken(webtoonService.createToken())
					.build();
		}
	@RequestMapping("/vote/{webtoon}")
	public List<CharacterDto> main(ModelMap model, @PathVariable("webtoon") String webtoon, HttpServletRequest request) throws Exception{
		List<CharacterDto> list = characterMapper.selectAll(webtoon);
		return list;
	}

	@RequestMapping("/total/{webtoon}")
	public String getTotal(@PathVariable("webtoon") String webtoon) throws Exception {
		String total = characterMapper.selectTotal(webtoon);
		return total;
	}

	@RequestMapping(value="/webtoonList", method=RequestMethod.GET)
	   public List<WebtoonDto> getWebtoonList(Model model){
		System.out.println("webtoonList-Get!!");
	      List<WebtoonDto> list = webtoonService.getWebtoonList();
	      return list;
	   }

	   @RequestMapping(value="/webtoonList", method=RequestMethod.POST)
	   public String getWebtoonList(Model model, @RequestParam("webtoonId") String webtoonId, @RequestParam("characterName") String characterName){
			System.out.println("webtoonList-Post!!");

		   CharacterDto ch = new CharacterDto();
	      ch.setWebtoon_vote_no(Integer.parseInt(webtoonId));
	      System.out.println(Integer.parseInt(webtoonId));
	      ch.setCharacter_name(characterName);
	      ch.setCount(0);
	      characterService.insertWebtoonCharac(ch);
	      return "/webtoonList";
	   }

	   @RequestMapping(value="/vote/{webtoonId}", method=RequestMethod.GET)
	   public List<CharacterDto> getVoteCharacter(Model model, @PathVariable("webtoonId")String webtoon_vote_no){
	      return characterService.findByWebtoon(Integer.parseInt(webtoon_vote_no));
	   }

	   @ResponseStatus(value=HttpStatus.OK)
	   @RequestMapping(value="/vote/post", method=RequestMethod.POST)
	   public void getVote(HttpServletResponse response, Model model, @RequestParam("characterId") String characterId,  @RequestParam("webtoonId") String webtoon_vote_no) throws IOException{
	      characterService.voteCharacter(Integer.parseInt(characterId),Integer.parseInt(webtoon_vote_no));
	       response.sendRedirect("redirect:/api/vote/"+webtoon_vote_no);
	   }
}
