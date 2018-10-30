package edu.spring.ex04;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	} // end home()
	
	@RequestMapping(value = "/test1",
			method = RequestMethod.GET)
	public String test1() {
		logger.info("test1() 호출"); 
		
		return "test";
	} // end test1()
	
	@RequestMapping(value = "/test2",
			method = RequestMethod.GET)
	public String test2(Model model) {
		logger.info("test2() 호출");
		model.addAttribute("data", "test2 호출 결과");
		
		return "test";
	} // end test2();
	
} // end class HomeController










