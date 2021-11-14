package com.spring.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.study.model.CustomerModel;

@Controller
public class DeliveryController {

	@RequestMapping(value = "/delivery", method = RequestMethod.GET)  // delivery 페이지를 열어줍니다.
	public ModelAndView delivery(){  // 그냥 페이지를 열어줍니다. 가지고갈 모델이 딱히없다. 
		return new ModelAndView("delivery");
	}
	
	@RequestMapping(value = "/delivery-request", method = RequestMethod.POST)  // submit이 일어남 post요청
	public ModelAndView deliveryRequest(CustomerModel customerModel){  // deliveryInfo 페이지를 열어줍니다.
		ModelAndView mav = new ModelAndView("deliveryInfo");  // 객체 생성 -> deliveryInfo jsp파일 view 호출
		mav.addObject("customerModel", customerModel );  // 호출할때 객체 그대로 전달  customerModel 키값으로 customerModel을 그대로 전달해준다,
		return mav; // return할때 customerModel을 들고 deliveryInfo페이지 load
	}
	
	 // 둘다 같은 코드
	@RequestMapping(value = "/delivery-request2", method = RequestMethod.POST)  // delivery 페이지를 열어줍니다.
	/*
	 * 메서드가 같아도 충돌나지 않는이유?
	 * overroding하고 있고 매개 변수가 틀리기 때문에 매서드가 같아소 충돌이 나지 않는다.
	 */
	public String deliveryRequest(Model model, CustomerModel customerModel){
		model.addAttribute("customerModel", customerModel);
		return "deliveryInfo";
	}
}
