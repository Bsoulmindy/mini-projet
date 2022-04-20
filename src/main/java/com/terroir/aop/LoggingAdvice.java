package com.terroir.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
//import log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
 

@Aspect
@Component
public class LoggingAdvice {
	Logger log = LogManager.getLogger(LoggingAdvice.class);
	//save log in a file
 
    

	@Pointcut(value="execution(* *..IndexController.produit(int))")
	public void myPointcut() {
		
	}
	
	@Around("myPointcut()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();
		Object[] array = pjp.getArgs();

		log.info("method invoked " + className + " : " + methodName + "()" + "arguments : "
				+ mapper.writeValueAsString(array));

		Object object = pjp.proceed();

		log.info(className + " : " + methodName + "()" + "Response : "
				+ mapper.writeValueAsString(object));
		return object;


	}



/* 
 	Logger log = LoggerFactory.getLogger(LoggingAdvice.class);
	
	@Pointcut(value="execution(* com.javatechie.spring.aop.api.*.*.*(..) )")
	public void myPointcut() {
		
	}
	
	@Around("myPointcut()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();
		Object[] array = pjp.getArgs();
		log.info("method invoked " + className + " : " + methodName + "()" + "arguments : "
				+ mapper.writeValueAsString(array));
		Object object = pjp.proceed();
		log.info(className + " : " + methodName + "()" + "Response : "
				+ mapper.writeValueAsString(object));
		return object;
	}  */

}
