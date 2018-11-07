package net.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.practice.dto.Department;
import net.practice.dto.Student;
import net.practice.dto.User;
import net.practice.mapper.DepartmentMapper;
import net.practice.mapper.StudentMapper;
import net.practice.mapper.UserMapper;

@Controller
@RequestMapping("mybatis")
public class MybatisController {

	@Autowired DepartmentMapper departmentMapper;
	@Autowired StudentMapper studentMapper;
	@Autowired UserMapper userMapper;

	@RequestMapping(value="cacheTest",method=RequestMethod.GET)
	public String cacheTest(Model model) {
		List<Department> departments = departmentMapper.findAll();
		model.addAttribute("departments",departments);
		model.addAttribute("department",departments.get(0));
		model.addAttribute("students",studentMapper.findAll().subList(0,5));
		return "mybatis/cacheTest";
	}

	@RequestMapping(value="cacheTest",method=RequestMethod.POST)
	public String cacheTest(Model model,Department department) {
		departmentMapper.update(department);
		return "redirect:cacheTest";
	}

	@RequestMapping("departmentList1")
	public String departmentList1(Model model) {
		List<Department> departments = departmentMapper.findAll();
		for(Department department : departments) {
			List<Student> students = studentMapper.findStudentByDepartmentId(department.getId());
			department.setStudents(students);
		}
		model.addAttribute("departments",departments);
		return "mybatis/departmentList1";
	}

	@RequestMapping("departmentList2")
	public String departmentList2(Model model) {
		model.addAttribute("departments",departmentMapper.findAllWithStudents());
		return "mybatis/departmentList2";
	}

	@RequestMapping("dynamicSQL")
	public String dynamicSQL(Model model) {
		List<User> list1 = userMapper.findAllOrderBy(5, "name DESC");
		model.addAttribute("list1", list1);

		User user1 = new User();
		user1.setName("이승진");
		List<User> list2 = userMapper.findByNameOrUserid(user1);
		model.addAttribute("list2", list2);

		User user3 = new User();
		user3.setId(2);
		user3.setName("Lee, Seungjin");
		userMapper.update(user3);

		User user2 = new User();
		user2.setUserid("lsj");
		List<User> list3 = userMapper.findByNameOrUserid2(user2);
		model.addAttribute("list3", list3);

		user3.setName("이승진");
		userMapper.update(user3);

		int[] a = new int[] { 2, 3, 5 };
		List<User> list4 = userMapper.findByIdList(a);
		model.addAttribute("list4", list4);
		return "mybatis/dynamicSQL";

	}

}
