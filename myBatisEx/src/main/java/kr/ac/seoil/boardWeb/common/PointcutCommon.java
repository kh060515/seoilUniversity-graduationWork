package kr.ac.seoil.boardWeb.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {
	@Pointcut("execution(* kr.ac.seoil.boardWeb..impl.*Impl.*(..))")
	public void allPointcut() {}
	
	@Pointcut("execution(* kr.ac.seoil.boardWeb..service.*Service+.get*(..))")
	public void getPointcut() {}

}
