package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.Department;
import net.skhu.dto.Professor;
import net.skhu.mapper.DepartmentMapper;
import net.skhu.mapper.ProfessorMapper;

@Controller
@RequestMapping("/c201632004")
public class ProfessorController {
	@Autowired DepartmentMapper departmentMapper;
	@Autowired ProfessorMapper professorMapper;

	@RequestMapping("list1")
	public String list1(Model model) {
		List<Professor> professors = professorMapper.findAll();
		model.addAttribute("professors", professors);
		return "c201632004/list1";
	}
	@RequestMapping("list2")
	public String list2(Model model) {
		List<Professor> professors = professorMapper.findByDepartmentId(1);
		model.addAttribute("professors", professors);
		model.addAttribute("srchText",1);
		return "c201632004/list2";
	}
	@RequestMapping(value="edit", method=RequestMethod.GET)
	public String edit(Model model, @RequestParam("id") int id) {
		Professor professor = professorMapper.findOne(id);
		List<Department> departments = departmentMapper.findAll();
		model.addAttribute("professor", professor);
		model.addAttribute("departments", departments);
		return "c201632004/edit";
	}

	@RequestMapping(value="edit", method=RequestMethod.POST)
	public String edit(Model model, Professor professor) {
		professorMapper.update(professor);
		return "redirect:list1";
	}

	 //findByDepartment
    @RequestMapping("findByDepartmentId")
    public String findByDepartmentId(Model model, @RequestParam(value="srchText",defaultValue="1") int srchText) {


    	List<Professor> professors = professorMapper.findByDepartmentId(srchText);

    	model.addAttribute("professors",professors);
    	model.addAttribute("srchText",srchText);

    	return "c201632004/list2";
    }

}
