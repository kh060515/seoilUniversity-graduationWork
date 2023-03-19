package kr.ac.seoil.polymorphism;

import org.springframework.stereotype.Component;

@Component
public class AppleSpeaker implements Speaker {
	public AppleSpeaker() {
		System.out.println("AppleSpeaker 按眉 积己");
	}
	
	public void volumnUp() {
		System.out.println("AppleSpeaker 家府棵赴促.");
	}
	
	public void volumnDown() {
		System.out.println("AppleSpeaker 家府郴赴促.");
	}
}
