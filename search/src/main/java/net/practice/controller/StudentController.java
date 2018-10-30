package net.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.practice.dto.Department;
import net.practice.dto.Student;
import net.practice.mapper.DepartmentMapper;
import net.practice.mapper.StudentMapper;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired StudentMapper studentMapper;
    @Autowired DepartmentMapper departmentMapper;

    @RequestMapping("list")
    public String list(Model model) {
        List<Student> students = studentMapper.findAll();
        model.addAttribute("students", students);
        return "student/list";
    }
    //findByName
    @RequestMapping("findByName")
    public String findByName(Model model, @RequestParam(value="srchText",defaultValue="") String srchText) {
    	System.out.println(srchText);

    	if(srchText=="") {
    		List<Student> students = studentMapper.findAll();
    		model.addAttribute("students",students);
    		return "student/list";
    	}

    	List<Student> students = studentMapper.findByName(srchText);
    	System.out.println(students.toString());
    	//model.addAttribute("findByName",students);
    	model.addAttribute("students",students);
    	model.addAttribute("srchText",srchText);
    	System.out.println("model에 더함");
    	return "student/list";
    }
    //학과 조회위한 리스트2
    @RequestMapping("list2")
    public String list2(Model model) {
    	List<Student> students = studentMapper.findAll();
        model.addAttribute("students", students);
        return "student/list2";
    }
    //findByDepartment
    @RequestMapping("findByDepartmentId")
    public String findByDepartment(Model model, @RequestParam(value="departmentId",defaultValue="0") int departmentId) {
    	System.out.println(departmentId);
    	if(departmentId==0) {
    		List<Student> students = studentMapper.findAll();
    		List<Department> departments = departmentMapper.findAll();
    		model.addAttribute("students",students);
    		model.addAttribute("departments",departments);
    		return "student/list2";
    	}
    	List<Student> students = studentMapper.findByDepartmentId(departmentId);
    	List<Department> departments = departmentMapper.findAll();

    	System.out.println(students.toString());
    	model.addAttribute("students",students);
    	model.addAttribute("departmentId",departmentId);
    	System.out.println("model에 더함");
    	return "student/list2";
    }
    //이름, 학과 조회위한 리스트3
    @RequestMapping("list3")
    public String list3(Model model) {
    	List<Student> students = studentMapper.findAll();
        model.addAttribute("students", students);
        return "student/list3";
    }
    //버튼 종류
    @RequestMapping("button")
    public String button(Model model, @RequestParam(value="button") String button, @RequestParam(value="srchText") String srchText, @RequestParam(value="departmentId") int departmentId) {
    	System.out.println(button);
    	if(button==null) {
    		System.out.println("조회버튼 아무것도 안누름");
    		List<Student> students = studentMapper.findAll();
    		model.addAttribute("students",students);
    		return "student/list3";
    	}
    	else if("이름버튼".equals(button)) {
    		System.out.println("이름조회버튼 누름");
    		if(srchText=="") {
        		List<Student> students = studentMapper.findAll();
        		model.addAttribute("students",students);
        		return "student/list3";
        	}
    		List<Student> students = studentMapper.findByName(srchText);
    		model.addAttribute("students",students);
        	model.addAttribute("srchText",srchText);
        	return "student/list3";
    	}
    	else if("학과버튼".equals(button)) {
    		System.out.println("학과조회버튼 누름");
    		if(departmentId==0) {
        		List<Student> students = studentMapper.findAll();
        		List<Department> departments = departmentMapper.findAll();
        		model.addAttribute("students",students);
        		model.addAttribute("departments",departments);
        		return "student/list3";
        	}
        	List<Student> students = studentMapper.findByDepartmentId(departmentId);
        	List<Department> departments = departmentMapper.findAll();
        	model.addAttribute("students",students);
        	model.addAttribute("departmentId",departmentId);
        	return "student/list3";
    	}
    	return "student/list3";
    }

    @RequestMapping(value="create", method=RequestMethod.GET)
    public String create(Model model) {
        Student student = new Student();
        List<Department> departments = departmentMapper.findAll();
        model.addAttribute("student", student);
        model.addAttribute("departments", departments);
        return "student/edit";
    }

    @RequestMapping(value="create", method=RequestMethod.POST)
    public String create(Model model, Student student) {
        studentMapper.insert(student);
        return "redirect:list";
    }

    @RequestMapping(value="edit", method=RequestMethod.GET)
    public String edit(Model model, @RequestParam("id") int id) {
        Student student = studentMapper.findOne(id);
        List<Department> departments = departmentMapper.findAll();
        model.addAttribute("student", student);
        model.addAttribute("departments", departments);
        return "student/edit";
    }

    @RequestMapping(value="edit", method=RequestMethod.POST)
    public String edit(Model model, Student student) {
        studentMapper.update(student);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(Model model, @RequestParam("id") int id) {
        studentMapper.delete(id);
        return "redirect:list";
    }
}
