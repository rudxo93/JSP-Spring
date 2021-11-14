package com.spring.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.study.model.UserInfoModel;

@Controller
public class UserInfoController {
	
	/*
	 *  단 view에서는 호출할 jsp파일에 encoding이 명시되어 있기 때문에 
	 *  produces = "text/html; charset=UTF-8 을 명시해주지 않는다.
	 */
	@RequestMapping(value = "/insert-info-insert", method = RequestMethod.GET)
	public ModelAndView userInfoInsert() {
		ModelAndView mav = new ModelAndView("userInfoInsert");
		return mav;  // ResponseBody가 없기 때문에 jsp 파일을 반환
	}
	
	/*
	 * tomcat필터에 들어가면서 encoding을 해주었지만
	 * 반대로 나올때는 encoding을 해주지 않았기 때문에
	 * produces = "text/html; charset=UTF-8을 추가해서 encoding을 해주어야한다.
	 * 추후 JSON으로 변환시켜서 넘긴다.
	 */
	@RequestMapping(value = "/insert-data", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
	@ResponseBody  // 데이터를 return
	/*
	 * Model class 사용  (3번)
	 * jsp의 input의 name들이 submit을 날리게 되면
	 * UserInfoModel(Dto) 클래스의 변수명과 일치하면 하나의 객체를 생성해서 객체 형태로 들고올 수 있다 
	 * public String insertData(UserInfoModel userInfoModel)
	 * -> 객체 생성후 userInfoModel로 받는다.
	 * 자동으로 set해준다.
	 */
	
	public String insertData(UserInfoModel userInfoModel) {
		System.out.println(userInfoModel.getUser_id());
		System.out.println(userInfoModel.getUser_password());
		System.out.println(userInfoModel.getUser_name());
		System.out.println(userInfoModel.getUser_phone());

		return userInfoModel.getUser_id() + " , " + userInfoModel.getUser_password() 
					+ " , " + userInfoModel.getUser_name() + " , " + userInfoModel.getUser_phone();
	}

}
	
	
	// 현재 가독성이 좋지않다..
	/*  1번
	 * @RequestParam("user-id")String id에서 쓰고있는 매개변수 명과 name명과 같다면
	 * 생략가능하다 -> @RequestParam String user-id -> 여기서 -는 쓸수가 없다.
	 * -를 쓸 수 없기 때문에 jsp에서 -가 아니라 _ 또는 카멜표기법을 주는 습관을 들이자
	public String insertData(@RequestParam("user-id")String id,  // input의 name값
										@RequestParam("user-password")String password,
										@RequestParam("user-name")String name,
										@RequestParam("user-phone")String phone
									) {
		System.out.println(id);
		System.out.println(password);
		System.out.println(name);
		System.out.println(phone);
		
		return id + " , " + password + " , " + name + " , " + phone; // -> 문자열 반환
		*/
	
	/* 2번
		// 가독성 좋게 수정하기
	public String insertData(@RequestParam String user_id,
										@RequestParam String user_password,
										@RequestParam String user_name,
										@RequestParam String user_phone
									) {
		System.out.println(user_id);
		System.out.println(user_password);
		System.out.println(user_name);
		System.out.println(user_phone);

		return user_id + " , " + user_password + " , " + user_name + " , " + user_phone;
	}
	*/

/*
 * 만드는 순서
 * 1. 클래스를 @Controller Component로 만들어 준다.
 * 2. 메서드 정의
 * 3. @RequestMapping 정의
 * 
 * spring을 사용하게 되면  jsp파일을 수정하더라도 서버 재실행이 필요없이 바로바로 바뀐다.
 * because
 * jsp파일 -> servlet 파일로 변환 시켜서 재해석을 하기 때문에
 * but 
 * spring은 jsp파일 view딴을 별도로 보기 때문에 jsp파일을 수정하더라도
 * 서버 재실행을 할 필요가 없다.
 */
