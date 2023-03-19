package kr.ac.seoil.polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SamsungTV implements TV {
	@Autowired
	private SonySpeaker speaker;

	private Integer price;
	
	public SamsungTV() {
		System.out.println("SamsungTV ����-1");
	}
	
	public SamsungTV(SonySpeaker speaker) {
		System.out.println("SamsungTV ����-2");
		this.speaker = speaker;
	}
	
	public SamsungTV(SonySpeaker speaker, Integer price) {
		System.out.println("SamsungTV ����-3");
		this.speaker = speaker;
		this.price = price;
	}
	
	public void initMethod() {
		System.out.println("SamsungTV ��ü �ʱ�ȭ ����");
	}
	
	public void destroyMethod() {
		System.out.println("SamsungTV ��ü ������ ������ ����ó��..");
	}
	
	public void powerOn() {
		System.out.println("SamsungTV -- ���� �Ҵ�. (���� :" + price + ")");
	}
	
	public void powerOff() {
		System.out.println("SamsungTV -- ���� ����.");
	}
	
	public void soundUp() {
		speaker.volumnUp();
		//System.out.println("SamsungTV -- �Ҹ� �ø���.");
	}
	
	public void soundDown() {
		speaker.volumnDown();
		//System.out.println("SamungTV -- �Ҹ� ������.");
	}
}
