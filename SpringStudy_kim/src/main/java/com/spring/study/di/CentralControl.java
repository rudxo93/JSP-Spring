package com.spring.study.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 
 *
 * 중앙 제어 시스템
 *
 */
@Component
public class CentralControl {

	@Autowired
	/*
	 * @Autowired => 꼭 기본생성자가 있어야한다. 
	 * beans의 id값과 reference명칭과 같아야한다. 
	 * IOC컨테이너에서 찾을수 있어야 한다. 
	 * RemoteControlBeans 의
	 * <constructor-arg name="control1" ref="control1"></constructor-arg>
	 * <constructor-arg name="control2" ref="contorl3"></constructor-arg>
	 * 작업을 대신 해준 것 (=> 객체 생성 해준 부분)
	 */
	@Qualifier("c1")
	/*
	 * @Qualifier("beans의 명칭(id)")
	 */
	private RemoteControl control1; // 리모콘 1 생성
	@Autowired
	/*
	 * 자동으로 연결시켜 준다.
	 * beans의
	 * 	<bean id="control1" class="com.spring.study.di.AirConditionerRemoteControl">
		<property name="company" value="LG"></property><!-- setter => @Value -->
		</bean>
		객체를 / 명칭이 다르게 되면 찾지 못한다.
	 */
	@Qualifier("c2")
	private RemoteControl control2; // 리모콘 2 생성

	public CentralControl() {  // 아래의 생성자 대신에 기본 생성자 사용

	}

	/*
	 * private RemoteControl control1; // 리모콘 1 생성 
	 * private RemoteControl control2; // 리모콘 2 생성
	 */
	
	/*  // 생성자
	public CentralControl(RemoteControl control1, RemoteControl control2) { // 중앙 제어 시스템에서는 매개 변수 리모콘 1, 리모콘 2를 받아온다.
		this.control1 = control1; // CentralControl의 리모콘 1은 RemoteControl의 리모콘 1을 호출한다.
		this.control2 = control2; // CentralControl의 리모콘 2은 RemoteControl의 리모콘 2을 호출한다.
	}
	*/
	
	public void onAll() { // 모두 겨기
		control1.on();
		control2.on();
	}

	public void offAll() { // 모두 끄기
		control1.off();
		control2.off();
	}

}
