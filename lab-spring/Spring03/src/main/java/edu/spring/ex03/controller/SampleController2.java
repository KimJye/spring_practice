package edu.spring.ex03.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.ex03.domain.SampleVo;

// 콘트롤러가 JSP를 거치지 않고, 객체 타입을 직접 클라이언트에게 전송하는 방법:
// 1) @ResponseBody 어노테이션을 메소드 (또는 리턴 타입) 앞에서 사용
//   -> Spring 3 버전부터 있는 기능
// 2) @RestController 어노테이션을 클래스를 선언할 때 사용
//   -> Spring 4 버전부터 제공하는 기능

@RestController
public class SampleController2 {

	@RequestMapping(value = "/rest1", method = RequestMethod.GET)
	public SampleVo testRest1() {
		return new SampleVo("홍길동", 20);
	}
	
	@RequestMapping(value = "/rest2", method = RequestMethod.GET)
	public Map<String, SampleVo> testRest2() {
		Map<String, SampleVo> map = new HashMap<>();
		map.put("data1", new SampleVo("다현", 20));
		map.put("data2", new SampleVo("지효", 21));
		
		return map;
	}
	
}



















