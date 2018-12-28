package net.skhu.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import net.skhu.model.Message;

@Controller
public class HomeController {

	@MessageMapping("/chat")
	@SendTo("/topic/")
	public Message message() {

	}
}
