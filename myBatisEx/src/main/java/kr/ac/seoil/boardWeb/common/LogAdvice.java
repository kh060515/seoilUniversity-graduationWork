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
		System.out.println("[사전처리] " + method + "() 메소드 ARGS 정보 : " + args[0].toString());
	}
	
	@After("PointcutCommon.allPointcut()")
	public void afterLogging() {
		System.out.println("[공통로그-Log4j] 비즈니스 로직 수행후 동작");
	}
	
	@AfterReturning(pointcut="PointcutCommon.getPointcut()", returning="returnObj")
	public void afterReturnLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		if (returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			System.out.println(user.getUserName() + "로그인(" + user.getRole() + ")");
		}
		
		String ret = "void";
		if (returnObj != null) {
			ret = returnObj.toString();
		}
		
		System.out.println("[사후처리] " + method + "() 메소드 리턴값 : " + ret);
	}
	
	@AfterThrowing(pointcut="PointcutCommon.allPointcut()", throwing="exceptObj")
	public void afterThrowLog(JoinPoint jp, Exception exceptObj) {
		String method = jp.getSignature().getName();
		System.out.println("[예외처리] " + method + "() 메소드 수행 중 예외발생");
		System.out.println(exceptObj.getMessage());
	}
	
	@Around("PointcutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object obj = pjp.proceed();
		
		stopWatch.stop();
		System.out.println(method + "() 메소드 수행에 걸린 시간 :" 
				+stopWatch.getTotalTimeMillis() + "(ms)초");
		return obj;
	}
}









