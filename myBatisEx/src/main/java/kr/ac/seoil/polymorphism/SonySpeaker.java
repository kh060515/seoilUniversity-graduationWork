package kr.ac.seoil.polymorphism;

import org.springframework.stereotype.Component;

@Component
public class SonySpeaker implements Speaker {
	public SonySpeaker() {
		System.out.println("SonySpeaker ��ü ����");
	}
	
	public void volumnUp() {
		System.out.println("SonySpeaker �Ҹ��ø���.");
	}
	
	public void volumnDown() {
		System.out.println("SonySpeaker �Ҹ�������.");
	}
}
