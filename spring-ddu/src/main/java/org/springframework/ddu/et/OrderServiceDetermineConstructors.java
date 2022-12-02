package org.springframework.ddu.et;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liuqingwen
 * @version 1.0
 * @Desc
 * @date 2022/12/2 08:10
 */
//@Component
public class OrderServiceDetermineConstructors implements SmartInstantiationAwareBeanPostProcessor {

	@Override
	public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
		Constructor<?>[] constructors = beanClass.getConstructors();
		Arrays.sort(constructors, Comparator.comparing((Constructor<?> ctr) -> ctr.getParameterCount()).reversed());
		return new Constructor<?>[]{constructors[0]};
	}

}
