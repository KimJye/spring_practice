package net.skhu.summernote.controller;

import java.util.Date;
import java.util.List;

import net.skhu.summernote.domain.User;
import net.skhu.summernote.model.ArticleModel;
import net.skhu.summernote.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    ArticleService articleService;
    @Autowired
    BoardRepository boardRepository;

    @RequestMapping("list")
    public String list(Pagination pagination, Model model) {
        model.addAttribute("board", boardRepository.findById(pagination.getBd()).get());
        model.addAttribute("list", articleService.findAll(pagination));
        model.addAttribute("orderBy", articleService.getOrderByOptions());
        model.addAttribute("searchBy", articleService.getSearchByOptions());
        return "article/list";
    }

    @RequestMapping("view")
    public String view(@RequestParam("id") int id, Pagination pagination, Model model) {
        model.addAttribute("article", articleService.findOne(id));
        return "article/view";
    }

    @GetMapping("edit")
    public String edit(@RequestParam("id") int id, Pagination pagination, Model model) {
        model.addAttribute("board", boardRepository.findById(pagination.getBd()).get());
        model.addAttribute("articleModel", articleService.findOne(id));
        return "article/edit";
    }

    @Transactional
    @PostMapping("edit")
    public String edit(@Valid ArticleModel a, BindingResult bindingResult,
                       Pagination pagination, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("board", boardRepository.findById(pagination.getBd()).get());
            return "article/edit";
        }
        articleService.update(a);
        return "redirect:view?id=" + a.getId() + "&" + pagination.getQueryString();
    }

    @GetMapping("create")
    public String create(Pagination pagination, Model model) {
        model.addAttribute("board", boardRepository.findById(pagination.getBd()).get());
        model.addAttribute("articleModel", new ArticleModel());
        return "article/edit";
    }

    @Transactional
    @PostMapping("create")
    public String create(@Valid ArticleModel a, BindingResult bindingResult,
                         Pagination pagination, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("board", boardRepository.findById(pagination.getBd()).get());
            return "article/edit";
        }
        int id = articleService.insertArticle(a, pagination.getBd(), 1);
        return "redirect:view?id=" + id + "&" + pagination.getQueryString();
    }

    @RequestMapping(value="delete", method=RequestMethod.GET)
    public String delete(@RequestParam("id") int id, Pagination pagination, Model model) {
        articleService.delete(id);
        return "redirect:list?" + pagination.getQueryString();
    }

}
