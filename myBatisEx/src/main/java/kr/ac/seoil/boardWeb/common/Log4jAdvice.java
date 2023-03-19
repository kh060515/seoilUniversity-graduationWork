package kr.ac.seoil.boardWeb.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import kr.ac.seoil.boardWeb.user.vo.UserVO;

public class Log4jAdvice {
	private final Logger LOG=LoggerFactory.getLogger(getClass());
	
	public void beforeLogging(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		LOG.debug("[사전처리] " + method + "() 메소드 ARGS 정보 : " + args[0].toString());
	}
	
	public void afterLogging() {
		System.out.println("[����α�-Log4j] ����Ͻ� ���� ������ ����");
	}
	
	public void afterReturnLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		if (returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			System.out.println(user.getUserName() + "�α���(" + user.getRole() + ")");
		}
		
		String ret = "void";
		if (returnObj != null) {
			ret = returnObj.toString();
		}
		
		System.out.println("[����ó��] " + method + "() �޼ҵ� ���ϰ� : " + ret);
	}
	
	public void afterThrowLog(JoinPoint jp, Exception exceptObj) {
		String method = jp.getSignature().getName();
		System.out.println("[����ó��] " + method + "() �޼ҵ� ���� �� ���ܹ߻�");
		System.out.println(exceptObj.getMessage());
	}
	
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		System.out.println("#################");
		Object obj = pjp.proceed();
		
		stopWatch.stop();
		System.out.println(method + "() �޼ҵ� ���࿡ �ɸ� �ð� :" 
				+stopWatch.getTotalTimeMillis() + "(ms)��");
		return obj;
	}
}










