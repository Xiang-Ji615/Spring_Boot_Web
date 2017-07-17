package jj.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class JJAspect {
	
//	 && !@annotation(org.springframework.web.bind.annotation.InitBinder)
//	 && !@annotation(org.springframework.web.bind.annotation.ModelAttribute)
	@Before("execution(* jj.controller.*.*(..)) && !@annotation(org.springframework.web.bind.annotation.ModelAttribute)  && !@annotation(org.springframework.web.bind.annotation.InitBinder)")
	public void before() {
		System.out.println("Before triggered by AOP!!!!!!");
	}
}
