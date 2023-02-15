package org.springframework.ddu.et;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * @author liuqingwen
 * @version 1.0
 * @Desc
 * @date 2023/2/15 11:36
 */
@Aspect
@Component
public class MyAspect {

	@DeclareParents(value = "org.springframework.ddu.et.UserService", defaultImpl = Verifier.class)
	public IVerifier verifier;

}
