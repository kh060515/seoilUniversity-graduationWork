package kr.ac.seoil.boardWeb.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import kr.ac.seoil.boardWeb.user.vo.UserVO;

@Service
@Aspect
public class LogAdvice {
	
	@Before("PointcutCommon.allPointcut()")
	public void beforeLogging(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println("[����ó��] " + method + "() �޼ҵ� ARGS ���� : " + args[0].toString());
	}
	
	@After("PointcutCommon.allPointcut()")
	public void afterLogging() {
		System.out.println("[����α�-Log4j] ����Ͻ� ���� ������ ����");
	}
	
	@AfterReturning(pointcut="PointcutCommon.getPointcut()", returning="returnObj")
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
	
	@AfterThrowing(pointcut="PointcutCommon.allPointcut()", throwing="exceptObj")
	public void afterThrowLog(JoinPoint jp, Exception exceptObj) {
		String method = jp.getSignature().getName();
		System.out.println("[����ó��] " + method + "() �޼ҵ� ���� �� ���ܹ߻�");
		System.out.println(exceptObj.getMessage());
	}
	
	@Around("PointcutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object obj = pjp.proceed();
		
		stopWatch.stop();
		System.out.println(method + "() �޼ҵ� ���࿡ �ɸ� �ð� :" 
				+stopWatch.getTotalTimeMillis() + "(ms)��");
		return obj;
	}
}









