package com.spring.study.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void Main(String[] args) {
		
		/*
		AirConditionerRemoteControl airConditionerRemoteControl = new AirConditionerRemoteControl(); // 에어컨 객체 생성, 초기화
		TvRemoteControl tvRemoteControl1 = new TvRemoteControl();  // tv 객체 생성, 초기화
		TvRemoteControl tvRemoteControl2 = new TvRemoteControl();  // tv 객체 생성, 초기화
		
		CentralControl centralControl = new CentralControl(tvRemoteControl1, tvRemoteControl2); // 중앙제어컨트롤 객체 생성, 초기화
		
		airConditionerRemoteControl.on();
		airConditionerRemoteControl.off();
		tvRemoteControl1.on();
		tvRemoteControl2.off();
		
		centralControl.onAll();
		centralControl.offAll();
		*/
		
		// IOC컨테이너 불러오기
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/di/RemoteControlBeans.xml");
		// context.getBean =>centralControl 명칭을 가진 Bean을 하나 가져오겠다. 
		// Bean을 가져올때 Object 형태로 가져오기 때문에 다운캐스팅 해주어야함
		CentralControl centralControlDi = (CentralControl)context.getBean("centralControl");
		centralControlDi.onAll();
		centralControlDi.offAll();
		
		/*
		 * 원래라면 java 소스코드를 건드렸어야 하지만 
		 * 지금은 IOC컨테이너에서 reference값만 바꿔주면 바뀐다.
		 */
		
		
	}

}
