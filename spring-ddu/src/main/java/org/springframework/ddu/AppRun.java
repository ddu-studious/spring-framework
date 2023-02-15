package org.springframework.ddu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.ddu.cg.AnnotationCg;
import org.springframework.ddu.e.User;
import org.springframework.ddu.et.IUserService;
import org.springframework.ddu.et.IVerifier;

public class AppRun {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationCg.class);

		IUserService userService = (IUserService) applicationContext.getBean("userService");

		System.out.println(userService);
		userService.eat();

		IVerifier verifier = (IVerifier) userService;
		System.out.println(verifier.verify(new User()));

	}

}
