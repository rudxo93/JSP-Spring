package com.spring.study.di;

import org.springframework.stereotype.Component;

@Component("c2")
public class TvRemoteControl implements RemoteControl {

	/*
	 * 객체가 아님 => @Autowired가 아니라 @Value를 사용해야한다.
	 */
	private String company;
	

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public void on() {
		System.out.println(company + "Tv의 전원을 켭니다.");
	}
	
	@Override
	public void off() {
		System.out.println(company + "Tv의 전원을 끕니다.");
	}
}
