package org.springframework.ddu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.ddu.cg.AnnotationCg;
import org.springframework.ddu.et.UserService;

public class AppRun {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationCg.class);

		UserService userService = applicationContext.getBean(UserService.class);

		System.out.println(userService);
		userService.eat();

	}

}
