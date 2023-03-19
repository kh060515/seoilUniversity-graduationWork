package kr.ac.seoil.polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SamsungTV implements TV {
	@Autowired
	private SonySpeaker speaker;

	private Integer price;
	
	public SamsungTV() {
		System.out.println("SamsungTV 생성-1");
	}
	
	public SamsungTV(SonySpeaker speaker) {
		System.out.println("SamsungTV 생성-2");
		this.speaker = speaker;
	}
	
	public SamsungTV(SonySpeaker speaker, Integer price) {
		System.out.println("SamsungTV 생성-3");
		this.speaker = speaker;
		this.price = price;
	}
	
	public void initMethod() {
		System.out.println("SamsungTV 객체 초기화 실행");
	}
	
	public void destroyMethod() {
		System.out.println("SamsungTV 객체 삭제전 실행할 로직처리..");
	}
	
	public void powerOn() {
		System.out.println("SamsungTV -- 전원 켠다. (가격 :" + price + ")");
	}
	
	public void powerOff() {
		System.out.println("SamsungTV -- 전원 끈다.");
	}
	
	public void soundUp() {
		speaker.volumnUp();
		//System.out.println("SamsungTV -- 소리 올린다.");
	}
	
	public void soundDown() {
		speaker.volumnDown();
		//System.out.println("SamungTV -- 소리 내린다.");
	}
}
