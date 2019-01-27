package net.skhu.summernote.controller;

import java.util.Date;
import java.util.List;

import net.skhu.summernote.domain.User;
import net.skhu.summernote.model.ArticleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.summernote.domain.Article;
import net.skhu.summernote.domain.Board;
import net.skhu.summernote.model.Pagination;
import net.skhu.summernote.repository.ArticleRepository;
import net.skhu.summernote.repository.BoardRepository;

import javax.swing.table.AbstractTableModel;
import javax.transaction.Transactional;
import javax.validation.Valid;

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

	@GetMapping("edit")
	public String edit(@RequestParam("id") int id, Pagination pagination, Model model){
		Board board = boardRepository.findById(pagination.getBd()).get();
		Article article = articleRepository.findById(id).get();
		model.addAttribute("board",board);
		model.addAttribute("articleModel",article);
		return "article/edit";
	}

	@Transactional
	@PostMapping("edit")
	public String edit(@Valid ArticleModel a, BindingResult bindingResult,
					   Pagination pagination, Model model){
		if(bindingResult.hasErrors()){
			Board board = boardRepository.findById(pagination.getBd()).get();
			model.addAttribute("board",board);
			return "article/edit";
		}
		articleRepository.update(a.getId(),a.getTitle(),a.getBody());
		return "redirect:view?id="+ a.getId() + "&" + pagination.getQueryString();
	}

	@GetMapping("create")
	public  String create(Pagination pagination, Model model){
		Board board = boardRepository.findById(pagination.getBd()).get();
		model.addAttribute("board",board);
		model.addAttribute("articleModel", new ArticleModel());
		return "article/edit";
	}

	@Transactional
	@PostMapping("create")
	public  String create(@Valid ArticleModel a, BindingResult bindingResult,
						  Pagination pagination, Model model){
		if(bindingResult.hasErrors()){
			Board board = boardRepository.findById(pagination.getBd()).get();
			model.addAttribute("board",board);
			return "article/edit";
		}
		int id = insertArticle(a, pagination.getBd(), 1);
		return "redirect:view?id=" + id + "&" + pagination.getQueryString();
	}

	private int insertArticle(ArticleModel a, int boardId, int userId){
		Article last = articleRepository.findTopByBoardIdOrderByNoDesc(boardId);
		int no = (last==null) ? 1 : last.getNo() + 1;

		Article article = new Article();
		article.setBoard(new Board());
		article.getBoard().setId(boardId);
		article.setUser(new User());
		article.getUser().setId(userId);
		article.setWriteTime(new Date());
		article.setNo(no);
		article.setTitle(a.getTitle());
		article.setBody(a.getBody());
		articleRepository.save(article);
		return article.getId();
	}
}
