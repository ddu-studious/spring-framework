package org.springframework.ddu.test;

import org.springframework.ddu.et.OrderService;
import org.springframework.ddu.et.UserService;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * @author liuqingwen
 * @version 1.0
 * @Desc
 * @date 2022/12/1 23:43
 */
public class AutowireUtilsTest {

	public static void main(String[] args) {

		Constructor<?>[] constructors = OrderService.class.getConstructors();
		sortConstructors(constructors);
		System.out.println(Arrays.toString(constructors));
		System.out.println(Arrays.toString(UserService.class.getConstructors()));
	}

	// AutowireUtils
	public static void sortConstructors(Constructor<?>[] constructors) {
		Arrays.sort(constructors, (c1, c2) -> {
			boolean p1 = Modifier.isPublic(c1.getModifiers());
			boolean p2 = Modifier.isPublic(c2.getModifiers());
			if (p1 != p2) {
				return (p1 ? -1 : 1);
			}
			int c1pl = c1.getParameterCount();
			int c2pl = c2.getParameterCount();
			return (c1pl < c2pl ? 1 : (c1pl > c2pl ? -1 : 0));
		});
	}

}
