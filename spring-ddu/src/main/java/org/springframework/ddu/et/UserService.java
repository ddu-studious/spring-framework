package org.springframework.ddu.et;

import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

	public void eat() {
		System.out.println(this + ": 吃吃吃");
	}

	public void go() {
		System.out.println(this + ": 跑跑跑");
	}

}
