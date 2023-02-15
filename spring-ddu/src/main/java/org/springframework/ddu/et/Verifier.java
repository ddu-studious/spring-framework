package org.springframework.ddu.et;

import org.springframework.ddu.e.User;

/**
 * @author liuqingwen
 * @version 1.0
 * @Desc
 * @date 2023/2/15 11:36
 */
public class Verifier implements IVerifier {

	@Override
	public boolean verify(User user) {
		return false;
	}
}
