package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.model.Pagination;
import net.skhu.repository.ShippersRepository;

@Controller
@RequestMapping("shipper")
public class ShipperController {

	@Autowired ShippersRepository shipperRepository;

	@RequestMapping("list")
	public String list(Model model) {
		model.addAttribute("list",shipperRepository.findAll());
		return "shipper/list";
	}

	@RequestMapping("list2")
	public String list2(Model model, Pagination pagination) {
		model.addAttribute("list",shipperRepository.findAll(pagination));
		model.addAttribute("orderBy",shipperRepository.orderBy);
		model.addAttribute("searchBy",shipperRepository.searchBy);
		return "shipper/list2";
	}
}
