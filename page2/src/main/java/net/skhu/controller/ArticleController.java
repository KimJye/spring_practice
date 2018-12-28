package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.domain.Article;
import net.skhu.domain.Board;
import net.skhu.model.Pagination;
import net.skhu.repository.ArticleRepository;
import net.skhu.repository.BoardRepository;

@Controller
@RequestMapping("article")
public class ArticleController {
	@Autowired ArticleRepository articleRepository;
	@Autowired BoardRepository boardRepository;

	@RequestMapping("list")
	public String list(Pagination pagination,Model model) {
		Board board = boardRepository.findById(pagination.getBd()).get();
		List<Article> list = articleRepository.findAll(pagination);
		model.addAttribute("board",board);
		model.addAttribute("list",list);
		model.addAttribute("orderBy",articleRepository.orderBy);
		model.addAttribute("searchBy",articleRepository.searchBy);
		return "article/list";
	}

	@RequestMapping("view")
	public String view(@RequestParam("id")int id,Pagination pagination, Model model) {
		Article article = articleRepository.findById(id).get();
		model.addAttribute("article",article);
		return "article/view";
	}
}
