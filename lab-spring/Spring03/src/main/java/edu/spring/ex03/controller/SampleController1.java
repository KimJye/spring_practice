package edu.spring.ex03.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.spring.ex03.domain.SampleVo;

@Controller
public class SampleController1 {

	@RequestMapping(value = "/test",
			method = RequestMethod.GET)
	public void test() {
		
	}
	
	@RequestMapping(value = "/test1",
			method = RequestMethod.GET)
	@ResponseBody
	public String test1() {
		return "Hello, Spring!";
	}
	
	@RequestMapping(value = "/test2",
			method = RequestMethod.GET)
	public @ResponseBody SampleVo test2() {
		return new SampleVo("오쌤", 16);
	}
	
	@RequestMapping(value = "/test3",
			method = RequestMethod.GET)
	@ResponseBody
	public List<SampleVo> test3() {
		List<SampleVo> list = new ArrayList<>();
		list.add(new SampleVo("Abc", 16));
		list.add(new SampleVo("홍길동", 18));
		
		return list;
	}
	
} // end class SampleController1








