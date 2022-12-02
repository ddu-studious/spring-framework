package org.springframework.ddu.et;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liuqingwen
 * @version 1.0
 * @Desc
 * @date 2022/12/1 23:42
 */
@Component
public class OrderService {

//	public OrderService() {}

//	@Autowired(required = false)
	public OrderService(UserService userService) {
		System.out.println("OrderService-Constructor-1");
	}

	@Autowired
	public OrderService(UserService userService, UserService userService2) {
		System.out.println("OrderService-Constructor-2");
	}

}
