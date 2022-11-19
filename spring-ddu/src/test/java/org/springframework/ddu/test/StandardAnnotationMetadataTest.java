package org.springframework.ddu.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.ddu.cg.AnnotationCg;

import java.lang.annotation.Repeatable;

/**
 * @author liuqingwen
 * @version 1.0
 * @Desc
 * @date 2022/11/17 13:37
 */
public class StandardAnnotationMetadataTest {

	public static void main(String[] args) {
		StandardAnnotationMetadata standardAnnotationMetadata = new StandardAnnotationMetadata(AnnotationCg.class, true);
		boolean annotated = standardAnnotationMetadata.isAnnotated(ComponentScan.class.getName());
		System.out.println(annotated);
		System.out.println(standardAnnotationMetadata.isAnnotated(Repeatable.class.getName()));

		System.out.println(standardAnnotationMetadata.getAnnotationAttributes(Repeatable.class.getName(), true));
		System.out.println(standardAnnotationMetadata.getAllAnnotationAttributes(Repeatable.class.getName(), true));
		System.out.println(standardAnnotationMetadata.getAllAnnotationAttributes(ComponentScan.class.getName(), true));


		standardAnnotationMetadata.getAnnotatedMethods(Bean.class.getName()).stream().forEach(
				v -> System.out.println(v.getMethodName())
		);



	}

}
