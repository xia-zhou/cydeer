package com.cydeer.core.study;

import java.util.Map;

/**
 * @author Cydeer on 16/6/18.
 */
public interface Channel {
	void registerAdapter(Integer messageId, Adapter adapter);

	void sendMessage(Integer messageId, Map<String, Object> param);
}
