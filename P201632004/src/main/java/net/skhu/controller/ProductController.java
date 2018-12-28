package net.skhu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.domain.Products;
import net.skhu.model.Pagination;
import net.skhu.model.ProductEditModel;
import net.skhu.model.ProductService;
import net.skhu.repository.ProductsRepository;

@Controller
@RequestMapping("product")
public class ProductController {

	@Autowired ProductsRepository productRepository;
	@Autowired ProductService productService;

	@RequestMapping("list")
	public String list(Pagination pagination,Model model) {

		List<Products> list = productRepository.findAll(pagination);

		model.addAttribute("list",list);
		model.addAttribute("orderBy",productRepository.orderBy);
		model.addAttribute("searchBy",productRepository.searchBy);
		return "product/list";
	}

	@RequestMapping("edit")
	public String edit(@RequestParam("id")int id,ProductEditModel product,Pagination pagination,Model model) {
		System.out.println("edit get");
		Products products = productRepository.findById(id).get();
		model.addAttribute("product",products);
		return "product/edit";
	}

	@RequestMapping(value="edit",method=RequestMethod.POST)
	public String edit(@RequestParam("id")int id,@Valid ProductEditModel product,Pagination pagination, BindingResult bindingResult,
Model model) {

		if(bindingResult.hasErrors()) {
			model.addAttribute("product",productRepository.findById(id).get());
			return "product/edit";
		}
		productService.save(product,id);
		return "redirect:/product/list";
	}

}
