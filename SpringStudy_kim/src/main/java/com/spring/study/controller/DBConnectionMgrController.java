package com.spring.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.study.model.dao.UserDao;

@Controller
public class DBConnectionMgrController {
	
	@Autowired
	/*
	 * 전역으로 객체를 생성해서 사용해야 되는 경우 @Autowired하는게 좋다.
	 */
	private UserDao userDao; // 객체 등록
	
	@RequestMapping(value = "/getUserData", method =RequestMethod.GET, produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String userData(@RequestParam String email) {
		
		return userDao.getUser(email).toString();
	}

}
