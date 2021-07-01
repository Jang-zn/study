package com.kh.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.spring.animal.Animal;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	// bean 을 변수에 대입하라는 annotation : @Autowired
	@Autowired
	private Fruit f;
	
	@Autowired
	@Qualifier("emp")
	private Employee e;
	
	@Autowired
	private Employee emp;
	
	@Autowired
	private Employee emp2;
	
	@Autowired(required=false)
	private Animal an;
	//required 주면 bean 있으면 넣고 없으면 null 처리해줌
	
	
	@Autowired
	@Qualifier("getPerson")
	private Person p;
	
	@Autowired
	@Qualifier("p2")
	private Person p2;
	//autowired 할때 변수명과 xml 설정된 id가 같으면 같은 class여도 알아서 바인딩함
	//수동으로 고르려면 qualifier 사용 (spring framework) / inject라고 java 기능도 있긴 함
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		
		System.out.println(f);
		System.out.println(e);
		System.out.println(an);
		System.out.println(p);
		System.out.println(p2);
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		Cookie c=new Cookie("time", "LastTime");
		c.setMaxAge(60*60*24);
		response.addCookie(c);
		return "index"; //default : requestDispatcher.forward
	}
	
}
