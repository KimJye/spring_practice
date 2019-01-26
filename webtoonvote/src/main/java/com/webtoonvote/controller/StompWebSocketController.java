package com.webtoonvote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.webtoonvote.dto.CharacterDto;
import com.webtoonvote.mapper.CharacterMapper;

@Controller
public class StompWebSocketController {
	
	private final SimpMessagingTemplate template;
	private final Gson gson = new Gson();

	@Autowired
	private CharacterMapper mapper;
	
	@Autowired
	public StompWebSocketController(SimpMessagingTemplate template) {
		this.template = template;
	}
	
	//subscribe
	@MessageMapping("/{webtoon}/characters")
	public void getCharacters(@DestinationVariable String webtoon) throws Exception {
		List<CharacterDto> list = mapper.selectAll(webtoon);
		template.convertAndSend("/subscribe/" + webtoon +  "/characters", gson.toJson(list));
	}
	
}
