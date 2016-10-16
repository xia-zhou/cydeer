package com.cydeer.core.study;

import java.util.Map;

/**
 * @author Cydeer on 16/6/18.
 */
public class MessageServiceVoImpl implements MessageServiceVo {

	@Override public void sendMessage(Integer messasgeId, Map<String, Object> param) {
		new MessageServiceImpl().sendMessage(messasgeId, param);
	}
}
