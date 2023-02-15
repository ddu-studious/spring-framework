package org.springframework;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.ddu.et.IUserService;
import org.springframework.ddu.et.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author liuqingwen
 * @version 1.0
 * @Desc
 * @date 2023/2/14 13:24
 */
public class ProxyTest {

	public static void main(String[] args) {

		UserService userService = new UserService();

		springProxy2Advisor(userService);

	}

	public static void springProxy2Advisor(UserService userService) {

		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(userService);
		proxyFactory.addAdvisor(new PointcutAdvisor() {
			@Override
			public Pointcut getPointcut() {
				return new StaticMethodMatcherPointcut() {
					@Override
					public boolean matches(Method method, Class<?> targetClass) {
						return method.getName().equalsIgnoreCase("eat");
					}
				};
			}

			@Override
			public Advice getAdvice() {
				return new org.aopalliance.intercept.MethodInterceptor() {
					@Override
					public Object invoke(MethodInvocation invocation) throws Throwable {
						System.out.println("... before ...");
						Object invoke = invocation.proceed();
						System.out.println("... after ...");
						return invoke;
					}
				};
			}

			@Override
			public boolean isPerInstance() {
				return false;
			}
		});

		UserService userService1 = (UserService) proxyFactory.getProxy();
		userService1.eat();
		userService1.go();

	}

	public static void springProxy(UserService userService) {
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(userService);
		proxyFactory.addAdvice(new org.aopalliance.intercept.MethodInterceptor() {
			@Override
			public Object invoke(MethodInvocation invocation) throws Throwable {
				System.out.println("... before ...");
				Object invoke = invocation.proceed();
				System.out.println("... after ...");
				return invoke;
			}
		});

//		UserService userService1 = (UserService) proxyFactory.getProxy();
		IUserService userService1 = (IUserService) proxyFactory.getProxy();
		userService1.eat();
	}


	public static void jdkProxy(UserService userService) {

		@SuppressWarnings({"unchecked", "rawtypes"})
		Object proxy = Proxy.newProxyInstance(userService.getClass().getClassLoader(), new Class[]{IUserService.class}, new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("... before ...");
				Object invoke = method.invoke(userService, args);
				System.out.println("... after ...");
				return invoke;
			}
		});

		IUserService userService1 = (IUserService) proxy;
		userService1.eat();

	}

	private static void enhancer(UserService userService) {
		// cglib 技术
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(UserService.class);

		enhancer.setCallbacks(new Callback[] {
				new MethodInterceptor() {
					@Override
					public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
						System.out.println("... before ...");
						Object invoke = methodProxy.invoke(userService, objects);
						System.out.println("... after ...");
						return invoke;
					}
				}
		});

		// 动态代理所创建出来的UserService对象
		UserService userService1 = (UserService) enhancer.create();

		// 执行这个eat方法时，就会额外执行一些其他逻辑
		userService1.eat();
	}

}
