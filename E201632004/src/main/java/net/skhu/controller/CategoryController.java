package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.skhu.dto.Category;
import net.skhu.mapper.CategoryMapper;

@Controller
@RequestMapping("category")
public class CategoryController {

	@Autowired CategoryMapper categoryMapper;

	@RequestMapping(value="list",method=RequestMethod.GET)
	public String list(Model model) {
		List<Category> categorys = categoryMapper.findAll();
		model.addAttribute("categorys",categorys);
		return "category/list";
	}
}
