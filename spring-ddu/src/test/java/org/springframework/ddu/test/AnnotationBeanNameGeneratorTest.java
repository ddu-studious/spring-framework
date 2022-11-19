package org.springframework.ddu.test;

import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.ddu.cg.AnnotationCg;

/**
 * @author liuqingwen
 * @version 1.0
 * @Desc
 * @date 2022/11/17 17:50
 */
public class AnnotationBeanNameGeneratorTest {

	public static void main(String[] args) {

		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(AnnotationCg.class).getBeanDefinition();

		AnnotatedGenericBeanDefinition annotatedGenericBeanDefinition = new AnnotatedGenericBeanDefinition(AnnotationCg.class);

		AnnotationBeanNameGenerator annotationBeanNameGenerator = new AnnotationBeanNameGenerator();
		System.out.println(annotationBeanNameGenerator.generateBeanName(annotatedGenericBeanDefinition, null));
	}

}
