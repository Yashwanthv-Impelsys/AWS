package org.impelsys.SpringBootDemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserServiceAspect {
	
	@Pointcut("execution(* org.impelsys.SpringBootDemo.dao.impl.UserDaoImpl.*(..))")
	public void userDaoMapping() {
		
	}
	
	//Advice -> what is the functionality to be done/what is the action to be taken
		//pointcut -> the condition to search for 
		//JoinPoint -> it is a point during the execution of the program
		//UserDaoImpl *-> for any return type of userdaoimpl  (..) -> any number of arguments
	@Before("userDaoMapping()") //PointCut
	public void beforeAdvice(JoinPoint joinPoint) 
	{
		System.out.println("Before method :"+joinPoint.getSignature());
	}
	
	//JoinPoint -> it is a point during the execution of the program
	@After("userDaoMapping()")
	public void afterAdvice(JoinPoint joinPoint) {
		System.out.println("After method :"+joinPoint.getSignature());
	}
}
