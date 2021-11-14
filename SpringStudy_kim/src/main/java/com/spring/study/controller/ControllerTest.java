package com.spring.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller // @Component의 종류 3가지 - Controller, Service, Repository
public class ControllerTest {

	/*
	 * 왜 첫페이지때 GET을 호출해야 하나?
	 * 아무것도 하지않고 웹 브라우저를 열었을때 원하는 페이지로 갈수없다.
	 * 갈 수 있는 방법은 url을 호출해야지 갈 수 있다. 
	 * ex) localhost:8000/study/index + 엔터! => url 요청!
	 * 또는 href(a태그)나 버튼을 통해서 utl 요청을 보내는 것은 무조건 get요청!
	 * 
	 * POST요청을 보내는 방법은  submit밖에 없다! -> form태그에  post를 걸고 submit 버튼, 호출했을때 post요청은 갈 수 있다.
	 */
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index1(Model model1) {
		model1.addAttribute("name", "김경태");
		return "index/index";
	}
	
	@RequestMapping(value = "/index2", method = RequestMethod.GET)  // mapping주소는 동일한 것을 쓸 수없다.
	public ModelAndView index2(@RequestParam("phone")String phoneNumber) {
		/*
		 * @Requestparam => servlet에서 request.getParameter와 같다
		 * @RequestParam("phone")String phoneNumber
		 * -> Parameter name으로 넘어오는 value를 phoneNumber에 담겠다.
		 */
		ModelAndView mav = new ModelAndView("index/index");
		// url로 get요청하기 -> http://localhost:8000/study/index2?phone=01012345678 -> 물음표 뒷부분 쿼리스트링
		System.out.println(phoneNumber);
		mav.addObject("name", "김경태");
		return mav;
	
	/*
	public ModelAndView index2() {
		ModelAndView mav = new ModelAndView("index/index"); // 보여질 jsp파일 위치 넣기
		mav.addObject("name", "Test Name");
		return mav;
	*/
		//return new ModelAndView("index/index"); // ModelAndView의 객체 이기만 하면 된다.
	}
	
}
