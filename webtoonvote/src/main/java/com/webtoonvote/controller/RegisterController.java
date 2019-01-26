package com.webtoonvote.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webtoonvote.dto.Webtoon;
import com.webtoonvote.mapper.CharacterMapper;
import com.webtoonvote.service.StorageService;
import com.webtoonvote.service.WebtoonService;
import com.webtoonvote.util.RandomStringGenerator;

@Controller
public class RegisterController {

	@Autowired
	private CharacterMapper characterMapper;
	@Autowired
	private final StorageService storageService;
	@Autowired
	private WebtoonService webtoonService;
	@Autowired
    public RegisterController(StorageService storageService) {
        this.storageService = storageService;
    }
	
	@RequestMapping(value="/register/character", method=RequestMethod.GET)
	 public List<Webtoon> getWebtoon(Model model){
		System.out.println("registerGet!!");
	      List<Webtoon> list = webtoonService.getWebtoonList();
	      return list;
	  }
	
	@RequestMapping(value="/register/character", method=RequestMethod.POST)
	public String registerPerson(@RequestParam("character_image") MultipartFile imageFile,
			HttpServletRequest request,
			RedirectAttributes redirectAttributes) throws Exception {
		String webtoonId = request.getParameter("webtoonId");
		String characterName = request.getParameter("character_name");
		System.out.println("웹툰id"+webtoonId+" "+characterName);

		String characterImageName = imageFile.getOriginalFilename();
		String randomString = RandomStringGenerator.getRandomString(10) + "_";
		String randomFileName = randomString+characterImageName;
		int count = 0;
		characterMapper.insert(webtoonId,characterName,count,randomFileName);
		
		storageService.store(imageFile,randomFileName);
        redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + imageFile.getOriginalFilename() + "!");
        System.out.println("redirect:/#/" + webtoonId + "/index.html");
		return "redirect:/";
	}
	
}
