package com.spring.study;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.study.di.CentralControl;

/**
 * Handles requests for the application home page.
 */
@Controller  
// IOC 컨테이너에 해당 Class를 등록해준다.
// Component(Controller, Service, Repository)	
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private CentralControl centralControl;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// mapping 주소가 /hello인 주소로 doGet방식
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	// return값이 데이터로 날아감 home (ajax 사용할때) 페이지를 반환X
	// ResponseBody가 있다면 return값이 "home" 데이터 반환
	// 없다면 "/WEB-INF/views/home.jsp 페이지 반환
	@ResponseBody
	public String home(Locale locale, Model model) { // 반환형이 String일때는 매개면서 Model이 꼭 필요하다
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate ); // jsp에서 EL로 serverTime 키값으로 부를수 있다.
		
		centralControl.onAll();
		
		return "home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET) 
	// ModelAndView 를 사용 / 위와 같은 방식
	public ModelAndView home2(Locale locale) {  // ModelAndView 객체 자체에 Model이 포함되어 있다.
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		ModelAndView mav = new ModelAndView("home"); // jsp파일명
		mav.addObject("serverTime", formattedDate);  // 데이터를 실어보낼때 addObject 와 addAttribute 차이점 (key값, value)
		
		return mav;
	}
	
}
