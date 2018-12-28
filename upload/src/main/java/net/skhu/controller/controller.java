package net.skhu.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.skhu.mapper.MySubjectMapper;
import net.skhu.mapper.UserMapper;
import net.skhu.model.MySubject;
import net.skhu.model.User;
import net.skhu.service.ExcelService;

@Controller
@RequestMapping("/")
public class controller {

	@Autowired MySubjectMapper mySubjectMapper;
	@Autowired ExcelService excelService;
	@Autowired UserMapper userMapper;

	//회원가입창 GET
	@RequestMapping(value="join", method=RequestMethod.GET)
	public String join(Model model){
		User user = new User();
		model.addAttribute("user", user);
		return "join";
	}

	//학생 회원가입 POST
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(Model model, User user){
		int result = userMapper.findOne(user.getUserId());//아이디가 존재하지않으면 0 존재하면 1
		String regex="([a-zA-Z].+[0-9])|([0-9].+[a-zA-Z])"; //영문+숫자
		String emailRegex = "^[_a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]+$";
		System.out.println("post들어옴");
		System.out.println(user.toString());
		if(result==0) {

			if(!user.getPassword().matches(regex) || user.getPassword().length()<8 || !user.getEmail().matches(emailRegex)) {
				//비밀번호 조건(영어+숫자 8자리 이상)과 이메일 조건에 맞지 않을 때

				model.addAttribute("user", user);

				return "join";
			}else {

				userMapper.insert(user); //user테이블 insert
				System.out.println("insert함");
				return "redirect:login";
			}
		}else { //아이디가 존재할 때 > 로그인창으로
			return "redirect:login";
		}
	}
	// 로그인 화면
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}

	// 로그인
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(Model model, User user, HttpSession session) {
		User result = userMapper.login(user.getUserId());
		String url;

		if(result == null) {	// 아이디가 존재하지 않는 경우
			user.setUserId("");
			user.setPassword("");
			url = "login";
		}
		else {

			if(result.getPassword().equals(user.getPassword())) {	// 비밀번호가 일치하는 경우 (암호화된 비밀번호를 비교)

				session.setAttribute("user", result);

				url = "redirect:mypage";

			}
			else if(!result.getPassword().equals(user.getPassword())){	// 비밀번호가 일치하지 않는 경우

				user.setPassword("");

				url = "login";
			}
			else {

				url = "login";
			}
		}
		return url;
	}
	//main get
	@RequestMapping(value="main", method=RequestMethod.GET)
	public String main(Model model,HttpSession session){
		User user = (User) session.getAttribute("user");//user라는 객체를 가져옴.세션값을 가져와야 현재 접속한 아이디값을 얻을 수 있다.
		model.addAttribute("user", user);
		return "main";
	}

	//Info get
	@RequestMapping(value="mypage", method=RequestMethod.GET)
	public String mypage(Model model,HttpSession session){
		User user = (User) session.getAttribute("user");//user라는 객체를 가져옴.세션값을 가져와야 현재 접속한 아이디값을 얻을 수 있다.
		model.addAttribute("user", user);
		return "mypage";
	}
	//Info post
	@RequestMapping(value="mypage", method=RequestMethod.POST)
	public String mypage(Model model,User user,HttpSession session){
		User userGetId = (User) session.getAttribute("user");
		user.setUserId(userGetId.getUserId());
		String regex="([a-zA-Z].+[0-9])|([0-9].+[a-zA-Z])"; //영문+숫자

		if(user.getPassword().length() > 0) {

			//비밀번호 조건에 맞지 않을 떄
			if(!user.getPassword().matches(regex) || user.getPassword().length()<8) {
				model.addAttribute("user",user);
				return "mypage";

			}

		} else {
			user.setPassword(userGetId.getPassword());
		}

		userMapper.update(user); // user테이블 update
		session.removeAttribute("user");
		session.setAttribute("user", user);

		return "mypage";
	}
	/*
	//업로드 GET
	@RequestMapping(value="upload", method=RequestMethod.GET)
	public String upload(Model model,HttpSession session){
		User user = (User) session.getAttribute("user");//user라는 객체를 가져옴.세션값을 가져와야 현재 접속한 아이디값을 얻을 수 있다.
		model.addAttribute("user", user);
		return "upload";
	}
	 */
	// 수강한 목록 엑셀 업로드
	@RequestMapping(value="mySubject_upload", method=RequestMethod.POST)
	public String mySubject_upload(Model model, @RequestParam("file") MultipartFile file,
			HttpSession session) throws Exception{
		User user = (User) session.getAttribute("user");

		if(!file.isEmpty()) {
			List<MySubject> mySubjects = excelService.getMySubjectList(file.getInputStream(), user.getUserId());
			mySubjectMapper.deleteById(user.getUserId());
			mySubjectMapper.insert(mySubjects);
			return "redirect:list";
		} else {
			return "redirect:mypage";//실패
		}
	}

	// list GET
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");

		int enterYear = Integer.parseInt(user.getUserId().substring(0, 4));

		Calendar c = Calendar.getInstance();
		int currentYear = c.get(Calendar.YEAR);

		List<MySubject> mySubjectlist = mySubjectMapper.findAll(user.getUserId());

		model.addAttribute("mySubjectlist", mySubjectlist);
		model.addAttribute("enterYear", enterYear);
		model.addAttribute("currentYear", currentYear);

		return "list";
	}

	@RequestMapping(value = "list", method = RequestMethod.POST)
	public String list(Model model, HttpSession session,
			@RequestParam("option") Object option, @RequestParam("srchText") Object srchText) {
		User user = (User) session.getAttribute("user");

		List<MySubject> mySubjectlist=null;

		if(option.equals("과목코드")) {

			mySubjectlist = mySubjectMapper.findByCode(user.getUserId(),(String) srchText);

		}else if(option.equals("과목명")) {

			mySubjectlist = mySubjectMapper.findByName(user.getUserId(),(String) srchText);

		}

		model.addAttribute("mySubjectlist", mySubjectlist);
		return "list";
	}


}
