package com.cydeer.core.study;

import java.util.Map;

/**
 * @author Cydeer on 16/6/18.
 */
public interface MessageServiceVo {
	void sendMessage(Integer messasgeId, Map<String, Object> param);
}
