package kr.ac.seoil.polymorphism;

import org.springframework.stereotype.Component;

@Component
public class AppleSpeaker implements Speaker {
	public AppleSpeaker() {
		System.out.println("AppleSpeaker ��ü ����");
	}
	
	public void volumnUp() {
		System.out.println("AppleSpeaker �Ҹ��ø���.");
	}
	
	public void volumnDown() {
		System.out.println("AppleSpeaker �Ҹ�������.");
	}
}
