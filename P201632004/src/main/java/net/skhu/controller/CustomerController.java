package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.domain.Customers;
import net.skhu.model.Pagination;
import net.skhu.repository.CustomersRepository;

@Controller
@RequestMapping("customer")
public class CustomerController {
	@Autowired CustomersRepository customerRepository;

	@RequestMapping("list")
	public String list(Pagination pagination, Model model) {
		List<Customers> list = customerRepository.findAll(pagination);

		model.addAttribute("list",list);
		model.addAttribute("orderBy",customerRepository.orderBy);
		model.addAttribute("searchBy",customerRepository.searchBy);
		return "customer/list";
	}
}
