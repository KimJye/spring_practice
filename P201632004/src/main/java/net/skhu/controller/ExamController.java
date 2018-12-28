package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.domain.Customers;
import net.skhu.domain.Employees;
import net.skhu.domain.OrderDetails;
import net.skhu.model.Search;
import net.skhu.repository.CustomersRepository;
import net.skhu.repository.EmployeesRepository;
import net.skhu.repository.OrderDetailRepository;

@Controller
@RequestMapping("exam")
public class ExamController {

	@Autowired EmployeesRepository employeeRepository;
	@Autowired OrderDetailRepository orderDetailRepository;
	@Autowired CustomersRepository customersRepository;

	@RequestMapping("list1")
	public String list1(Model model) {

		List<Employees> list = employeeRepository.findAll();

		model.addAttribute("list",list);
		return "exam/list1";
	}

	@RequestMapping("list2")
	public String list2(Model model) {

		List<OrderDetails> list = orderDetailRepository.findAll();

		model.addAttribute("list",list);
		return "exam/list2";
	}

	@RequestMapping("list3")
	public String list3(Model model,Search search) {
		if(search.getSt()==null) {

			List<Employees> list = employeeRepository.findAll();
			model.addAttribute("list",list);
			return "exam/list3";
		}else if(search.getSt()!=null) {

			List<Employees> list = employeeRepository.findByCityStartsWith(search.getSt());

			model.addAttribute("list",list);
			return "exam/list3";
		}
		return "exam/list3";
	}

	@RequestMapping("list4")
	public String list4(Model model,Search search) {

		List<Employees> list = employeeRepository.findAll(search.getSb());
		model.addAttribute("searchBy",employeeRepository.searchBy);
		model.addAttribute("list",list);
		return "exam/list4";
	}

	@RequestMapping("list5")
	public String list5(Model model) {

		List<Customers> list = customersRepository.findAll();
		model.addAttribute("list",list);
		return "exam/list5";
	}





}
