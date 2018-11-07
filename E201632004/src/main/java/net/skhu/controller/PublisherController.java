package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.skhu.dto.Publisher;
import net.skhu.mapper.PublisherMapper;

@Controller
@RequestMapping("publisher")
public class PublisherController {

	@Autowired PublisherMapper publisherMapper;

	@RequestMapping(value="list",method=RequestMethod.GET)
	public String list(Model model) {
		List<Publisher> publishers = publisherMapper.findAll();
		model.addAttribute("publishers",publishers);
		return "publisher/list";
	}
}
