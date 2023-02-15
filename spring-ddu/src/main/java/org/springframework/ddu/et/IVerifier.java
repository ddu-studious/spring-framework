package org.springframework.ddu.et;

import org.springframework.ddu.e.User;

/**
 * @author liuqingwen
 * @version 1.0
 * @Desc
 * @date 2023/2/15 11:35
 */
public interface IVerifier {

	boolean verify(User user);

}
