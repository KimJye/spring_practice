package net.skhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.Data;

@Controller
public class Form1Controller {

	//첫 페이지
	@RequestMapping("/")
	public String index(Model model) {
		return "index";
	}

	//edit1
	@RequestMapping(value="/form1/edit1", method=RequestMethod.GET)
	public String edit1(Model model) {
		return "edit1";
	}

	@RequestMapping(value="/form1/edit1",method=RequestMethod.POST)
	public String edit1(Model model, @RequestParam("title") String title,@RequestParam("color") int color) {
		model.addAttribute("title",title);
		model.addAttribute("color",color);
		System.out.printf("제목: %s, 색:%d",title,color);
		return "edit1";
	}
	// edit2
	@RequestMapping(value="/form1/edit2", method=RequestMethod.GET)
	public String edit2(Model model) {
		model.addAttribute("data", new Data());
		return "edit2";
	}

	@RequestMapping(value="/form1/edit2", method=RequestMethod.POST)
	public String edit2(Model model, Data data) {
		System.out.printf("제목: %s. 색: %d\n", data.getTitle(), data.getColor());
		return "edit2";
	}
	// edit3
	@RequestMapping(value="/form1/edit3", method=RequestMethod.GET)
	public String edit3(Model model) {
		model.addAttribute("data", new Data());
		return "edit3";
	}

	@RequestMapping(value="/form1/edit3", method=RequestMethod.POST)
	public String edit3(Model model, Data data) {
		System.out.printf("제목: %s. 색: %d\n", data.getTitle(), data.getColor());
		return "edit3";
	}


}
