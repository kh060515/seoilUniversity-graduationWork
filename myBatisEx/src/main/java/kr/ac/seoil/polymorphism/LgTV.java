package kr.ac.seoil.polymorphism;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class LgTV implements TV {
//	@Autowired
//	@Qualifier("appleSpeaker")
	@Resource(name="sonySpeaker")
	private Speaker speaker;
	
	public void powerOn() {
		System.out.println("LgTV Àü¿ø ÄÒ´Ù.");
	}
	
	public void powerOff() {
		System.out.println("LgTV Àü¿ø ²ö´Ù.");
	}
	
	public void soundUp() {
		speaker.volumnUp();
	}
	
	public void soundDown() {
		speaker.volumnDown();
	}
}
