package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.domain.Orders;
import net.skhu.model.Search;
import net.skhu.repository.OrdersRepository;

@Controller
@RequestMapping("order")
public class OrderController {

	@Autowired OrdersRepository orderRepository;

	@RequestMapping("list")
	public String list(Model model,Search search) {

		List<Orders> list = orderRepository.findAll(search.getSt(), search.getSb(),search.getOb());

		model.addAttribute("list",list);
		model.addAttribute("orderBy",orderRepository.orderBy);
		model.addAttribute("searchBy",orderRepository.searchBy);
		return "order/list";
	}

}
