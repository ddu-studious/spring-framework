package org.springframework;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.ddu.e.User;
import org.springframework.validation.DataBinder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuqingwen
 * @version 1.0
 * @Desc
 * @date 2023/3/1 16:43
 */
public class DataBinderTest {

	public static void main(String[] args) {

		User user = new User();

		DataBinder dataBinder = new DataBinder(user);
		// Set ignored*
		dataBinder.setIgnoreInvalidFields(true);
		dataBinder.setIgnoreUnknownFields(true);
		// Get properties under specified prefix from PropertySources
		Map<String, Object> properties = new HashMap<>();
		properties.put("name", "liuqingwen");
		properties.put("age", 32);
		// Convert Map to MutablePropertyValues
		MutablePropertyValues propertyValues = new MutablePropertyValues(properties);
		// Bind
		dataBinder.bind(propertyValues);

		System.out.println(user);

	}

}
