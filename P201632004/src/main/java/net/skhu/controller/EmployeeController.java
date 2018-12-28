package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.domain.Employees;
import net.skhu.model.Pagination;
import net.skhu.repository.EmployeesRepository;

@Controller
@RequestMapping("employee")
public class EmployeeController {

	@Autowired EmployeesRepository employeeRepository;

	@RequestMapping("list")
	public String list(Pagination pagination,Model model) {

		//List<Employees> list = employeeRepository.findAll(pagination);

		//model.addAttribute("list",list);
		//model.addAttribute("orderBy",employeeRepository.orderBy);
		model.addAttribute("searchBy",employeeRepository.searchBy);
		return "employee/list";
	}

	@RequestMapping(value="create", method=RequestMethod.GET)
	public String create(Model model) {
		System.out.println("create get");
		Employees employee = new Employees();
		model.addAttribute("employee",employee);
		return "employee/view";
	}
	@RequestMapping(value="create", method=RequestMethod.POST)
	public String create(Model model,Employees employee) {
		System.out.println("create post");
		employeeRepository.save(employee);
		return "redirect:/employee/list";
	}
	@RequestMapping("view")
	public String view(@RequestParam("id")int id,Pagination pagination,Model model) {
		System.out.println("view get");
		Employees employee = employeeRepository.findById(id).get();
		model.addAttribute("employee",employee);
		return "employee/view";
	}
	@RequestMapping(value="view",method=RequestMethod.POST)
	public String view(Employees employee,Pagination pagination,Model model) {
		System.out.println("view post");
		model.addAttribute("employee",employeeRepository.save(employee));
		return "redirect:/employee/list";
	}
	@RequestMapping("delete")
	public String delete( @RequestParam("id") int id,Model model) {
		employeeRepository.deleteById(id);
		return "redirect:/employee/list";
	}


}
